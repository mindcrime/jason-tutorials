package agent;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.logging.Logger;

import javax.management.Attribute;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import jason.asSemantics.Agent;
import jason.asSemantics.Event;
import jason.asSemantics.Intention;
import mbean.AgentStats;
import mbean.AgentStatsMBean;

public class JmxAgent extends Agent
{
	private Logger logger = Logger.getLogger( JmxAgent.class.getName() );

	
	@Override
	public Event selectEvent( Queue<Event> events )
	{

		// Iterator eventIter = events.iterator();
		StringBuilder sb = new StringBuilder();
		for( Event event : events )
		{
			sb.append(  event.toString() + "\n" );
		}
		
		logger.info(  "selectEvent called. Stack of Events is currently: \n" + sb.toString() );
		
		return super.selectEvent( events );
	}
	
	
	@Override
	public Intention selectIntention( Queue<Intention> intentions )
	{
		try
		{
			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

			ObjectName agentStatsMBeanName = new ObjectName("org.fogbeam.example.jason.jmx:type=AgentStats");
		
			MBeanInfo agentStatsMBeanInfo = null;
			try
			{
				agentStatsMBeanInfo = mbs.getMBeanInfo( agentStatsMBeanName );
			}
			catch( InstanceNotFoundException infe )
			{
				// infe.printStackTrace();
				logger.info(  "Existing MBean instance not found!" );
			}
			
			AgentStatsMBean agentStatsMBean = null;

			int cycleNumber = this.ts.getAgArch().getCycleNumber();
			
			StringBuilder sb = new StringBuilder();
			intentions.forEach( i -> { sb.append( i.toString() + "\n\n" ); } );
	
			
			if( agentStatsMBeanInfo == null )
			{
				agentStatsMBean = new AgentStats();
				agentStatsMBean.setCurrentCycle( cycleNumber );
				agentStatsMBean.setIntentions(sb.toString());
				mbs.registerMBean(agentStatsMBean, agentStatsMBeanName);
			}
			else
			{
				
				MBeanAttributeInfo[] attrs = agentStatsMBeanInfo.getAttributes();
				
				logger.info( "Attributes: " );
				for( MBeanAttributeInfo attrInfo : attrs )
				{
					Object attrExisting = mbs.getAttribute( agentStatsMBeanName, attrInfo.getName() );
					
					// logger.info( "[existing] -> [attribute] " + attrInfo.getName() +  " [type] " + attrInfo.getType() + " [value] " + attrExisting.toString() );
					
				}
				
				Attribute cycleNumAttrNew = new Attribute("CurrentCycle", cycleNumber);
				
				logger.info( "[updated] -> [attribute] " + cycleNumAttrNew.getName() + " [value] " + cycleNumAttrNew.getValue());				

				mbs.setAttribute( agentStatsMBeanName, cycleNumAttrNew );
			
				Attribute intentionsNew = new Attribute( "Intentions", sb.toString());
				mbs.setAttribute( agentStatsMBeanName, intentionsNew );
				
				
			}
		
			boolean proceed = false;
			while( !proceed )
			{
				// block here until proceed is true
				try
				{
					Thread.sleep( 1500 );
				}
				catch( InterruptedException ie )
				{}	
				
				proceed = (boolean)mbs.getAttribute( agentStatsMBeanName, "Proceed" );
				mbs.setAttribute( agentStatsMBeanName, new Attribute( "Proceed", false) );
			}
			
			logger.info(  "moving on..." );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		return super.selectIntention( intentions );
	}
}

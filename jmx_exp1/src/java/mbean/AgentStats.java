package mbean;

import java.util.logging.Logger;

public class AgentStats implements AgentStatsMBean
{
	
	private Logger logger = Logger.getLogger( AgentStats.class.getName() );
	
	private int currentCycle;
	private String intentions;
	private boolean proceed;
	
	@Override
	public int getCurrentCycle()
	{
		return this.currentCycle;
	}
	
	@Override
	public void setCurrentCycle( int cycleNum )
	{
		this.currentCycle = cycleNum;
	}

	@Override
	public String getIntentions()
	{
		return this.intentions;
	}

	@Override
	public void setIntentions( String intentions )
	{
		this.intentions = intentions;
	}

	public boolean isProceed()
	{
		return proceed;
	}

	@Override
	public void setProceed( boolean proceed )
	{
		this.proceed = proceed;
	}
	
	/* operations */
	
	public void doProceed()
	{
		this.proceed = true;
	}
	
	@Override
	public int add( int x, int y )
	{
		return (x+y);
	}
	
	@Override
	public void sayHello()
	{
		logger.warning(  "Hello, from AgentStats MBean!!!" );
	}
	
}
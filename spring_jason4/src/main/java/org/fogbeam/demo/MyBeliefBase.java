package org.fogbeam.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import jason.asSyntax.Literal;
import jason.bb.DefaultBeliefBase;

public class MyBeliefBase extends DefaultBeliefBase implements InitializingBean
{
	private Logger logger = Logger.getLogger( MyBeliefBase.class.getName() );

	@Autowired
	MyService myService;

	List<Literal> initialBeliefs = new ArrayList<Literal>();
	
	@Override
	public void afterPropertiesSet() throws Exception
	{
		
		// copy Beliefs from in memory temporary store to wherever they really go?
		// myService is no longer null, so these calls should all work fine?
		
		for( Literal l : initialBeliefs )
		{
			add(l);
		}
		
	}
	
	@Override
	public boolean add( Literal l )
	{
		if( myService != null )
		{
			logger.info(  "add: " + myService.getRandomData( 12 )  );
			return super.add( l );
		}
	
		this.initialBeliefs.add( l );
		return true;
	}

	@Override
	public boolean add( int index, Literal l )
	{
		if( myService != null )
		{
			logger.info(  "add: " + myService.getRandomData( 12 )  );
			return super.add( index, l );
		}
		
		this.initialBeliefs.add( l );
		return true;
	}


	@Override
	public Literal contains( Literal l )
	{
		if( myService != null )
		{
			logger.info(  "contains: " + myService.getRandomData( 12 )  );
			return super.contains( l );
		}
	
		return null;
	}
	 
	 
	 
}

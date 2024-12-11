package org.fogbeam.demo;

import java.util.logging.Logger;

import org.fogbeam.demo.spring.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

import jason.asSyntax.Literal;
import jason.bb.DefaultBeliefBase;

public class MyBeliefBase2 extends DefaultBeliefBase
{
	private Logger logger = Logger.getLogger( MyBeliefBase2.class.getName() );

	@Autowired
	MyService myService;

	public MyBeliefBase2()
	{
		ApplicationContext appContext = SpringContextHolder.getAppContext();
		
		appContext.getAutowireCapableBeanFactory().autowireBeanProperties( this, AutowireCapableBeanFactory.AUTOWIRE_AUTODETECT, false );
	}
	
	@Override
	public boolean add( Literal l )
	{
		logger.info(  "add: " + myService.getRandomData( 12 )  );
		return super.add( l );	
	}

	@Override
	public boolean add( int index, Literal l )
	{
		logger.info(  "add: " + myService.getRandomData( 12 )  );
		return super.add( index, l );
	}


	@Override
	public Literal contains( Literal l )
	{
		logger.info(  "contains: " + myService.getRandomData( 12 )  );
		return super.contains( l );
	}
	 
}

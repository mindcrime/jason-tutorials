package org.fogbeam.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import jason.architecture.AgArch;
import jason.asSemantics.ActionExec;
import jason.asSemantics.Message;

public class MyAgentArch extends AgArch
{
    private Logger logger = Logger.getLogger( MyAgentArch.class.getName() );
	
	
	@Autowired
	MyService myService;
	
	
	@Override
	public void checkMail()
	{
		logger.info( "checkMail: " + myService.getRandomData( 12 ) );
		super.checkMail();
	}

	@Override
	public void act( ActionExec action )
	{
		logger.info( "act: " + myService.getRandomData( 12 ) );
		super.act( action );
	}

	@Override
	public void actionExecuted( ActionExec act )
	{
		logger.info( "actionExecuted: " + myService.getRandomData( 12 ) );
		super.actionExecuted( act );
	}

	@Override
	public void broadcast( Message m ) throws Exception
	{
		logger.info( "broadcast: " + myService.getRandomData( 12 ) );
		super.broadcast( m );
	}
	
}

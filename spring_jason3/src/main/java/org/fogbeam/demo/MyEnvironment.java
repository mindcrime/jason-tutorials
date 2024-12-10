package org.fogbeam.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.environment.Environment;

@Component
public class MyEnvironment extends Environment
{
	private Logger logger = Logger.getLogger( MyEnvironment.class.getName() );
	
	public static final Literal rebootMatrix  = Literal.parseLiteral("reboot(matrix)");
	
	@Autowired
	MyService myService;
	
	
	/** Called before the MAS execution with the args informed in .mas2j */
	@Override
	public void init( String[] args )
	{
		super.init( args );
		// updatePercepts();
	}

	@Override
	public boolean executeAction( String agName, Structure action )
	{
		logger.info( "executing: " + action.toString() );
		
		boolean actionResult = false;
		
		if( action.equals( rebootMatrix ) )
		{
			actionResult = rebootMatrixAction();
		}
		else
		{
			logger.info("Not implemented yet");
		}
		
		if( actionResult )
		{ 
			// you may improve this condition
			informAgsEnvironmentChanged();
		}
		
		return actionResult;
	}

	// Implementing the rebootMatrix action
	public boolean rebootMatrixAction()
	{
		// System.out.println("Rebooting matrix...");
		logger.info( "Rebooting matrix..." );
		
		logger.info(  "Random key: " + myService.getRandomData(12) );
		
		return true;
	}
	
	
	/** Called before the end of MAS execution */
	@Override
	public void stop()
	{
		super.stop();
	}
	
	
}

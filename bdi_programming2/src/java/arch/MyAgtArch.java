package arch;

import java.util.Collection;
import java.util.logging.Logger;

import env.Env;
import jason.architecture.AgArch;
import jason.asSemantics.ActionExec;
import jason.asSyntax.Literal;

public class MyAgtArch extends AgArch
{
    private Logger logger = Logger.getLogger( MyAgtArch.class.getName() );
	
    private boolean detailedCycleLoggingEnabled = true;
    
    public void disableDetailedCycleLogging()
    {
    	this.detailedCycleLoggingEnabled = false;
    }
    
    @Override
    public void checkMail()
    {
    	if( this.detailedCycleLoggingEnabled )
    	{
    		logger.info( "checkMail() called!" );
    	}
    	
    	super.checkMail();
    }
    
	@Override
	public void act( ActionExec action )
	{
		logger.info(  "********\naction: " + action.toString() + "\n********\n");
		
		super.act( action );
	}
	
	@Override
	public void reasoningCycleStarting()
	{
		if( this.detailedCycleLoggingEnabled )
		{
			logger.info(  "Reasoning Cycle Starting!" );
		}
		
		super.reasoningCycleStarting();
	}
	
	@Override
	public void reasoningCycleFinished()
	{
		if( this.detailedCycleLoggingEnabled)
		{
			logger.info(  "Reasoning Cycle Finished!" );
		}
		
		super.reasoningCycleFinished();
	}
	
	@Override
	public void actionExecuted( ActionExec act )
	{
		logger.info(  "********\nAction executed!\n" + act.toString() );
		logger.info(  "Action intention: " + act.getIntention().toString() );
		logger.info(  "Action term: " + act.getActionTerm().toString() + "\n********\n");
		super.actionExecuted( act );
	}
	
	@Override
	public Collection<Literal> perceive()
	{
		if( this.detailedCycleLoggingEnabled )
		{
			logger.info(  "perceive() invoked!!" );
		}
		
		return super.perceive();
	}
}

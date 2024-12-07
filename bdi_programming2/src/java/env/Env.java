package env;

import java.util.logging.Logger;

// Environment code for project domestic_robot_from_scratch
import jason.asSyntax.Literal;
import jason.asSyntax.NumberTerm;
import jason.asSyntax.Structure;
import jason.environment.Environment;
import jason.environment.grid.Location;
import model.*;

public class Env extends Environment 
{
    // common literals
    // public static final Literal of  = Literal.parseLiteral("open(fridge)");
	
    private Logger logger = Logger.getLogger( Env.class.getName() );

    WorldModel model; // the model of the grid    
    
    
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) 
    {
        super.init(args);
        
        // logger.info( "init() arg[0] = " + args[0] );
        
        model = new WorldModel();

        if (args.length == 1 && args[0].equals("gui")) 
        {
            WorldView view  = new WorldView(model);
            model.setView(view);
        }
        
        updatePercepts();
    }

    @Override
    public boolean executeAction(String agName, Structure action) 
    {
        
    	logger.info("executing: " + action );
        
        boolean result = false;

        // TODO: implement Action and capture result
    	
    	
        if (result) 
        {
            updatePercepts();
            informAgsEnvironmentChanged();
            try 
            {
                Thread.sleep(100);
            } 
            catch( Exception e )
            {}
        }

    	
        return result; // the action was executed with success
    }
    
    /** creates the agents percepts based on the HouseModel */
    void updatePercepts() 
    {
        // clear the percepts of the agents
        clearPercepts("agent1");
        clearPercepts("agent2");

        /* 
        if( model.something > 0)
        {
            addPercept("agent1", whatever );
            addPercept("agent2", whatever );
        }  
        */      
        
    }
    
}

package model;

import java.util.logging.Logger;

import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

public class WorldModel extends GridWorldModel
{
    Logger logger = Logger.getLogger( WorldModel.class.getName() );
	
	// constants for the grid objects
    // public static final int FRIDGE = 16;
    // public static final int OWNER  = 32;

    // the grid size
    public static final int GSize = 7;

    
    public WorldModel() 
    {
        // create a 7x7 grid with one mobile agent
        super(GSize, GSize, 1);
        
        // initial location of robot (column 3, line 3)
        // ag code 0 means the robot
        setAgPos(0, GSize/2, GSize/2);
        
    }
}

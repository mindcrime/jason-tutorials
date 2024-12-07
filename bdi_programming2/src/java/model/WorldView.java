package model;
import jason.environment.grid.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/** class that implements the View of Domestic Robot application */
public class WorldView extends GridWorldView {

    WorldModel hmodel;

    public WorldView(WorldModel model) {
        super(model, "BlankAgent", 700);
        hmodel = model;
        defaultFont = new Font("Arial", Font.BOLD, 16); // change default font
        setVisible(true);
        repaint();
    }

    /** draw application objects */
    @Override
    public void draw(Graphics g, int x, int y, int object) {
        /* 
        Location lRobot = hmodel.getAgPos(0);
        super.drawAgent(g, x, y, Color.lightGray, -1);
        switch (object) {
        case WorldModel.FRIDGE:
            if (lRobot.equals(hmodel.lFridge)) {
                super.drawAgent(g, x, y, Color.yellow, -1);
            }
            g.setColor(Color.black);
            drawString(g, x, y, defaultFont, "Fridge ("+hmodel.availableBeers+")");
            break;
        case WorldModel.OWNER:
            if (lRobot.equals(hmodel.lOwner)) {
                super.drawAgent(g, x, y, Color.yellow, -1);
            }
            String o = "Owner";
            if (hmodel.sipCount > 0) {
                o +=  " ("+hmodel.sipCount+")";
            }
            g.setColor(Color.black);
            drawString(g, x, y, defaultFont, o);
            break;
        }
        repaint();
        */
    }

    @Override
    public void drawAgent(Graphics g, int x, int y, Color c, int id) {
        /* 
        Location lRobot = hmodel.getAgPos(0);
        if (!lRobot.equals(hmodel.lOwner) && !lRobot.equals(hmodel.lFridge)) {
            c = Color.yellow;
            if (hmodel.carryingBeer) c = Color.orange;
            super.drawAgent(g, x, y, c, -1);
            g.setColor(Color.black);
            super.drawString(g, x, y, defaultFont, "Robot");
        }
        */
    }
}

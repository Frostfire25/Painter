/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.timers;

import com.alexander.elguezabal2.managers.DrawingManager;
import com.alexander.elguezabal2.managers.ImageManager;
import java.awt.MouseInfo;
import java.awt.Point;

/**
 *
 * @author Alex
 */
public class DrawingTimer extends ATimer<DrawingTimer> {
    
    private DrawingManager drawingManger;
    
    private static final int IMAGE_AWAY_FROM_BORDER_X = 207;
    private static final int IMAGE_AWAY_FROM_BORDER_Y = 186;
    
    public DrawingTimer(DrawingManager drawingManger) {
        super(50, 1);
        
        this.drawingManger = drawingManger;
    }

    @Override
    public DrawingTimer get() {
        return this;
    }

    @Override
    public void run() {
        //Point point1 = MouseInfo.getPointerInfo().getLocation();
        //System.out.println(point1.getX() + " " + point1.getY());

        if (DrawingManager.isDrawing()) {
            System.out.println("drawing");

            Point oP = MouseInfo.getPointerInfo().getLocation();
            Point point = new Point((int) (oP.getX() - IMAGE_AWAY_FROM_BORDER_X), (int) (oP.getY() - IMAGE_AWAY_FROM_BORDER_Y));

            if (!isOutOfBoudns(oP, DrawingManager.getSelectedTool().getSize())) {

                // If the drawing is out of the image frame, then we will fixe the image
                try {
                    DrawingManager.getSelectedTool().draw(point);
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    
    /**
     * Determines if the point is out of bounds for the picture
     * 
     * @param point The point to be checked
     * @return true if it is out of bounds, false if not.
     */
    private boolean isOutOfBoudns(Point point, int size) {
        if(point.getX() > (ImageManager.IMAGE_WIDTH + IMAGE_AWAY_FROM_BORDER_X + size) || point.getY() > (ImageManager.IMAGE_HEIGHT + IMAGE_AWAY_FROM_BORDER_Y + size))
            return true;
        
        if(point.getX() < (IMAGE_AWAY_FROM_BORDER_X + size) || point.getY() < (IMAGE_AWAY_FROM_BORDER_Y + size))
            return true;
            
        return false;
    }
    
}

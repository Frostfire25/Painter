/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.managers.drawing.Pen;
import com.alexander.elguezabal2.managers.drawing.Tool;
import com.alexander.elguezabal2.managers.drawing.ToolType;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Alex
 */
public class DrawingManager {
    
    private static Pen pen;
    private static Tool selectedTool;
    
    private static HashSet<Tool> allTools;
    
    public DrawingManager() {        
        // Starts the init process
        init();
    }
    
    /**
     * Changes the selected tool to one of a type
     * @param toolType 
     */
    public static void changeSelectedTool(ToolType toolType) {
        Tool tool = allTools.stream().filter(Objects::nonNull).filter(n -> n.getToolType() == toolType).findFirst().orElse(null);
        selectedTool = tool;
    }
    
    /**
     * Initilize method
     */
    private void init() { 
        // Instantilizes all tools and adds them to the allTools collection.
        allTools = new HashSet<>();
        pen = new Pen();
        
        allTools.add(pen);
        
        selectedTool = null;
        
        initTimer();
    }
    
    private static final int IMAGE_AWAY_FROM_BORDER_X = 207;
    private static final int IMAGE_AWAY_FROM_BORDER_Y = 186;
    
    /**
     * Starts the timer for drawing
     */
    private void initTimer() {
        long delay = 50L;
        long period = 1L;
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {        
                 //Point point1 = MouseInfo.getPointerInfo().getLocation();
                 //System.out.println(point1.getX() + " " + point1.getY());

                if(isDrawing) {                    
                    Point oP = MouseInfo.getPointerInfo().getLocation();
                    Point point = new Point((int) (oP.getX() - IMAGE_AWAY_FROM_BORDER_X), (int) (oP.getY() - IMAGE_AWAY_FROM_BORDER_Y));
                                        
                    if (!isOutOfBoudns(oP, selectedTool.getSize())) {
                        Painter.getMainImageManager().paintOnImage(point, selectedTool.getColor(), selectedTool.getSize());
                    }
                }
            }
        }, delay, period);

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
   
    private HashMap<Point, Color> pointToColor = new HashMap<>();
    private boolean isDrawing = false;
    
    /**
     * Called when a person presses inside the draw table
     */
    public void pressed() {
        if(selectedTool != null && selectedTool.getToolType() != ToolType.NONE) {
            System.out.println("pressed");
            isDrawing = true;
        }
    }
    
     /**
     * Called when a person releases inside the draw table
     */
    public void released() {
        if(selectedTool != null && selectedTool.getToolType() != ToolType.NONE) {
            System.out.println("released");
            isDrawing = false;
        }
    }
        
    /**
     * Changes the color of the current tool
     * 
     * @param color Color to be changed to
     */
    public void updateColor(Color color) {
        if(selectedTool != null && selectedTool.getToolType() != ToolType.NONE) {
            selectedTool.setColor(color);
        }
    }
    
}

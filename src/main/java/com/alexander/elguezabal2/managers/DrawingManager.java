/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers;

import com.alexander.elguezabal2.managers.drawing.Pen;
import com.alexander.elguezabal2.managers.drawing.Tool;
import com.alexander.elguezabal2.managers.drawing.ToolType;
import java.awt.Color;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Takes all the input and output for drawing.
 * Painting is done in DrawingTimer.java
 * @author Alex
 */
public class DrawingManager {
    
    private static Pen pen;
    private static Tool selectedTool;
    
    private static Set<Tool> allTools;
    
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
    }        
     
    private static boolean isDrawing = false;
    
    /**
     * Called when a person presses inside the draw table
     */
    public void pressed() {
        System.out.println(""+ (getSelectedTool() == null) + " Tool Name: " + getSelectedTool().getToolType().name());

     
        if(getSelectedTool() != null && getSelectedTool().getToolType() != ToolType.NONE && !isDrawing) {
            System.out.println("pressed");
            isDrawing = true;
        }
    }
    
     /**
     * Called when a person releases inside the draw table
     */
    public void released() {
        // If the mouse is ever released, we always want it not to draw.
        isDrawing = false;
        
    }
        
    /**
     * Changes the color of the current tool
     * 
     * @param color Color to be changed to
     */
    public void updateColor(Color color) {
        if(getSelectedTool() != null && getSelectedTool().getToolType() != ToolType.NONE) {
            getSelectedTool().setColor(color);
        }
    }
    
    /**
     * Gets the current color of the current drawing tool
     * 
     * @return Color of the current drawing tool.
     */
    public Color getCurrentColor() {
        if(getSelectedTool() == null || getSelectedTool().getToolType() == ToolType.NONE) return Color.BLACK;
        
        return getSelectedTool().getColor();
    }

    /**
     * @return the isDrawing
     */
    public static boolean isDrawing() {
        return isDrawing;
    }

    /**
     * @return the selectedTool
     */
    public static Tool getSelectedTool() {
        return selectedTool;
    }
    
}

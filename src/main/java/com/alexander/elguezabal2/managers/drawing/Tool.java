/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.drawing;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Alex
 */
public abstract class Tool<T extends Tool> {
  
    private ToolType toolType;
    private Color color;
    public int size;
    
    /**
     * Default Constructor
     * 
     * @param toolType The type of tool this is
     */
    public Tool(ToolType toolType, Color color, int size) {
        this.toolType = toolType;
        this.color = color;
        this.size = size;
    }
        
    public abstract T get();

    /**
     * @return the toolType
     */
    public ToolType getToolType() {
        return toolType;
    }
    
        /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Draw method for a tool
     * 
     * @param point Point to draw at.
     */
    public abstract void draw(Point point);
    
}

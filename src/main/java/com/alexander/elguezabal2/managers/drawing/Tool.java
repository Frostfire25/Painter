/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.drawing;

/**
 *
 * @author Alex
 */
public abstract class Tool<T extends Tool> {
  
    public ToolType toolType;
    
    /**
     * Default Constructor
     * 
     * @param toolType The type of tool this is
     */
    public Tool(ToolType toolType) {
        this.toolType = toolType;
    }
        
    public abstract T get();

    /**
     * @return the toolType
     */
    public ToolType getToolType() {
        return toolType;
    }
    
}

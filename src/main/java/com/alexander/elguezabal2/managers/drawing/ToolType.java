/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.drawing;

/**
 * List of the Tool Types
 * @author Alex
 */
public enum ToolType {
    NONE("None"),
    PEN("Pen"),
    MARKER("Marker");

    public String radioButtonName;
    
    ToolType(String radioButtonName) {
        this.radioButtonName = radioButtonName;
    }

    /**
     * @return the radioButtonName
     */
    public String getRadioButtonName() {
        return radioButtonName;
    }
    
    public static ToolType getByButtonName(String name) {
        for(ToolType n : ToolType.values()) {
            if(n.getRadioButtonName().equals(name)) return n;
        }
        
        return NONE;
    }     
}

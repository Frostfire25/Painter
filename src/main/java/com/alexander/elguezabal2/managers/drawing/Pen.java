/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.drawing;

import java.awt.Color;

/**
 *
 * @author Alex
 */
public class Pen extends Tool<Pen> {
    
    public Color color;
    
    public Pen() {
       super(ToolType.PEN);
       
       this.color = Color.BLACK;
    }

    @Override
    public Pen get() {
        return this;
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
    
}

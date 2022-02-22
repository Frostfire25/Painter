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
        
    public Pen() {
       super(ToolType.PEN, Color.BLACK, 4);
    }

    @Override
    public Pen get() {
        return this;
    }
    
}

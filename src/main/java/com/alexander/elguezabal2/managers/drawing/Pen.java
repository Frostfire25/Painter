/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.drawing;

import com.alexander.elguezabal2.Painter;
import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Alex
 */
public class Pen extends Tool<Pen> {
        
    public Pen() {
       super(ToolType.PEN, Color.BLACK, 5);
    }

    @Override
    public Pen get() {
        return this;
    }

    /**
     * Draw method for a Pen
     * 
     * @param point Point to draw at.
     */
    @Override
    public void draw(Point point) {
        Painter.getMainImageManager().paintOnImage(point, getColor(), getSize());
    }
    
}

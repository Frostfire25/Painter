/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers;

import com.alexander.elguezabal2.managers.drawing.Pen;
import com.alexander.elguezabal2.managers.drawing.Tool;
import com.alexander.elguezabal2.managers.drawing.ToolType;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Alex
 */
public class DrawingManager {
    
    private static Pen pen;
    private static Tool selectedTool;
    
    public DrawingManager() {
        this.pen = new Pen();
        
        this.selectedTool = null;
        init();
    }
    
    /**
     * Initilize method
     */
    private void init() {
        initTimer();
    }
    
    /**
     * Starts the timer for drawing
     */
    private void initTimer() {
        long delay = 50L;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(isDrawing) {
                    pointToColor.put(MouseInfo.getPointerInfo().getLocation(), Color.blue);
                }
            }
        }, delay);

    }
   
    private HashMap<Point, Color> pointToColor = new HashMap<>();
    private boolean isDrawing = false;
    
    /**
     * Called when a person presses inside the draw table
     */
    public void pressed() {
        if(selectedTool != null && selectedTool.getToolType() != ToolType.NONE) {
            isDrawing = true;
        }
    }
    
     /**
     * Called when a person releases inside the draw table
     */
    public void released() {
        if(selectedTool != null && selectedTool.getToolType() != ToolType.NONE) {
            isDrawing = false;
        }
    }
    
    
       
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.timers;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Alex
 * @param <T> Type of class for this class to receive
 */
public abstract class ATimer <T extends ATimer> extends TimerTask {
    
    private long startDelay;
    private long periodDelay;
    
    // Timer
    private Timer timer = new Timer();
        
    /**
     * Default Constructor
     * 
     * @param startDelay Delay for the timer to start 
     * @param periodDelay 
     */
    public ATimer(long startDelay, long periodDelay) {
        // Adding the extra 100 so that anything that needs to be defined in the sub class can be.
        this.startDelay = startDelay + 100;
        this.periodDelay = periodDelay;
        
        // Starts the timer
        startTimer();
    }
    
    /**
     * Starts the task timer
     */
    private void startTimer() {              
        this.timer.scheduleAtFixedRate(this, startDelay, periodDelay);
    }
    
    /**
     * Gets the sub instance of this class
     * @return instance of class T type.
     */
    public abstract T get();
    
}

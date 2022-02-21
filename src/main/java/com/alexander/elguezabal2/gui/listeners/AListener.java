/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.gui.panels.APanel;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Abstract class for all Listeners
 * 
 * For the Generics it needs the instance class of an AListener 
 * and the class of the panel that is using it
 * 
 * 
 * @author Alex
 */
public abstract class AListener<T extends AListener, P extends APanel> {
    
    public P aPanel;
    public Object[] objectsThatCalled;
    
    /**
     * Default constructor
     * 
     * @param aPanel Panel instance of this listener
     * @param objectsThatCalled List of all the objects that are refrencing 
     * this listener.
     */
    public AListener(P aPanel, Object[] objectsThatCalled) {
        this.aPanel = aPanel;
        this.objectsThatCalled = objectsThatCalled;
    }
   
     /**
     * @return the aPanel instace that this class was called by
     */
    public P getAPanel() {
        return aPanel;
    }
    
    /**
     * @return the objectsThatCalled, returns a list of all the objects that called this class
     */
    public Object[] getObjectsThatCalled() {
        return objectsThatCalled;
    }
    
    /**
     * Determines if an object was called by this class
     * 
     * @param object Object to be checked
     * @return true if objectsThatCalled contains {@code object}.
     */
    public boolean containsSource(Object object) {
        for(Object n : objectsThatCalled) {
            if(n == object) return true;
        }
        return false;
    }
    
    public abstract T get();
    
}

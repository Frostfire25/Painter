/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.hotkeys;

import java.util.Objects;

/**
 *
 * @author Alex
 */
public abstract class Hotkey implements Performable {
    
    private String title;
    private HotkeyPattern hotkeyPattern;
    
    /**
     * Default Constructor
     * 
     * @param hotkeyPattern Patter of keys for this specific hotkey
     */
    public Hotkey(String title, HotkeyPattern hotkeyPattern) {
        this.title = title;
        this.hotkeyPattern = hotkeyPattern;
    }

    /**
     * @return the hotkeyPattern
     */
    public HotkeyPattern getHotkeyPattern() {
        return hotkeyPattern;
    }
    
    /**
     * Determines if this hotkey is equal to another hotkey or hotkey combination
     * 
     * @param o Other hotkey
     * @return True if this hotkey patten is equal to {@code o}
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Hotkey)) return false;
        
        Hotkey hotkey = (Hotkey) o;
        
        // Gets the other hotkey values
        Integer[] valuesOfOther = hotkey.getHotkeyPattern().getValues();
        
        // Asserts that both patterns have the same length
        if(valuesOfOther.length != hotkeyPattern.getValues().length) return false;
        
        // Loops over both patterns
        for(int i = 0; i < valuesOfOther.length; i++) {
            if(!Objects.equals(valuesOfOther[i], hotkeyPattern.getValues()[i])) return false;
        }
        
        return true;
    }
    
}

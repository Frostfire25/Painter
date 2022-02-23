/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.managers.hotkeys.Hotkey;
import com.alexander.elguezabal2.managers.hotkeys.HotkeyPattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alex
 */
public class HotkeyManager {
    
    private Set<Hotkey> hotkeys;
    
    private ArrayList<Integer> currentKeysPressed;
    
    public HotkeyManager() {
        hotkeys = new HashSet<>();
        currentKeysPressed = new ArrayList<>();
        
        init();
    }
    
    /**
     * Initilizes all objects in this manager
     */
    private void init() {
        // Adding All Hotkeys 
        
        // Load
        hotkeys.add(new Hotkey("Load", new HotkeyPattern(new Integer[]{17, 76})) {
            @Override
            public void perform() {
                // Loads an image
                Painter.getMainImageManager().loadImage();
            }
        });
        
        // Save
        hotkeys.add(new Hotkey("Save", new HotkeyPattern(new Integer[]{17, 83})) {
            @Override
            public void perform() {
                // Saves an image
                Painter.getMainImageManager().saveImage();
            }
        });
        
        // Basic-Filter
        hotkeys.add(new Hotkey("Basic-Filter", new HotkeyPattern(new Integer[]{16, 66})) {
            @Override
            public void perform() {
                // Displays a basic filter
                Painter.getFrame().getTypeImageSelectionPanel().getButtonGroup().setSelected(Painter.getFrame().getTypeImageSelectionPanel().getBasic().getModel(), true);
            }
        });
        
        // Grayscale-Filter
        hotkeys.add(new Hotkey("Grayscale-Filter", new HotkeyPattern(new Integer[]{16, 71})) {
            @Override
            public void perform() {
                // Displays a grayscale filter
                Painter.getFrame().getTypeImageSelectionPanel().getButtonGroup().setSelected(Painter.getFrame().getTypeImageSelectionPanel().getGrayscale().getModel(), true);
            }
        });
        
        // Inverted-Filter
        hotkeys.add(new Hotkey("Inverted-Filter", new HotkeyPattern(new Integer[]{16, 73})) {
            @Override
            public void perform() {
                // Displays a inverted filter
                Painter.getFrame().getTypeImageSelectionPanel().getButtonGroup().setSelected(Painter.getFrame().getTypeImageSelectionPanel().getInverted().getModel(), true);
            }
        });
        
        // Y-Axis-Filter
        hotkeys.add(new Hotkey("Y-Axis-Filter", new HotkeyPattern(new Integer[]{16, 89})) {
            @Override
            public void perform() {
                // Displays a y axis flip filter
                Painter.getFrame().getTypeImageSelectionPanel().getButtonGroup().setSelected(Painter.getFrame().getTypeImageSelectionPanel().getY_axis().getModel(), true);
            }
        });
        
        // Cartoonify-Filter
        hotkeys.add(new Hotkey("Cartoonify-Filter", new HotkeyPattern(new Integer[]{16, 67})) {
            @Override
            public void perform() {
                // Displays a cartoon filter
                Painter.getFrame().getTypeImageSelectionPanel().getButtonGroup().setSelected(Painter.getFrame().getTypeImageSelectionPanel().getCartoonify().getModel(), true);
            }
        });
    }
    
    /**
     * Adds a key being pressed to {@code currentKeysPressed}
     * @param code Key code be be added
     */
    public void keyPressed(Integer code) {
        if(!currentKeysPressed.contains(code)) {
            currentKeysPressed.add(code);
        }
        
        checkForMatches();
    }
    
     /**
     * Adds a key being released to {@code currentKeysPressed}
     * @param code Key code be be added
     */
    public void keyReleased(Integer code) {
        if(currentKeysPressed.contains(code)) {
            currentKeysPressed.remove(code);
        } 
    }
    
    /**
     * Looks for any hotkey matches
     * If any are found, then they are performed
     */
    private void checkForMatches() {
        // Temp hotkey to compare to                
        Hotkey temphHotkey = new Hotkey("temp", new HotkeyPattern(toArray(currentKeysPressed))) {
            @Override
            public void perform() {
            }
        };
        
        // Loops over all hotkeys, if a match is found it is performed
        for(Hotkey n : hotkeys) {
            if(n.equals(temphHotkey)) {
                n.perform();
                
                // Clear the key cache
                currentKeysPressed.clear();
            }
        }
    }
    
    /**
     * Creates a new Integer Array from a ArrayList
     * 
     * @param list List to be transfered
     * @return A new Integer array
     */
    private Integer[] toArray(ArrayList<Integer> list) {
               
        Integer[] ret = new Integer[list.size()];
        
        // Loops over all the values in list and adds them to ret
        for(int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        
        return ret;
    }
}

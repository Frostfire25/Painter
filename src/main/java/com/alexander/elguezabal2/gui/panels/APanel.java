/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.listeners.HotkeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Abstract wrapper for all panels
 * @author Alex
 * @param <T> The sub class.
 */
public abstract class APanel<T extends APanel> extends JPanel {
    
    public JFrame frame;
    
    /**
     * Default constructor
     * 
     * @param frame Super frame of this APanel.
     */
    public APanel(JFrame frame) {
        this.frame = frame;
        
        // Adds constance focus listeners
        initTotalFocusListners();
    }
    
    /**
     * Applies a listener to each Panel, so said listener will always be infocus
     * Ex. Key Listeners for Hotkeys.
     */
    private void initTotalFocusListners() {
        addKeyListener(new HotkeyListener(frame));
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
    
    public abstract T get();
    
}

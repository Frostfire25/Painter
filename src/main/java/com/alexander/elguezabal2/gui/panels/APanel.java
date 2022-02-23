/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.listeners.HotkeyListener;
import java.awt.Component;
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
        
        // Makes this component focusable
        this.setFocusable(true);
        
        // Adds constance focus listeners
        initTotalFocusListners();
    }
    
    /**
     * Applies a listener to each Panel, so said listener will always be infocus
     * Ex. Key Listeners for Hotkeys.
     */
    private void initTotalFocusListners() {
        addKeyListener(Frame.getHotkeyListener());
    }
    
    /**
     * Applies a listener to each component in a panel
     */
    public void initTotalFocusListnersForSubComponents() {
        // Loops over every sub component in this frame and adds the listener
        for(Component n : getComponents()) {
            n.addKeyListener(Frame.getHotkeyListener());
        }
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
    
    public abstract T get();
        
}

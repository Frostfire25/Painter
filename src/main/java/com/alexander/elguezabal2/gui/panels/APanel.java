/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.Frame;
import javax.swing.JPanel;

/**
 * Abstract wrapper for all panels
 * @author Alex
 */
public abstract class APanel<T extends APanel> extends JPanel {
    
    public Frame frame;
    
    /**
     * Default constructor
     * 
     * @param frame Super frame of this APanel.
     */
    public APanel(Frame frame) {
        this.frame = frame;
    }

    /**
     * @return the frame
     */
    public Frame getFrame() {
        return frame;
    }
    
    public abstract T get();
    
}

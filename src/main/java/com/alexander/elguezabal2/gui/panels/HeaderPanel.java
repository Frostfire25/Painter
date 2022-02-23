/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.listeners.LoadImageListener;
import com.alexander.elguezabal2.gui.listeners.SaveImageListener;
import java.awt.FlowLayout;
import javax.swing.JButton;

/**
 *
 * @author Alex
 */
public class HeaderPanel extends APanel<HeaderPanel> {
        
    private JButton loadImageButton;
    private JButton saveImageButton;
    
     /**
     * Default constructor 
     * 
     * @param frame frame of this GUI instance
     */
    public HeaderPanel(Frame frame) {
        super(frame);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        
        init();
        initTotalFocusListnersForSubComponents();
    }
    
        
    /**
     * Initilizes all components for this class
     */
    private void init() {
        this.loadImageButton = new JButton("Load Image");
        this.saveImageButton = new JButton("Save Image");

        // Initilizes Listeners
        LoadImageListener loadImageListener = new LoadImageListener(this, new Object[]{loadImageButton});
        this.loadImageButton.addActionListener(loadImageListener);
        
        SaveImageListener saveImageListener = new SaveImageListener(this, new Object[]{saveImageButton});
        this.saveImageButton.addActionListener(saveImageListener);
        
        add(loadImageButton);
        add(saveImageButton);
    }

    @Override
    public HeaderPanel get() {
        return this;
    }
}

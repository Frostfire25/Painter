/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.listeners.LoadImageListener;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class HeaderPanel extends APanel<HeaderPanel> {
        
    private JButton loadImageButton;
    private JButton saveImageButton;
    
    public HeaderPanel(Frame frame) {
        super(frame);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        
        init();
    }
    
    private void init() {
        this.loadImageButton = new JButton("Load Image");
        this.saveImageButton = new JButton("Save Image");

        // Initilizes Listeners
        LoadImageListener loadImageListener = new LoadImageListener(this, new Object[]{loadImageButton});
        this.loadImageButton.addActionListener(loadImageListener);
        
        
        add(loadImageButton);
        add(saveImageButton);
    }

    @Override
    public HeaderPanel get() {
        return this;
    }
    
    public void go() {
        
    }

    
}

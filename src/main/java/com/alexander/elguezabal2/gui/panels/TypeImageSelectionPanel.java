/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.Frame;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author Alex
 */
public class TypeImageSelectionPanel  extends APanel<TypeImageSelectionPanel> {
        
    private JRadioButton basic;
    private JRadioButton grayscale;
    private JRadioButton inverted;
    
    private ButtonGroup bg;
    
    /**
     * Default constructor 
     * 
     * @param frame frame of this GUI instance
     */
    public TypeImageSelectionPanel(Frame frame) {
        super(frame);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        init();
    }
    
    /**
     * Initilizes all components for this class
     */
    private void init() {
        
        bg = new ButtonGroup();
        
        basic = new JRadioButton("Basic");
        grayscale = new JRadioButton("Grayscale");
        inverted = new JRadioButton("Inverted");

        bg.add(basic);
        bg.add(grayscale);
        bg.add(inverted);
        
        add(basic);
        add(grayscale);
        add(inverted);
    }

    @Override
    public TypeImageSelectionPanel get() {
        return this;
    }
}

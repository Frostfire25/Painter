/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.listeners.TypeImageListener;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Alex
 */
public class TypeImageSelectionPanel extends APanel<TypeImageSelectionPanel> {
        
    private JLabel header;
    
    private JRadioButton basic;
    private JRadioButton grayscale;
    private JRadioButton inverted;
    private JRadioButton y_axis;
    
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
     * Initilizing all components for this class
     */
    private void init() {
        
        bg = new ButtonGroup();
        
        // Initilizes JLabels
        this.header = new JLabel("Image Conversions");
        header.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        
        // Initilizing Radio Buttons
        basic = new JRadioButton("Basic");
        grayscale = new JRadioButton("Grayscale");
        inverted = new JRadioButton("Inverted");
        y_axis = new JRadioButton("Y Axis");
        
        
        // Initilizing Button Group
        bg.add(basic);
        bg.add(grayscale);
        bg.add(inverted);
        bg.add(y_axis);
        
        // Initilizing Listener
        TypeImageListener listener = new TypeImageListener(this, new Object[]{basic, grayscale, inverted, y_axis});
        basic.addItemListener(listener);
        grayscale.addItemListener(listener);
        inverted.addItemListener(listener);
        y_axis.addItemListener(listener);

        // Initilizing Font for each Button
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 17);
        basic.setFont(font);
        grayscale.setFont(font);
        inverted.setFont(font);
        y_axis.setFont(font);
        
        // Adding to Panel
        add(header);
        add(new JLabel("\n "));
        add(basic);
        add(grayscale);
        add(inverted);
        add(y_axis);
    }

    @Override
    public TypeImageSelectionPanel get() {
        return this;
    }
}

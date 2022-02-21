/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.frames.ColorPalleteFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Alex
 */
public class DrawingPanel extends APanel<DrawingPanel> {
        
    private JLabel header;
    
    private JRadioButton pen;
    private JRadioButton none;

    private ButtonGroup bg;
    
    private JButton selectColor;
    
    /**
     * Default constructor 
     * 
     * @param frame frame of this GUI instance
     */
    public DrawingPanel(Frame frame) {
        super(frame);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        init();
    }
    
    /**
     * Initilizes all components for this class
     */
    private void init() {
        
        bg = new ButtonGroup();
        
        // Initilizing JLabels
        this.header = new JLabel("Drawing Tools  ");
        header.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        
        // Initilizing Radio Buttons
        pen = new JRadioButton("Pen");
        none = new JRadioButton("None");
             
        // Initilizing Buttons
        this.selectColor = new JButton("Color Pallete");
        
        // Button Group
        bg.add(pen);
        bg.add(none);

        
        // Listener
        /*
        TypeImageListener listener = new TypeImageListener(this, new Object[]{basic, grayscale, inverted, y_axis});
        basic.addItemListener(listener);
        grayscale.addItemListener(listener);
        inverted.addItemListener(listener);
        y_axis.addItemListener(listener);
        */
        this.selectColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ColorPalleteFrame();
            }
        });

        // Font for each Button
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 17);
        pen.setFont(font);
        none.setFont(font);
        
        selectColor.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));

        
        // Adding to Panel
        add(header);
        add(new JLabel("\n "));
        add(pen);
        add(none);
        add(new JLabel("\n\n "));
        add(selectColor);
    }

    @Override
    public DrawingPanel get() {
        return this;
    }
}

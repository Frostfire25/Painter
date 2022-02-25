/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.frames.ColorPalleteFrame;
import com.alexander.elguezabal2.gui.listeners.TypeToolListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
    private JRadioButton marker;
    private JRadioButton none;

    private ButtonGroup bg;
    
    private JButton selectColor;
    
    private JLabel currentColor;
    
    /**
     * Default constructor 
     * 
     * @param frame frame of this GUI instance
     */
    public DrawingPanel(Frame frame) {
        super(frame);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        init();
        initTotalFocusListnersForSubComponents();
    }
    
    /**
     * Initilizes all components for this class
     */
    private void init() {
        
        bg = new ButtonGroup();
        
        // Initilizing JLabels
        this.header = new JLabel("Drawing Tools  ");
        this.header.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        
        this.currentColor = new JLabel("Current Color");
        this.currentColor.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
        // Initilizing Radio Buttons
        pen = new JRadioButton("Pen");
        marker = new JRadioButton("Marker");
        none = new JRadioButton("None");
             
        // Initilizing Buttons
        this.selectColor = new JButton("Color Pallete");
        
        // Button Group
        bg.add(pen);
        bg.add(marker);
        bg.add(none);

   
        // Listener 
        // Don't forget to add the object into the object array.
        TypeToolListener listener = new TypeToolListener(this, new Object[]{pen, marker, none});
        pen.addItemListener(listener);
        marker.addItemListener(listener);
        none.addItemListener(listener);
        

        this.selectColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ColorPalleteFrame();
            }
        });

        // Font for each Button
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 17);
        pen.setFont(font);
        marker.setFont(font);
        none.setFont(font);
        
        selectColor.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        
        // Adding to Panel
        add(header);
        add(new JLabel("\n "));
        add(pen);
        add(marker);
        add(none);
        add(new JLabel("\n\n "));
        add(selectColor);
        add(currentColor);
    }
    
     /**
     * Paints current paint color on screen.
     * 
     * @param g Graphics.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Color color = Painter.getDrawingManager().getCurrentColor();
        
        g.drawRect(40, 210, 31, 31);
        
        g.setColor(color);
        g.fillRect(41, 211, 30, 30);   
    }
    
    /**
     * When the current color changes, the graphics must also change
     */
    public void updateCurrentColor() {
        repaint();
    }
    

    @Override
    public DrawingPanel get() {
        return this;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.frames;

import com.alexander.elguezabal2.gui.panels.ColorPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alex
 */
public class HotkeysFrame extends JFrame {
    
    private final int WIDTH = 500;
    private final int HEIGHT = 250;
        
    /**
     * Default Constructor for Color Pallete Frame
     */
    public HotkeysFrame() {
        super("List of the Hotkeys.");
                
        setResizable(false);
        
        setLayout(new FlowLayout(FlowLayout.CENTER));

        setSize(new Dimension(WIDTH, HEIGHT));
        
        Font headerFont = new Font(Font.MONOSPACED, Font.PLAIN, 21);
        Font informationFont = new Font(Font.MONOSPACED, Font.PLAIN, 17);

        JLabel header = new JLabel("Hotkeys: ");
        JLabel information = new JLabel("<html>"
                + "<br/>"
                + "Ctrl + L = Load Image"
                + "<br/>"
                + "Ctrl + S = Save Image"
                + "<br/>"
                + "Shift + B = Basic Filter"
                + "<br/>"
                + "Shift + G = Grayscale Filter"
                + "<br/>"
                + "Shift + I = Inverse Filter"
                + "<br/>"
                + "Shift + Y = Y - Axis Flip Filter"
                + "<br/>"
                + "Shift + C = Cartoonify Filter"
                + "<br/>"
                + "</html>");
        
        header.setFont(headerFont);
        information.setFont(informationFont);
        
        add(header);
        add(information);
        
        // Shows the frame
        this.setVisible(true);
        
        // Updat the frame
        revalidate();
        repaint();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.frames;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import com.alexander.elguezabal2.gui.panels.ColorPanel;

/**
 *
 * @author Alex
 */
public class ColorPalleteFrame extends JFrame {
    
    // Pallete Image
    private Image image;
    
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    
    private ColorPanel colorPanel;
    
    /**
     * Default Constructor for Color Pallete Frame
     */
    public ColorPalleteFrame() {
        super("Click to Choose a Color");
        
        // Reads the file for the pallete
        try {
            Image tempImage = ImageIO.read(new File("collor-pallete.png"));
            image = tempImage.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
                
        setResizable(false);
        
        setLayout(null);

        setSize(new Dimension(WIDTH, HEIGHT));
        
        colorPanel = new ColorPanel(this, image, WIDTH, HEIGHT);
        add(colorPanel);
        
        // Shows the frame
        this.setVisible(true);
        
        // Updat the frame
        revalidate();
        repaint();
    }
}


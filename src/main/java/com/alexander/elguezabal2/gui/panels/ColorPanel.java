/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.listeners.ColorPalleteListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JFrame;

/**
 * Class to display the color pallet image
 * 
 * @author Alex
 */
public class ColorPanel extends APanel<ColorPanel> {

    private Image image;
    
    public ColorPanel(JFrame frame, Image image, int width, int height) {
        super(frame);
        this.image = image;
        setSize(new Dimension(width, height));
        
        // Listeners
        ColorPalleteListener listener = new ColorPalleteListener(this, new Object[]{});
        addMouseListener(listener);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        System.out.println("called");
        g.drawImage(image, WIDTH-1, HEIGHT-1, this);
    }

    @Override
    public ColorPanel get() {
        return this;
    }
    
}

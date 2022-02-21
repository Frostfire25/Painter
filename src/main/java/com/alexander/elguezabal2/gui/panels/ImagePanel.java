/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.listeners.MouseListener;
import com.alexander.elguezabal2.managers.MainImageManager;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Alex
 */
public class ImagePanel extends APanel<ImagePanel> {

    public ImagePanel(Frame frame) {
        super(frame);
        this.setLayout(null);
        setSize(new Dimension(400, 400));
         
        init();
    }
    
    private void init() {
        // Initilizes Listeners
        MouseListener mouseListener = new MouseListener(this, new Object[]{});
        addMouseListener(mouseListener);
    }

    @Override
    public ImagePanel get() {
        return this;
    }
    
    public void updateImage() {  
        repaint();
    }
    
    private final int IMAGE_X_POINT = 301;
    private final int IMAGE_Y_POINT = 111;
    
    @Override
    public void paintComponent(Graphics g) {
        
        // Loads the image, if non-null.
        Image image = Painter.getMainImageManager().getImage();
        if(image != null) {
              
            g.drawImage(image, IMAGE_X_POINT, IMAGE_Y_POINT, image.getWidth(frame), image.getHeight(frame), frame);
            
        }
        
        // Draws the box around the image
        for(int i = 1; i <= 7; i++) {
            g.draw3DRect(IMAGE_X_POINT-i, IMAGE_Y_POINT-i, MainImageManager.IMAGE_WIDTH+1, MainImageManager.IMAGE_HEIGHT+1, false);
        }
                
    }
    
}

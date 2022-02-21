/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.listeners.MouseListener;
import com.alexander.elguezabal2.managers.MainImageManager;
import com.alexander.elguezabal2.managers.images.AImage;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Alex
 */
public class ImagePanel extends APanel<ImagePanel> {

    /**
     * Default constructor
     * @param frame Instance of the frame that uses this panel
     */
    public ImagePanel(Frame frame) {
        super(frame);
        this.setLayout(new CardLayout());
        setSize(new Dimension(400, 400));
         
        init();
    }
    
    private void init() {
        // Initilizes Listeners
        MouseListener mouseListener = new MouseListener(this, new Object[]{});
        addMouseListener(mouseListener);
    }

    /**
     * Gets the image panel
     * @return 
     */
    @Override
    public ImagePanel get() {
        return this;
    }
    
    /**
     * Updates the image on screen
     */
    public void updateImage() {  
        repaint();
    }
    
    private final int IMAGE_X_POINT = 301;
    private final int IMAGE_Y_POINT = 111;
    
    /**
     * Paints The image and a surrounding box on screen
     * Only paints an image if an image is loaded.
     * 
     * @param g Graphics.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Loads the image, if non-null.
        AImage aImage = Painter.getMainImageManager().getImage();
                
        if(aImage != null) {
            Image image = aImage.getFilteredImage();
            g.drawImage(image, IMAGE_X_POINT, IMAGE_Y_POINT, image.getWidth(getFrame()), image.getHeight(getFrame()), getFrame());
        }
        
        // Draws the box around the image
        for(int i = 1; i <= 7; i++) {
            g.draw3DRect(IMAGE_X_POINT-i, IMAGE_Y_POINT-i, MainImageManager.IMAGE_WIDTH+1, MainImageManager.IMAGE_HEIGHT+1, false);
        }
                
    }
    
}

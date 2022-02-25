/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.images;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.panels.ImagePanel;
import com.alexander.elguezabal2.managers.ImageManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Alex
 */
public class YAxisMirroredImage extends AImage<YAxisMirroredImage> implements Filterable {

    public YAxisMirroredImage(Frame frame, Image baseImage, String filename) {
        super(frame, baseImage, ImageType.Y_AXIS_MIRRORED_IMAGE, filename);
        
        // Sets the filtered image
        setFilteredImage(filter(baseImage));
        
        initTotalFocusListnersForSubComponents();        
    }
    
    @Override
    public Image getFilteredImage() {
        // Returns the base image, because this image has no filter
        return filteredImage;
    }
    
    /**
     * Filters {@code image} to Y-Axis Mirrored
     * 
     * @param image
     * @return 
     */
    private Image filter(Image image) {

        BufferedImage bufferedImage = toBufferedImage(image);
        BufferedImage refrenceImage = toBufferedImage(image);
        
        int counter = 0;
        for (int i = refrenceImage.getWidth()-1; i > (int) refrenceImage.getWidth() / 2; i--) {

            for (int j = 0; j < refrenceImage.getHeight(); j++) {

                // Perform Half 1
                Color c = new Color(refrenceImage.getRGB(i, j));                
                bufferedImage.setRGB(counter, j, c.getRGB());
                
                // Perform Half 2
                Color c2 = new Color(refrenceImage.getRGB(counter, j));                
                bufferedImage.setRGB(i, j, c2.getRGB());
            }
            counter++;
        }
        
        return bufferedImage;
    }

    @Override
    public YAxisMirroredImage get() {
        return this;
    }
    
    /**
     * Paints The image and a surrounding box on screen
     * Only paints an image if an image is loaded.
     * 
     * @param g Graphics.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        System.out.println("here painted y-axis mirror.");
        
        // Loads the image, if non-null.
        AImage aImage = Painter.getMainImageManager().getImage();
                        
        if(aImage != null) {
            Image image = aImage.getFilteredImage();
            g.drawImage(image, ImagePanel.IMAGE_X_POINT, ImagePanel.IMAGE_Y_POINT, image.getWidth(getFrame()), image.getHeight(getFrame()), getFrame());
        }
        
        // Draws the box around the image
        for(int i = 1; i <= 7; i++) {
            g.draw3DRect(ImagePanel.IMAGE_X_POINT-i, ImagePanel.IMAGE_Y_POINT-i, ImageManager.IMAGE_WIDTH+1, ImageManager.IMAGE_HEIGHT+1, false);
        }      
    }
           
}

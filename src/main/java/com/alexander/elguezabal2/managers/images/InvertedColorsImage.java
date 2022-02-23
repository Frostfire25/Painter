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
public class InvertedColorsImage extends AImage<InvertedColorsImage> implements Filterable {

    public InvertedColorsImage(Frame frame, Image baseImage) {
        super(frame, baseImage, ImageType.INVERTED_COLOR_IMAGE);
        
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
     * Filters {@code image} to Inverted Colors
     * 
     * @param image
     * @return 
     */
    private Image filter(Image image) {
       
       BufferedImage bufferedImage = toBufferedImage(image);
        
        for (int i = 0; i < bufferedImage.getHeight(); i++) {

            for (int j = 0; j < bufferedImage.getWidth(); j++) {

                Color c = new Color(bufferedImage.getRGB(j, i));
                int red = (int) (255  - c.getRed());
                int green = (int) (255 - c.getGreen());
                int blue = (int) (255 - c.getBlue());
                Color newColor = new Color(red, green, blue, c.getAlpha());

                bufferedImage.setRGB(j, i, newColor.getRGB());
            }
        }
        
        return bufferedImage;
    }

    @Override
    public InvertedColorsImage get() {
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
        
        System.out.println("here painted inverted colors");
        
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

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
public class CartoonifyImage extends AImage<CartoonifyImage> {

     /**
     * Default Constructor for CartoonifyImage
     * 
     * @param frame Super frame
     * @param baseImage Basic version of the image
     */
    public CartoonifyImage(Frame frame, Image baseImage) {
        super(frame, baseImage, ImageType.CARTOONIFY_IMAGE);
        
        // Sets the filtered image
        setFilteredImage(filter(baseImage));
        
        initTotalFocusListnersForSubComponents();
    }
    
        /**
     * Filters {@code image} to Cartoonify
     * Used parts of code from 
     * 
     * @param image Image to be filtered
     * @return 
     */
    private Image filter(Image image) {
       
       BufferedImage bufferedImage = toBufferedImage(image);
        
        for (int i = 0; i < bufferedImage.getHeight(); i++) {

            for (int j = 0; j < bufferedImage.getWidth(); j++) {

                Color c = new Color(bufferedImage.getRGB(j, i));

                Color newColor = new Color(1,1,1, c.getAlpha());
                bufferedImage.setRGB(j, i, newColor.getRGB());
            }
        }
        
        return bufferedImage;
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
        
        System.out.println("here painted Cartoonify Image");
        
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
    
    @Override
    public Image getFilteredImage() {
        return filteredImage;
    }
    
    @Override
    public CartoonifyImage get() {
        return this;
    }
    
}

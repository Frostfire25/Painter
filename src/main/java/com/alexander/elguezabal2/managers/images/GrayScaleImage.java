/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.images;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.panels.ImagePanel;
import com.alexander.elguezabal2.managers.MainImageManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Alex
 */
public class GrayScaleImage extends AImage<GrayScaleImage> implements Filterable {

    public GrayScaleImage(Frame frame, Image baseImage) {
        super(frame, baseImage, ImageType.GRAYSCALE_IMAGE);
        
        // Sets the filtered image
        setFilteredImage(filter(baseImage));
    }
    
    @Override
    public Image getFilteredImage() {
        // Returns the base image, because this image has no filter
        return filteredImage;
    }
    
    /**
     * Filters {@code image} to Grayscale
     * Used parts of code from !(https://www.tutorialspoint.com/java_dip/grayscale_conversion.htm)
     * 
     * @param image
     * @return 
     */
    private Image filter(Image image) {
       
       BufferedImage bufferedImage = toBufferedImage(image);
        
        for (int i = 0; i < bufferedImage.getHeight(); i++) {

            for (int j = 0; j < bufferedImage.getWidth(); j++) {

                Color c = new Color(bufferedImage.getRGB(j, i));
                int red = (int) (c.getRed() * 0.299);
                int green = (int) (c.getGreen() * 0.587);
                int blue = (int) (c.getBlue() * 0.114);
                Color newColor = new Color(red + green + blue,
                        red + green + blue, red + green + blue);

                bufferedImage.setRGB(j, i, newColor.getRGB());
            }
        }
        
        return bufferedImage;
    }

    @Override
    public GrayScaleImage get() {
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
        
        System.out.println("here painted grayscale");
        
        // Loads the image, if non-null.
        AImage aImage = Painter.getMainImageManager().getImage();
                        
        if(aImage != null) {
            Image image = aImage.getFilteredImage();
            g.drawImage(image, ImagePanel.IMAGE_X_POINT, ImagePanel.IMAGE_Y_POINT, image.getWidth(getFrame()), image.getHeight(getFrame()), getFrame());
        }
        
        // Draws the box around the image
        for(int i = 1; i <= 7; i++) {
            g.draw3DRect(ImagePanel.IMAGE_X_POINT-i, ImagePanel.IMAGE_Y_POINT-i, MainImageManager.IMAGE_WIDTH+1, MainImageManager.IMAGE_HEIGHT+1, false);
        }      
    }
    
    /**
     * !(https://stackoverflow.com/questions/13605248/java-converting-image-to-bufferedimage)
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
    
}


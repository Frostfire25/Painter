/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.images;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.panels.APanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * @author Alex
 * @param <T> Class type for the instance of this Panel
 */
public abstract class AImage<T extends APanel> extends APanel<T> implements Filterable, Drawable {
    
    private Image baseImage;
    public Image filteredImage; 
    private ImageType imageType;
        
    /**
     * Default constructor
     * 
     * @param baseImage The starting image that will be used 
     * @param imageType The type of image that this class is
     * 
     */
    public AImage(Frame frame, Image baseImage, ImageType imageType) {
        super(frame);
        updateImage(baseImage);
        this.imageType = imageType;
        setBackground(Color.LIGHT_GRAY);
    }
    
    /**
     * Updates both {@code baseImage} and {@code filteredImage}
     * 
     * @param image Image to be updated.
     */
    public final void updateImage(Image image) {
        this.baseImage = image;
        this.setFilteredImage(getFilteredImage());  
    }

    /**
     * @return the baseImage
     */
    public Image getBaseImage() {
        return baseImage;
    }

    /**
     * @return the imageType
     */
    public ImageType getImageType() {
        return imageType;
    }
    
     /**
     * @param filteredImage the filteredImage to set
     */
    public void setFilteredImage(Image filteredImage) {
        this.filteredImage = filteredImage;
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
        
        g.draw3DRect(0, 0, getWidth()-1, getHeight()-1, true);
    }
    
        /**
     * !(https://stackoverflow.com/questions/13605248/java-converting-image-to-bufferedimage)
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
    */
    public BufferedImage toBufferedImage(Image img) {
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

package com.alexander.elguezabal2.managers;

import com.alexander.elguezabal2.Painter;
import java.awt.Image;

/**
 * Manager class for the main image
 * @author Alex
 */
public class MainImageManager {
    
    // Static image because I only want one to be loaded;
    public static Image image;
    
    public MainImageManager() {
        this.image = null;
    }
    
    public static final int IMAGE_HEIGHT = 300;
    public static final int IMAGE_WIDTH = 300;
    
    public void loadImage(Image image) {
        this.image = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT);
        
        // Updates the image on screen
        Painter.getFrame().getImagePanel().updateImage();
    }

    /**
     * @return the image
     */
    public static Image getImage() {
        return image;
    }

    /**
     * @param aImage the image to set
     */
    public static void setImage(Image aImage) {
        image = aImage;
    }
    
}

package com.alexander.elguezabal2.managers;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.managers.images.AImage;
import com.alexander.elguezabal2.managers.images.BaseImage;
import com.alexander.elguezabal2.managers.images.GrayScaleImage;
import com.alexander.elguezabal2.managers.images.ImageType;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Manager class for the main image
 * A static class.
 * 
 * @author Alex
 */
public class MainImageManager {
    
    // Static because only one image can be displayed on screen at a time.
    public static ImageType onScreen;
    
    // Static image because I only want one to be loaded;
    private static BaseImage baseImage;
    private static GrayScaleImage grayScaleImage;
    
    private HashSet<AImage> allImages;
    
    public MainImageManager() {
        this.baseImage = null;
        this.onScreen = ImageType.NONE;
        allImages = new HashSet<>();
    }
    
    public static final int IMAGE_HEIGHT = 300;
    public static final int IMAGE_WIDTH = 300;
    
    /**
     * Loads in an image to all the image manager
     * 
     * @param image Image to be loaded in.
     */
    public void loadImage(Image image) {       
        // Scales the original image
        Image scaled = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT);
        
        // Resets all images, because we have a new image, new image templates.
        allImages = new HashSet<>();
        
        // Updates the images 
        this.baseImage = new BaseImage(Painter.getFrame(), scaled);
        this.grayScaleImage = new GrayScaleImage(Painter.getFrame(), scaled);
        
        // Adds the image type to the frames collection
        allImages.add(baseImage);
        allImages.add(grayScaleImage);
        
        
        
        
        // Updates the type of image on the users screen
        // Whenever an image is loaded, we want the base image to be shown.
        setOnScreen(ImageType.BASE_IMAGE);
       
        // Updates the image on screen
        Painter.getFrame().getImagePanel().addAllPanels(allImages);
        Painter.getFrame().getImagePanel().updateImage();
    }
    
    public AImage getImage() {
        return allImages.stream().filter(n -> n.getImageType() == getOnScreen()).findFirst().orElse(null);
    }

    /**
     * @return the onScreen
     */
    public static ImageType getOnScreen() {
        return onScreen;
    }

    /**
     * @param aOnScreen the onScreen to set
     */
    public static void setOnScreen(ImageType aOnScreen) {
        onScreen = aOnScreen;
    }
    
}

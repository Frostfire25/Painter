/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.images;

import java.awt.Image;

/**
 *
 * @author Alex
 */
public abstract class AImage implements Filterable {
    
    private Image baseImage;
    private Image filteredImage; 
    private ImageType imageType;
    
    /**
     * Default constructor
     * 
     * @param baseImage The starting image that will be used 
     * @param imageType The type of image that this class is
     * 
     */
    public AImage(Image baseImage, ImageType imageType) {
        updateImage(baseImage);
        this.imageType = imageType;
    }
    
    /**
     * Updates both {@code baseImage} and {@code filteredImage}
     * 
     * @param image Image to be updated.
     */
    public final void updateImage(Image image) {
        this.baseImage = image;
        this.filteredImage = getFilteredImage();  
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
        
}

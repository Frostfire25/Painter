/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.images;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.panels.APanel;
import com.alexander.elguezabal2.managers.MainImageManager;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Alex
 */
public abstract class AImage<T extends APanel> extends APanel<T> implements Filterable {
    
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
    }
       
}

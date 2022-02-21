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
public class BaseImage extends AImage implements Filterable {

    public BaseImage(Image baseImage) {
        super(baseImage, ImageType.BASE_IMAGE);
    }
    
    @Override
    public Image getFilteredImage() {
        // Returns the base image, because this image has no filter
        return getBaseImage();
    }
       
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.images;

import com.alexander.elguezabal2.gui.Frame;
import java.awt.Image;

/**
 *
 * @author Alex
 */
public class BaseImage extends AImage<BaseImage> implements Filterable {

    public BaseImage(Frame frame, Image baseImage) {
        super(frame, baseImage, ImageType.BASE_IMAGE);
    }
    
    @Override
    public Image getFilteredImage() {
        // Returns the base image, because this image has no filter
        return getBaseImage();
    }

    @Override
    public BaseImage get() {
        return this;
    }

       
}

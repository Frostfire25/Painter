/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.images;

/**
 *
 * @author Alex
 */
public enum ImageType {
    
    NONE(""),
    BASE_IMAGE("Basic"),
    GRAYSCALE_IMAGE("Grayscale"),
    INVERTED_COLOR_IMAGE("Inverted"),
    Y_AXIS_MIRRORED_IMAGE("Y Axis"),
    CARTOONIFY_IMAGE("Cartoonify");

    public String radioButtonName;
    
    ImageType(String radioButtonName) {
        this.radioButtonName = radioButtonName;
    }

    /**
     * @return the radioButtonName
     */
    public String getRadioButtonName() {
        return radioButtonName;
    }
    
    public static ImageType getByButtonName(String name) {
        for(ImageType n : ImageType.values()) {
            if(n.getRadioButtonName().equals(name)) return n;
        }
        
        return NONE;
    }  
    
}

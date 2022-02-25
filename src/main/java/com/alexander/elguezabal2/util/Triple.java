/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Used for storing three different values linked together
 * @author Alex
 * @param <X> Type one
 * @param <Y> Type two
 * @param <Z> Type three
 */

@AllArgsConstructor
@Data
public class Triple <X,Y,Z> {
    
    private X value1;
    private Y value2;
    private Z value3;
    
}

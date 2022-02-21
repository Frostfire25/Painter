/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.gui.panels.HeaderPanel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Alex
 */
public class LoadImageListener extends AListener<LoadImageListener, HeaderPanel> implements ItemListener {

    public LoadImageListener(HeaderPanel headerPanel, Object[] objects) {
        super(headerPanel, objects);
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }

    @Override
    public LoadImageListener get() {
        return this;
    }

    
}

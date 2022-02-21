/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.panels.HeaderPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Alex
 */
public class SaveImageListener extends AListener<SaveImageListener, HeaderPanel> implements ActionListener {

    public SaveImageListener(HeaderPanel headerPanel, Object[] objects) {
        super(headerPanel, objects);
        
    }

   @Override
    public void actionPerformed(ActionEvent evt) {
        // If this button did not call.
        if(evt.getSource() == null || !containsSource(evt.getSource()) || !(evt.getSource() instanceof JButton)) return;
        
        // Saves the image
        Painter.getMainImageManager().saveImage();
    }
    
    @Override
    public SaveImageListener get() {
        return this;
    }
    
}

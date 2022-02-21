/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.panels.HeaderPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Alex
 */
public class LoadImageListener extends AListener<LoadImageListener, HeaderPanel> implements ActionListener {

    public LoadImageListener(HeaderPanel headerPanel, Object[] objects) {
        super(headerPanel, objects);
        
    }

   @Override
    public void actionPerformed(ActionEvent evt) {
        // If this button did not call.
        if(evt.getSource() == null || !containsSource(evt.getSource()) || !(evt.getSource() instanceof JButton)) return;
        
        JButton button = (JButton) evt.getSource();
        
        Painter.getMainImageManager().loadImage();
    }
    
    @Override
    public LoadImageListener get() {
        return this;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.gui.panels.HeaderPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
        
        File file = null;
        
        // (! https://mkyong.com/swing/java-swing-jfilechooser-example/)  
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            
            // Determines if the file selected is an image, if not an erro is displayed.
            if (!file.getPath().endsWith(".png") || !file.getPath().endsWith(".jpg")) {
                JOptionPane.showMessageDialog(null, "A incorrect file-type was selected, please only chose PNGs and JPGs.");
                return;
            }
        }  
        // Displays an error if no file was selected
        else {
            JOptionPane.showMessageDialog(null, "You did not select a file");
            return;
        }
        
    }
    
    @Override
    public LoadImageListener get() {
        return this;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2;

import com.alexander.elguezabal2.gui.Frame;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * Main class for this project.
 * @author Alex
 */
public class Painter {
    
    private static Frame frame;
    
    public static void main(String[] args) {
     
        // Loads the frame 
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Assigns the frame
                frame = new Frame();
            }
        });
    }
    
}

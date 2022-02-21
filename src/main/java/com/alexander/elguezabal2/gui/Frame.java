/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui;

import com.alexander.elguezabal2.gui.panels.HeaderPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import lombok.Getter;

/**
 * The GUI builder class.
 * @author Alex
 */
public class Frame extends JFrame {
    
    // GUI Specifications
    private final int GUI_WIDTH = 980;
    private final int GUI_HEIGHT = 720;
    
    @Getter
    private int GUI_X_BOUNDS; 
    @Getter
    private int GUI_Y_BOUNDS; 

    // Panels
    private HeaderPanel headerPanel;
    
    public Frame() {
        super("Painter");
                
        //Autoclose
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Size
        this.setSize(GUI_WIDTH, GUI_HEIGHT);
        
        // Prefered Size
        this.setPreferredSize(new Dimension(GUI_WIDTH, GUI_HEIGHT));
        
        //Resizeable
        this.setResizable(false);
        
        // Sets the layout
        this.setLayout(new BorderLayout());
        
        // Sets the icon
        Image icon = null;
        try {
            icon = ImageIO.read(new File("icon.png"));
        } catch(IOException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        
        // Image must exist
        if(icon != null)
            this.setIconImage(icon);
        
        // Packs the frame
        pack();
        
        // Adds variables
        init();
        
        // Displayer
        this.setVisible(true);
                
        // Used for loading in objects after the gui is built
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
              @Override
                public void run() {
                
            }
        }, 500);
    }    
    
    /**
     * Init Methods
     */
    
    private void init() {
        initPanels();
    }
    
    /*
    Initizlies all JPanels
    */
    private void initPanels() {
        this.headerPanel = new HeaderPanel(this);
        
        add(this.headerPanel, BorderLayout.NORTH);
    }
    
}
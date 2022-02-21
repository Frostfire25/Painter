/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.listeners.MouseListener;
import com.alexander.elguezabal2.managers.MainImageManager;
import com.alexander.elguezabal2.managers.images.AImage;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Set;

/**
 *
 * @author Alex
 */
public class ImagePanel extends APanel<ImagePanel> {

    private CardLayout cards;
    
    /**
     * Default constructor
     * @param frame Instance of the frame that uses this panel
     */
    public ImagePanel(Frame frame) {
        super(frame);
        
        cards = new CardLayout();
        
        this.setLayout(cards);
        setSize(new Dimension(400, 400));
         
        init();
    }
    
    private void init() {
        // Initilizes Listeners
        MouseListener mouseListener = new MouseListener(this, new Object[]{});
        addMouseListener(mouseListener);
    }

    /**
     * Gets the image panel
     * @return 
     */
    @Override
    public ImagePanel get() {
        return this;
    }
    
    /**
     * Updates the image on screen
     */
    public void updateImage() {  
        // Pain the current image on the screen.
        repaint();
        
        // Find the new image to update
        AImage aImage = Painter.getMainImageManager().getImage();
        
        // If the image exists, we will load in the one needed to be displayed on screen
        if(aImage != null) {
            System.out.println(""+aImage.getImageType().name());
            cards.show(this, aImage.getImageType().name()); 
            revalidate();
            repaint();
        }
    }
    
    // Info for the image management
    public static final int IMAGE_X_POINT = 301;
    public static final int IMAGE_Y_POINT = 111;
        
     /**
     * Paints  surrounding box on screen
     * 
     * @param g Graphics.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
               
        // Draws the box around the image
        for(int i = 1; i <= 7; i++) {
            g.draw3DRect(ImagePanel.IMAGE_X_POINT-i, ImagePanel.IMAGE_Y_POINT-i, MainImageManager.IMAGE_WIDTH+1, MainImageManager.IMAGE_HEIGHT+1, false);
        }
                
    }    
    
    /**
     * Adds all image panels to this panel (Card Layout)
     * 
     * @param images Collection of images to be added.
     */
    public void addAllPanels(Set<AImage> images) {
        removeAll();
        repaint();
        
        images.forEach(n -> {
            add(n, n.getImageType().name());
        });
    }
}

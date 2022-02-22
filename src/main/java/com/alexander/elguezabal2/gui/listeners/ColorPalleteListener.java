/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.panels.ColorPanel;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class ColorPalleteListener extends AListener<ColorPalleteListener, ColorPanel> implements java.awt.event.MouseListener {

    public ColorPalleteListener(ColorPanel imagePanel, Object[] objects) {
        super(imagePanel, objects);
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        // Current Mouse Location
        Point point = MouseInfo.getPointerInfo().getLocation();
        
        // Color at Location
        Color color = getColorAt(getAPanel().getFrame(), point);
        
        // Updates the Color of the current Tool.
        Painter.getDrawingManager().updateColor(color);
        
        // Closes the frame
        getAPanel().getFrame().setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    @Override
    public ColorPalleteListener get() {
        return this;
    }
    
    /**
     * !(https://stackoverflow.com/questions/60906929/java-swing-how-to-get-the-color-of-a-pixel-of-a-jframe)
     * Gets the color at a certian point
     * Used for figuring out what color is selected
     * 
     * @param frm Frame to chose from
     * @param p Point to look for
     * @return Color at the perspective point
     */
    public static Color getColorAt(JFrame frm, Point p) {
        Rectangle rect = frm.getContentPane().getBounds();
        BufferedImage img = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
        frm.getContentPane().paintAll(img.createGraphics());
        return new Color(img.getRGB(p.x, p.y), true);
    }
}

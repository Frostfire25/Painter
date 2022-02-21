/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.panels.ImagePanel;
import java.awt.event.MouseEvent;

/**
 *
 * @author Alex
 */
public class DrawingListener extends AListener<DrawingListener, ImagePanel> implements java.awt.event.MouseListener {

    public DrawingListener(ImagePanel imagePanel, Object[] objects) {
        super(imagePanel, objects);
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Painter.getDrawingManager().pressed();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Painter.getDrawingManager().released();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public DrawingListener get() {
        return this;
    }
    
}

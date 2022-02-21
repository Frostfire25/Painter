/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.gui.panels.ImagePanel;
import java.awt.event.MouseEvent;

/**
 *
 * @author Alex
 */
public class MouseListener extends AListener<MouseListener, ImagePanel> implements java.awt.event.MouseListener {

    public MouseListener(ImagePanel imagePanel, Object[] objects) {
        super(imagePanel, objects);
        
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        System.out.println(evt.getPoint().x + " " + evt.getPoint().y);
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
    public MouseListener get() {
        return this;
    }

}

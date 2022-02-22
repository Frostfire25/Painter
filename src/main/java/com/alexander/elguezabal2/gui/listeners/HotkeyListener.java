/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.panels.ImagePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Not a AListener because it goes to Frame
 * @author Alex
 */
public class HotkeyListener implements KeyListener {
 
    /*
    Codes
    Shift = 16
    Ctrl = 17
    
    L = 76
    S = 83
    
    B = 66
    G = 71
    I = 73
    Y = 89
    C = 67
    */
    
    private Frame frame;
    
    /**
     * Default constructor
     * @param frame Frame that calls to this listener.
     */
    public HotkeyListener(Frame frame) {
        this.frame = frame;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }    
    
    @Override
    public void keyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyChar() + " " + evt.getKeyCode() + " " + evt.getKeyLocation());
        Painter.getHotkeyManager().keyPressed(evt.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        Painter.getHotkeyManager().keyReleased(evt.getKeyCode());
    }
        
}

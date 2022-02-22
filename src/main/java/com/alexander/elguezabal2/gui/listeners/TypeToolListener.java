/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.gui.panels.DrawingPanel;
import com.alexander.elguezabal2.managers.DrawingManager;
import com.alexander.elguezabal2.managers.drawing.ToolType;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;

/**
 *
 * @author Alex
 */
public class TypeToolListener extends AListener<TypeToolListener, DrawingPanel> implements ItemListener {

    /**
     * Default constructor
     *
     * @param aPanel Instance of the panel that is using this listener
     * @param objectsThatCalled Instance of the object(s) that are calling this
     * listener.
     */
    public TypeToolListener(DrawingPanel aPanel, Object[] objectsThatCalled) {
        super(aPanel, objectsThatCalled);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        if (evt.getSource() == null || !containsSource(evt.getSource()) || !(evt.getSource() instanceof JRadioButton)) return;
        
        // Gets the Image
        ToolType toolType = ToolType.getByButtonName(((JRadioButton) evt.getSource()).getText());
        
        // Prints out the Tool Type
        System.out.println(toolType.name());
        
        // Changes the Type
        DrawingManager.changeSelectedTool(toolType);
    }

    @Override
    public TypeToolListener get() {
        return this;
    }
}

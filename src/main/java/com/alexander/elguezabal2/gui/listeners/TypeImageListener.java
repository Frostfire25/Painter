/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.listeners;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.panels.TypeImageSelectionPanel;
import com.alexander.elguezabal2.managers.ImageManager;
import com.alexander.elguezabal2.managers.images.ImageType;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;

/**
 *
 * @author Alex
 */
public class TypeImageListener extends AListener<TypeImageListener, TypeImageSelectionPanel> implements ItemListener {

    /**
     * Default constructor
     *
     * @param aPanel Instance of the panel that is using this listener
     * @param objectsThatCalled Instance of the object(s) that are calling this
     * listener.
     */
    public TypeImageListener(TypeImageSelectionPanel aPanel, Object[] objectsThatCalled) {
        super(aPanel, objectsThatCalled);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        if (evt.getSource() == null || !containsSource(evt.getSource()) || !(evt.getSource() instanceof JRadioButton)) return;
        
        // Gets the Image
        ImageType imageType = ImageType.getByButtonName(((JRadioButton) evt.getSource()).getText());
        
        System.out.println(imageType.name());
        
        // Changes the Type
        ImageManager.setOnScreen(imageType);
        
        // Update the Image Panel
        Painter.getFrame().getImagePanel().updateImage(true);
    }

    @Override
    public TypeImageListener get() {
        return this;
    }

}

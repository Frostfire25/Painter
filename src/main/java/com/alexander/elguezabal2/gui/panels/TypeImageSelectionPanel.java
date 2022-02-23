/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.listeners.TypeImageListener;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Alex
 */
public class TypeImageSelectionPanel extends APanel<TypeImageSelectionPanel> {
        
    private JLabel header;
    
    private JRadioButton basic;
    private JRadioButton grayscale;
    private JRadioButton inverted;
    private JRadioButton y_axis;
    public JRadioButton cartoonify;
    
    private ButtonGroup bg;
    
    /**
     * Default constructor 
     * 
     * @param frame frame of this GUI instance
     */
    public TypeImageSelectionPanel(Frame frame) {
        super(frame);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        init();
        initTotalFocusListnersForSubComponents();        
    }
    
    /**
     * Initilizing all components for this class
     */
    private void init() {
        
        bg = new ButtonGroup();
        
        // Initilizes JLabels
        this.header = new JLabel("Image Conversions");
        header.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        
        // Initilizing Radio Buttons
        basic = new JRadioButton("Basic");
        grayscale = new JRadioButton("Grayscale");
        inverted = new JRadioButton("Inverted");
        y_axis = new JRadioButton("Y Axis");
        cartoonify = new JRadioButton("Cartoonify");
        
        
        // Initilizing Button Group
        this.bg.add(getBasic());
        this.bg.add(getGrayscale());
        this.bg.add(getInverted());
        this.bg.add(getY_axis());
        this.bg.add(getCartoonify());
        
        // Initilizing Listener
        // Make sure when adding new filters to register the JButtons in the object array
        // Or the Buttons will not register when clicked.
        TypeImageListener listener = new TypeImageListener(this, new Object[]{getBasic(), getGrayscale(), getInverted(), getY_axis(), getCartoonify()});
        getBasic().addItemListener(listener);
        getGrayscale().addItemListener(listener);
        getInverted().addItemListener(listener);
        getY_axis().addItemListener(listener);
        getCartoonify().addItemListener(listener);

        // Initilizing Font for each Button
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 17);
        getBasic().setFont(font);
        getGrayscale().setFont(font);
        getInverted().setFont(font);
        getY_axis().setFont(font);
        getCartoonify().setFont(font);
               
        // Adding to Panel
        add(header);
        add(new JLabel("\n "));
        add(getBasic());
        add(getGrayscale());
        add(getInverted());
        add(getY_axis());
        add(getCartoonify());
    }

    @Override
    public TypeImageSelectionPanel get() {
        return this;
    }

    /**
     * @return the basic
     */
    public JRadioButton getBasic() {
        return basic;
    }

    /**
     * @return the grayscale
     */
    public JRadioButton getGrayscale() {
        return grayscale;
    }

    /**
     * @return the inverted
     */
    public JRadioButton getInverted() {
        return inverted;
    }

    /**
     * @return the y_axis
     */
    public JRadioButton getY_axis() {
        return y_axis;
    }

    /**
     * @return the bg
     */
    public ButtonGroup getButtonGroup() {
        return bg;
    }

    /**
     * @return the cartoonify
     */
    public JRadioButton getCartoonify() {
        return cartoonify;
    }
}

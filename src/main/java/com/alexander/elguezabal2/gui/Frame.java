package com.alexander.elguezabal2.gui;

import com.alexander.elguezabal2.gui.listeners.HotkeyListener;
import com.alexander.elguezabal2.gui.panels.DrawingPanel;
import com.alexander.elguezabal2.gui.panels.HeaderPanel;
import com.alexander.elguezabal2.gui.panels.ImagePanel;
import com.alexander.elguezabal2.gui.panels.TypeImageSelectionPanel;
import java.awt.BorderLayout;
import java.awt.Component;
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
 *
 * @author Alex
 */
public class Frame extends JFrame {

    // GUI Specifications
    private final int GUI_WIDTH = 920;
    private final int GUI_HEIGHT = 720;

    @Getter
    private int GUI_X_BOUNDS;
    @Getter
    private int GUI_Y_BOUNDS;

    // Panels
    private HeaderPanel headerPanel;
    private ImagePanel imagePanel;
    private TypeImageSelectionPanel typeImageSelectionPanel;
    private DrawingPanel drawingPanel;

    // Total-Focus Listener
    private static HotkeyListener hotkeyListener;
    
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // Image must exist
        if (icon != null) {
            this.setIconImage(icon);
        }
        
        // Allows this frame to be focusable
        setFocusable(true);

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
        // Do listeners first, so all panels can have the listeners
        initListeners();
        initPanels();
    }

    /*
    Initizlies all JPanels
     */
    private void initPanels() {
        this.headerPanel = new HeaderPanel(this);
        this.imagePanel = new ImagePanel(this);
        this.typeImageSelectionPanel = new TypeImageSelectionPanel(this);
        this.drawingPanel = new DrawingPanel(this);

        add(this.getTypeImageSelectionPanel(), BorderLayout.EAST);
        add(this.getHeaderPanel(), BorderLayout.NORTH);
        add(this.getImagePanel(), BorderLayout.CENTER);
        add(this.getDrawingPanel(), BorderLayout.WEST);
    }
    
    /**
     * Initilizes all listeners
     */
    private void initListeners() {
        hotkeyListener = new HotkeyListener(this);
        addKeyListener(this.getHotkeyListener());
    }

    /**
     * @return the headerPanel
     */
    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    /**
     * @return the imagePanel
     */
    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    /**
     * @return the typeImageSelectionPanel
     */
    public TypeImageSelectionPanel getTypeImageSelectionPanel() {
        return typeImageSelectionPanel;
    }

    /**
     * @return the drawingPanel
     */
    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }

    /**
     * @return the hotkeyListener
     */
    public static HotkeyListener getHotkeyListener() {
        return hotkeyListener;
    }
   
}

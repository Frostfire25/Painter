package com.alexander.elguezabal2;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.managers.DrawingManager;
import com.alexander.elguezabal2.managers.HotkeyManager;
import com.alexander.elguezabal2.managers.ImageManager;
import com.alexander.elguezabal2.timers.DrawingTimer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main class for this project.
 *
 * @author Alex
 */
public class Painter {

    private static Frame frame;
    private static ImageManager mainImageManager;
    private static DrawingManager drawingManager;
    private static HotkeyManager hotkeyManager;
    
    private static DrawingTimer drawingTimer;

    public static void main(String[] args) {

        // Updates the look and feel to windows.
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

        // Managers
        
        mainImageManager = new ImageManager();
        drawingManager = new DrawingManager();
        hotkeyManager = new HotkeyManager();
        
        // Timers
        drawingTimer = new DrawingTimer(drawingManager);

        // Loads the frame 
        SwingUtilities.invokeLater(() -> {
            // Assigns the frame
            frame = new Frame();
        });
    }

    /**
     * @return the frame
     */
    public static Frame getFrame() {
        return frame;
    }

    /**
     * @return the mainImageManager
     */
    public static ImageManager getMainImageManager() {
        return mainImageManager;
    }

    /**
     * @return the drawingManager
     */
    public static DrawingManager getDrawingManager() {
        return drawingManager;
    }

    /**
     * @return the hotkeyManager
     */
    public static HotkeyManager getHotkeyManager() {
        return hotkeyManager;
    }

}

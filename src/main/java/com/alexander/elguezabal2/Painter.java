package com.alexander.elguezabal2;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.managers.DrawingManager;
import com.alexander.elguezabal2.managers.MainImageManager;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main class for this project.
 * @author Alex
 */
public class Painter {
    
    private static Frame frame;
    private static MainImageManager mainImageManager;
    public static DrawingManager drawingManager;
    
    public static void main(String[] args) {    
        
        // Updates the look and feel to windows.
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        
        mainImageManager = new MainImageManager();
        drawingManager = new DrawingManager();
        
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
    public static MainImageManager getMainImageManager() {
        return mainImageManager;
    }

    /**
     * @return the drawingManager
     */
    public static DrawingManager getDrawingManager() {
        return drawingManager;
    }
    
}

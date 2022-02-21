package com.alexander.elguezabal2;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.managers.MainImageManager;
import javax.swing.SwingUtilities;

/**
 * Main class for this project.
 * @author Alex
 */
public class Painter {
    
    private static Frame frame;
    private static MainImageManager mainImageManager;
    
    public static void main(String[] args) {
     
        mainImageManager = new MainImageManager();
        
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
    
}

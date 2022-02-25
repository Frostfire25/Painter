/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.gui.panels;

import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.panels.APanel;
import com.alexander.elguezabal2.managers.images.AImage;
import com.alexander.elguezabal2.util.Pair;
import com.alexander.elguezabal2.util.Triple;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alex
 */
public class InformationPanel extends APanel<InformationPanel> {

    private final String resolutionHeader = "Resolution - %sx%s";
    private final String fileNameHeader = "Filename - %s";
    private final String averageRGBHeader = "Average R,G,B - [%s,%s,%s]";

    private JLabel resolution;
    private JLabel fileName;
    private JLabel averageRGB;

    /**
     * Default constructor
     *
     * @param frame Instance of the frame that uses this panel
     */
    public InformationPanel(Frame frame) {
        super(frame);
        init();
        
    }

    /**
     * Initilizes the components
     */
    private void init() {
        final Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);

        this.resolution = new JLabel(new String(resolutionHeader).replaceAll("%s", "").replaceAll("x", ""));
        this.fileName = new JLabel(new String(fileNameHeader).replaceAll("%s", ""));
        this.averageRGB = new JLabel(new String(averageRGBHeader).replaceAll("%s", "0"));

        this.resolution.setFont(font);
        this.fileName.setFont(font);
        this.averageRGB.setFont(font);
        
        add(resolution);
        add(fileName);
        add(averageRGB);
    }

    @Override
    public InformationPanel get() {
        return this;
    }
    
    /**
     * Updates the information tags
     * 
     * @param aImage The that is being updated
     */
    public void update(AImage aImage) {
        // If there is no image, set the default values again.
        if(aImage == null) { removeAll(); init(); }
        
        // Updates the resolution
        Pair<Integer, Integer> resolutionPair = aImage.calculateResolution();
        this.resolution.setText(new String(resolutionHeader).replace("%s", ""+resolutionPair.getValue1()).replace("%s", ""+resolutionPair.getValue2()));
        
        // Updates the file name
        this.fileName.setText(new String(fileNameHeader).replaceAll("%s", aImage.getFilename()));
        
        // Updates the rgb values
        Triple<Integer, Integer, Integer> rgbTriple = aImage.getAverageRGB();
        this.averageRGB.setText(new String(averageRGBHeader).replace("%s", ""+rgbTriple.getValue1()).replace("%s", ""+rgbTriple.getValue2()).replace("%s", ""+rgbTriple.getValue3()));
        
        // Updates the screen
        revalidate();
    }

}

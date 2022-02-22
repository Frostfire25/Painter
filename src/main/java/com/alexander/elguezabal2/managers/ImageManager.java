package com.alexander.elguezabal2.managers;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.managers.images.AImage;
import com.alexander.elguezabal2.managers.images.BaseImage;
import com.alexander.elguezabal2.managers.images.GrayScaleImage;
import com.alexander.elguezabal2.managers.images.ImageType;
import com.alexander.elguezabal2.managers.images.InvertedColorsImage;
import com.alexander.elguezabal2.managers.images.YAxisMirroredImage;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Manager class for the main image
 * A static class.
 * 
 * @author Alex
 */
public class ImageManager {
    
    // Static because only one image can be displayed on screen at a time.
    public static ImageType onScreen;
    
    // Static image because I only want one to be loaded;
    private static BaseImage baseImage;
    private static GrayScaleImage grayScaleImage;
    private static InvertedColorsImage invertedColorsImage;
    private static YAxisMirroredImage yAxisMirroredImage;
    
    private HashSet<AImage> allImages;
    
    public ImageManager() {
        this.baseImage = null;
        this.onScreen = ImageType.NONE;
        allImages = new HashSet<>();
    }
    
    public static final int IMAGE_HEIGHT = 500;
    public static final int IMAGE_WIDTH = 500;
    
    /**
     * Loads in an image to all the image manager
     * 
     * @param image Image to be loaded in.
     */
    public void loadImage(Image image) {       
        // Scales the original image
        Image scaled = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT);
        
        // Resets all images, because we have a new image, new image templates.
        allImages = new HashSet<>();
        
        // Updates the images 
        this.baseImage = new BaseImage(Painter.getFrame(), scaled);
        this.grayScaleImage = new GrayScaleImage(Painter.getFrame(), scaled);
        this.invertedColorsImage = new InvertedColorsImage(Painter.getFrame(), scaled);
        this.yAxisMirroredImage = new YAxisMirroredImage(Painter.getFrame(), scaled);
        
        // Adds the image type to the frames collection
        allImages.add(baseImage);
        allImages.add(grayScaleImage);
        allImages.add(invertedColorsImage);
        allImages.add(yAxisMirroredImage);
        
        // Updates the type of image on the users screen
        // Whenever an image is loaded, we want the base image to be shown.
        setOnScreen(ImageType.BASE_IMAGE);
       
        // Updates the image on screen
        Painter.getFrame().getImagePanel().addAllPanels(allImages);
        Painter.getFrame().getImagePanel().updateImage();
    }
    
    public AImage getImage() {
        return allImages.stream().filter(n -> n.getImageType() == getOnScreen()).findFirst().orElse(null);
    }

    /**
     * @return the onScreen
     */
    public static ImageType getOnScreen() {
        return onScreen;
    }

    /**
     * @param aOnScreen the onScreen to set
     */
    public static void setOnScreen(ImageType aOnScreen) {
        onScreen = aOnScreen;
    }
  
    /**
     * Updates the color of a pixel on the current image
     * 
     * @param point Point to be colored
     * @param color Color to color
     */
    public void paintOnImage(Point point, Color color, int size) {
        // Get the current image instance
        AImage aImage = getImage();
        
        // Don't paint on it if it doesn't exist
        if(aImage == null) return;
        
        // Paints on the image and updates it
        aImage.paintPixel(point, color, size);
        
        // Updates the image
        Painter.getFrame().getImagePanel().updateImage();
    }
    
    /**
     * Prompts the user to load an image
     * Uses JFileChooser, haulting any GUI interaction.
     */
    public void loadImage() {
        File file = null;
        
        // (! https://mkyong.com/swing/java-swing-jfilechooser-example/)  
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home") + "/Pictures");
        jfc.setDialogTitle("Load Picture");

        int returnValue = jfc.showOpenDialog(Painter.getFrame());
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            
            System.out.println(file.getPath());
            // Determines if the file selected is an image, if not an erro is displayed.
            if (!file.getPath().endsWith(".png") && !file.getPath().endsWith(".jpg")) {
                JOptionPane.showMessageDialog(null, "A incorrect file-type was selected, please only chose PNGs and JPGs.");
                return;
            }
        }  
        // Displays an error if no file was selected
        else {
            JOptionPane.showMessageDialog(null, "You did not select a file");
            return;
        }
        
       try {
           if (file != null) {
               loadImage(ImageIO.read(file));
           }
       } catch (IOException e) {
           e.printStackTrace();
       }       
    }
    
     /**
     * Prompts the user to save the screened image
     * Uses JFileChooser, haulting any GUI interaction.
     */
    public void saveImage() {
        
        // Gets the image to save
        AImage aImage = getImage();
        if(aImage == null) {JOptionPane.showMessageDialog(null, "You have no image loaded to save."); return;}
        Image image = aImage.getFilteredImage();
        if(image == null) {JOptionPane.showMessageDialog(null, "You have no image loaded to save."); return;}
        
        File file = null;
        
        // (! https://www.codejava.net/java-se/swing/show-save-file-dialog-using-jfilechooser)  
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home") + "/Pictures");
        jfc.setDialogTitle("Save Picture");
        
        int returnValue = jfc.showSaveDialog(Painter.getFrame());

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            
            System.out.println(file.getPath());
            // Determines if the file selected is an image, if not an erro is displayed.
            if (!file.getPath().endsWith(".png") && !file.getPath().endsWith(".jpg")) {
                JOptionPane.showMessageDialog(null, "A incorrect file-type was selected, please only chose PNGs and JPGs.");
                return;
            }
        }  
        // Displays an error if no file was selected
        else {
            JOptionPane.showMessageDialog(null, "You did not select a file");
            return;
        }
        
        // Check to see if the file already exists
        if(file.exists()) {
            // Prompt the user if they want to override.
            int value = JOptionPane.showConfirmDialog(null, "This File already exists, would you like to override it?", "File Exists", JOptionPane.YES_NO_OPTION);
            if(value != 0) return;
            
            // Delets files
            file.delete();
        }
        
        String type = (file.getPath().endsWith(".png") ? "png" : "jpg"); 
        
       // Writing the Image out
       try {
           ImageIO.write(aImage.toBufferedImage(image), type, file);
       } catch (IOException e) {
           e.printStackTrace();
       }   
       

    }
    
}

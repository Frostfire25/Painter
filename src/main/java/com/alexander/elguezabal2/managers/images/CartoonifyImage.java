/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexander.elguezabal2.managers.images;

import com.alexander.elguezabal2.Painter;
import com.alexander.elguezabal2.gui.Frame;
import com.alexander.elguezabal2.gui.panels.ImagePanel;
import com.alexander.elguezabal2.managers.ImageManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Alex
 */
public class CartoonifyImage extends AImage<CartoonifyImage> {

     /**
     * Default Constructor for CartoonifyImage
     * 
     * @param frame Super frame
     * @param baseImage Basic version of the image
     */
    public CartoonifyImage(Frame frame, Image baseImage) {
        super(frame, baseImage, ImageType.CARTOONIFY_IMAGE);
        
        // Sets the filtered image
        setFilteredImage(filter(baseImage));
        
        initTotalFocusListnersForSubComponents();
    }
    
        /**
     * Filters {@code image} to Cartoonify
     * Used parts of code from 
     * 
     * @param image Image to be filtered
     * @return 
     */
    private Image filter(Image image) {
       
       BufferedImage bufferedImage = toBufferedImage(image);
       BufferedImage refrenceImage = toBufferedImage(image);           
       
        // Does Cartoonify
        for (int i = 1; i < ImageManager.IMAGE_WIDTH - 1; i++) {
            for (int j = 1; j < ImageManager.IMAGE_HEIGHT - 1; j++) {
                
                //Color c = new Color(bufferedImage.getRGB(j, i));

                // Do median filtering
                
                // Makes a matracie of points
                Point[] matrix = getMatrixFromPoint(i, j);
                
                // Calculates the median color from the points
                Color color = calculateMedianColorOfAnPoint(refrenceImage, matrix);
                
                // Changes the color of the pixel
                bufferedImage.setRGB(j, i, color.getRGB());
                
            }
        }

       
        return bufferedImage;
    }
    
    /**
     * Gets the median color from a matrix
     * 
     * @param bf Image to refrence
     * @param matrix Matrix of points
     * 
     * @return Median color
     */
    private Color calculateMedianColorOfAnPoint(BufferedImage bf, Point[] matrix) {
        
        // List of the rgb values in the matrix
        ArrayList<Integer> redMatrix = new ArrayList<>();
        ArrayList<Integer> greenMatrix = new ArrayList<>();
        ArrayList<Integer> blueMatrix = new ArrayList<>();
                
        // Loops through all points and adds them to colorMatrix
        for(int i = 0; i < 9; i++) {
            // Color of the pixel
            Color color = new Color(bf.getRGB(matrix[i].x, matrix[i].y));

            // Adds the RGB values
            redMatrix.add(color.getRed());
            greenMatrix.add(color.getGreen());
            blueMatrix.add(color.getBlue());

        }
        
        // Sorts the matracies
        Collections.sort(redMatrix);
        Collections.sort(greenMatrix);
        Collections.sort(blueMatrix);

        
        // Gets the Median color
        return new Color(redMatrix.get(4), blueMatrix.get(4), greenMatrix.get(4), 255);
    }
    
    /**
     * Creates a 3x3 matrix of elements from a point
     * 
     * @param i X value
     * @param j Y value
     * @return a 3x3 matrix of points
     */
    private Point[] getMatrixFromPoint(int i, int j) {
        Point[] matrix = new Point[9];
        matrix[0] = new Point(j - 1, i - 1);
        matrix[1] = new Point(j - 1, i);
        matrix[2] = new Point(j - 1, i + 1);

        matrix[3] = new Point(j, i - 1);
        matrix[4] = new Point(j, i);
        matrix[5] = new Point(j, i + 1);

        matrix[6] = new Point(j + 1, i - 1);
        matrix[7] = new Point(j + 1, i);
        matrix[8] = new Point(j + 1, i + 1);
        
        return matrix;
    }
    
    /**
     * Paints The image and a surrounding box on screen
     * Only paints an image if an image is loaded.
     * 
     * @param g Graphics.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        System.out.println("here painted Cartoonify Image");
        
        // Loads the image, if non-null.
        AImage aImage = Painter.getMainImageManager().getImage();
                        
        if(aImage != null) {
            Image image = aImage.getFilteredImage();
            g.drawImage(image, ImagePanel.IMAGE_X_POINT, ImagePanel.IMAGE_Y_POINT, image.getWidth(getFrame()), image.getHeight(getFrame()), getFrame());
        }
        
        // Draws the box around the image
        for(int i = 1; i <= 7; i++) {
            g.draw3DRect(ImagePanel.IMAGE_X_POINT-i, ImagePanel.IMAGE_Y_POINT-i, ImageManager.IMAGE_WIDTH+1, ImageManager.IMAGE_HEIGHT+1, false);
        }
                
    }
    
    @Override
    public Image getFilteredImage() {
        return filteredImage;
    }
    
    @Override
    public CartoonifyImage get() {
        return this;
    }
    
}

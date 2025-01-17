package org.example;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Arrays;

public class Picture {

    private File imageFile;
    private  BufferedImage bImage , scaledImage; // Reserve objects for repeated use
    private Graphics2D g2d;
    private double maxWidth = 1280, maxHeight = 720 , scaleWidth , scaleHeight  , scale;
    private int originalWidth , originalHeight , scaledWidth , scaledHeight;
    private String extension;
    private boolean isSupported;


    public Picture(){
    }


    public BufferedImage setImage(String imgPath) throws IOException{

        // Load file
        imageFile = new File(imgPath);

        // verify that it exists
        if (!imageFile.exists()) {
            throw new IOException("File not found: " + imgPath);
        }

        // Get file extension
        extension = imgPath.substring(imgPath.lastIndexOf(".") + 1).toLowerCase();
        String[] supportedFormats = ImageIO.getReaderFormatNames();
        isSupported = Arrays.asList(supportedFormats).contains(extension);
        if (!isSupported) {
            throw new IOException("Unsupported image format: " + extension);
        } // Check if format is supported

        // Read image
        bImage = ImageIO.read(imageFile); // Img now stored
        if (bImage == null){
            throw new IOException("Failed to load Image : " + imgPath );}

        //Scale image
        scaleImage();

        return bImage;// Send loaded image to be scaled and return it.
    }


    public void getImageData(){}


    private void scaleImage (){

        // Get values from original
        originalWidth = bImage.getWidth();
        originalHeight = bImage.getHeight();
        //Calculate Scaling factors
        scaleWidth = (double)maxWidth / originalWidth;
        scaleHeight = (double)maxHeight / originalHeight;
        scale = Math.min(scaleWidth , scaleHeight);

        // If the image is smaller refrain from scaling it
        if (scale > 1.0){
            System.exit(0);
        }

        // Calculate new Dimensions
        scaledWidth = (int) (originalWidth*scale);
        scaledHeight = (int) (originalHeight*scale);

        // Create new scaled image
        scaledImage = new BufferedImage(originalWidth , originalHeight , BufferedImage.TYPE_INT_ARGB);
        g2d = scaledImage.createGraphics();
        // Set rendering hints
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION , RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING , RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw
        g2d.drawImage(bImage , 0 , 0 , scaledWidth , scaledHeight , null);
        g2d.dispose();
    }
}

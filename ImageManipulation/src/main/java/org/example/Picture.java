package org.example;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Arrays;

public class Picture {


    private File imageFile;
    private  BufferedImage bOrigImage, bScaledImage; // Reserve objects for repeated use
    private Graphics2D g2d;
    private double maxWidth = 1920, maxHeight = 1080 , scaleWidth , scaleHeight  , scale;
    private int originalWidth , originalHeight , scaledWidth , scaledHeight;
    private String extension;
    private boolean isSupported;


    public Picture(){
    }


    public BufferedImage setImage(String imgPath) throws IOException{

        // Load file
        imageFile = new File(imgPath);

        // Verify that it exists
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
        bOrigImage = ImageIO.read(imageFile); // Img now stored
        if (bOrigImage == null){
            throw new IOException("Failed to load Image : " + imgPath );}

        // Scale image
        scaleImage();

        return bScaledImage;// Send scaled image
    }


    public void getImageData(){/*To-Do*/}


    private void scaleImage (){

        // Get values from original
        originalWidth = bOrigImage.getWidth();
        originalHeight = bOrigImage.getHeight();
        //Calculate Scaling factors
        scaleWidth = (double)maxWidth / originalWidth;
        scaleHeight = (double)maxHeight / originalHeight;
        scale = Math.min(scaleWidth , scaleHeight);

        // If the image is smaller refrain from scaling it
        if (scale > 1.0){
            bScaledImage = bOrigImage;
            return;
        }

        // Calculate new Dimensions
        scaledWidth = (int) (originalWidth*scale);
        scaledHeight = (int) (originalHeight*scale);

        // Create new scaled image
        bScaledImage = new BufferedImage(scaledWidth , scaledHeight , BufferedImage.TYPE_INT_ARGB);
        g2d = bScaledImage.createGraphics();
        // Set rendering hints
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION , RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING , RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw
        g2d.drawImage(bOrigImage, 0 , 0 , scaledWidth , scaledHeight , null);
        g2d.dispose();
    }
}

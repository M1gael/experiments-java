package org.example;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Picture {


    public Picture(){
    }

    public BufferedImage setImage(String imgPath) throws IOException{
        BufferedImage bImage = ImageIO.read(new File(imgPath)); // Img now stored
        return bImage; // Send loaded image back.
    }
}

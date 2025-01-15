package org.example;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Picture {

    public UI userInterface = new UI();

    public Picture(){
    }

    public void setImage(String imgPath) throws IOException{
        BufferedImage bImage = ImageIO.read(new File(imgPath)); // Img now stored
        userInterface.loadIcon(bImage);
    }
}

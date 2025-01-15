package org.example;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class UI extends JFrame{

    private JLabel displayLabel = new JLabel(); // Declare label for public use

    UI(){

        this.setSize(1280 , 720); // Stage frame
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        displayLabel.setText("Load Picture"); // Stage label defaults
        displayLabel.setSize(1279 , 719);
        displayLabel.setHorizontalAlignment(JLabel.CENTER);
        displayLabel.setVerticalAlignment(JLabel.CENTER);

        this.add(displayLabel); // add label

    }

    public void loadIcon(BufferedImage image){
        ImageIcon imageIcon = new ImageIcon(image);
        displayLabel.setIcon(imageIcon);
    }
}

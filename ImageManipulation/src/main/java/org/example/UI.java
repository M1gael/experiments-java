package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UI extends JFrame{
    //Instantiate objects that will have repeated use from class initiation
    private  FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
    private JLabel displayLabel = new JLabel();

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

    public String chooseFile(){
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();
        dialog.dispose();
        return file + " chosen.";
    }

    public void loadIcon(BufferedImage image){
        ImageIcon imageIcon = new ImageIcon(image);
        displayLabel.setIcon(imageIcon);
    }
}

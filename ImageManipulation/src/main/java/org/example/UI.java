package org.example;

import javax.swing.*;

public class UI extends JFrame{

    public JLabel displayLabel = new JLabel();

    UI(){

        this.setSize(1280 , 720);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        displayLabel.setText("Load Image");
        displayLabel.setSize(1279 , 719);
        displayLabel.setHorizontalAlignment(JLabel.CENTER);
        displayLabel.setVerticalAlignment(JLabel.CENTER);

        this.add(displayLabel);

    }

    public void loadIcon(Image icon){
        //displayLabel.setIcon();
    }
}

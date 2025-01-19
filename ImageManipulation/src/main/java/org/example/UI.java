package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI extends JFrame implements ActionListener {

    private String imgPath = null;
    private  FileDialog dialog ;
    private Picture myPicture;
    private JLabel displayLabel ; //Reserve objects that will have repeated use from class initiation
    private JButton btnChooseImage , btnClose;

    UI(){
        myPicture = new Picture();
        this.setSize(1920 , 1080); // Stage frame
        this.setResizable(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);

        displayLabel = new JLabel();
        //displayLabel.setText("Load Picture"); // Stage label defaults
        displayLabel.setBounds( 0 ,  0 , 1600 , 1080);
        displayLabel.setHorizontalAlignment(JLabel.CENTER);
        displayLabel.setVerticalAlignment(JLabel.CENTER);
        displayLabel.setForeground(Color.green);
        // Choose Image
        btnChooseImage = new JButton("Choose Image");
        btnChooseImage.setBounds(1650, 50, 150, 50);
        btnChooseImage.addActionListener(this); // Attach listener
        // Close
        btnClose = new JButton("Close Application");
        btnClose.setBounds(1650, 120, 150, 50);
        btnClose.addActionListener(this); // Attach listener

        this.add(displayLabel); // add label
        this.add(btnChooseImage);
        this.add(btnClose);
        this.setVisible(true);
    }

    public String chooseFile(){
        dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String fileName = dialog.getFile();
        String fileDir = dialog.getDirectory();
        dialog.dispose();
        return fileDir + fileName ; // Have it return the dir and filename concat to be used
    }

    public void loadIcon(BufferedImage image){
        ImageIcon imageIcon = new ImageIcon(image);
        displayLabel.setIcon(imageIcon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChooseImage){
            try{loadIcon(myPicture.setImage(chooseFile()));}
            catch (IOException j){j.printStackTrace();}
        }
        if (e.getSource() == btnClose){System.exit(0);}
    }
}

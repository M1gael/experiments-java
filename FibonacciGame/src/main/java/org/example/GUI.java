package org.example;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    JFrame frame = new JFrame();
    JLabel machineOutLbl = new JLabel();
    JButton yesBtn = new JButton();
    JButton noBtn = new JButton();

    public GUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);

        yesBtn.setText("True");
        noBtn.setText("False");
        yesBtn.setFocusable(false);
        noBtn.setFocusable(false);

        machineOutLbl.setBounds(10 , 10 , 600 , 25);
        machineOutLbl.setText("I will speak here");

        yesBtn.setBounds(200 , 400 , 80 , 40);
        noBtn.setBounds(275 , 400 , 80 , 40);
        yesBtn.setVisible(true);
        noBtn.setVisible(true);

        frame.add(machineOutLbl);
        frame.add(yesBtn);
        frame.add(noBtn);
    }


}

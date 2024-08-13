package org.example;

import javax.swing.*;

public class GUI extends JFrame {
    JFrame frame = new JFrame();
    JLabel machineOutLbl = new JLabel();

    public GUI(){
        frame.setLayout(null);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        machineOutLbl.setBounds(10 , 10 , 600 , 25);
        machineOutLbl.setText("I will speak here");

        frame.add(machineOutLbl);
    }


}

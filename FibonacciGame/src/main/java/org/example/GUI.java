package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    JFrame frame = new JFrame();
    JLabel machineOutLbl = new JLabel();
    JButton yesBtn = new JButton();
    JButton noBtn = new JButton();
    JButton retryBtn = new JButton();

    Machine machine = new Machine();

    public GUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);

        yesBtn.setText("True");
        noBtn.setText("False");
        retryBtn.setText("Retry");
        yesBtn.setFocusable(false);
        noBtn.setFocusable(false);
        retryBtn.setFocusable(false);
        yesBtn.addActionListener(this);
        noBtn.addActionListener(this);
        retryBtn.addActionListener(this);

        machineOutLbl.setBounds(10 , 10 , 600 , 25);
        machineOutLbl.setText("I will speak here");

        yesBtn.setBounds(200 , 400 , 80 , 40);
        noBtn.setBounds(275 , 400 , 80 , 40);
        retryBtn.setBounds(240 , 350 , 80 , 40);
        yesBtn.setVisible(true);
        noBtn.setVisible(true);
        retryBtn.setVisible(true);

        frame.add(machineOutLbl);
        frame.add(yesBtn);
        frame.add(noBtn);
        frame.add(retryBtn);

        machineOutLbl.setText(machine.printGuess());
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==yesBtn){
            machineOutLbl.setText(machine.printAnswer(true));
        }else if (e.getSource()==noBtn) {
            machineOutLbl.setText( machine.printAnswer(false));
        }else {
            machine.printGuess();
        }

    }

}

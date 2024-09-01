import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class LoginPage implements ActionListener {

    //Instancing UI Elements
    JFrame frame = new JFrame();

    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JTextField userIdField = new JTextField("");
    JPasswordField userPasswordField = new JPasswordField("");

    JLabel userIdLabel = new JLabel("User ID:");
    JLabel passwordLabel = new JLabel("Password :");
    JLabel messageLabel = new JLabel();
    JLabel statusMessageLabel = new JLabel("Login Status : ");

    //Create new hashM to mirror recieved hashmap to be golablly avail to login page
    HashMap<String,String> loginInfo = new HashMap<String,String>();

    LoginPage(HashMap<String, String> loginInfoConstr){
        this.loginInfo = loginInfoConstr;

        //Labels
        userIdLabel.setBounds(40,100, 75 , 25);
        passwordLabel.setBounds(20,150, 100 , 25);
        messageLabel.setBounds(125, 250 , 250 , 35);
        messageLabel.setFont(new Font(null , Font.ITALIC,15));
        //Fields
        userIdField.setBounds(125, 100 , 200 , 25);
        userPasswordField.setBounds(125, 150 , 200 , 25);
        //LoginButton
        loginButton.setBounds(125 , 200 , 100 ,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        //ResetButton
        resetButton.setBounds(225 , 200 , 100 ,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        //Add elements to frame
        frame.add(userIdLabel);
        frame.add(passwordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        //Set up frame the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource()==resetButton) {
            userIdField.setText("");
            userPasswordField.setText("");
        }

        if (actionEvent.getSource()==loginButton){
            String userID = userIdField.getText();
            String password = String.valueOf(userPasswordField.getPassword()); //Works differently , converts password to string.

            if (loginInfo.containsKey(userID)){
                if (loginInfo.get(userID).equals(password)){ //.get returns the equivalent "Y" value for matching key and compares it
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login successful for " + userID + " " + password);
                    frame.dispose();//Kills the current frame
                    WelcomePage welcomePage = new WelcomePage(userID); //Instance Login page and pass userID
                }
                else {
                    messageLabel.setForeground(Color.red); // Runs if User ID exists but no password found.
                    messageLabel.setText("Wrong Password");
                }
            }
            else {
                messageLabel.setForeground(Color.orange); // Runs if User ID exists but no password found.
                messageLabel.setText("User not found");
            }
        }
    }
}

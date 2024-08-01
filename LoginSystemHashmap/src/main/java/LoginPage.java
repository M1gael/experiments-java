import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    //Instancing UI Elements
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("User ID:");
    JLabel passwordLabel = new JLabel("User Password:");
    JLabel statusMessageLabel = new JLabel("Login Status : ");
    //Create new hashM to mirror recieved hashmap to be golablly avail to login page
    HashMap<String,String> loginInfo = new HashMap<String,String>();

    LoginPage(HashMap<String, String> loginInfoConstr){
        this.loginInfo = loginInfoConstr;

        //Customise elements
        userIdLabel.setBounds(50,100, 75 , 25);
        passwordLabel.setBounds(50,150, 75 , 25);

        //Add elements to frame
        frame.add(userIdLabel);
        frame.add(passwordLabel);

        //Set up frame the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

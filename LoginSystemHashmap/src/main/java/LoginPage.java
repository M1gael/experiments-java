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
        loginInfo = this.loginInfoConstr;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

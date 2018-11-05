import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import java.awt.*;


public class Login extends JFrame {
    public static void main(String[] args) {

        // LOGIN Window --- Username & Password
        JFrame JFrameWindow = new JFrame();

        JFrameWindow.setTitle("Login");
        JFrameWindow.setSize(1000, 500);
        JFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainLoginPanel = new JPanel();
        JFrameWindow.getContentPane().add(mainLoginPanel);

        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;

        mainLoginPanel.add(loginPanel);



        JLabel loginLabel = new JLabel("Login");
        c.gridx = 0;
        c.gridy = 1;
        loginPanel.add(loginLabel);


        JLabel userLabel = new JLabel("Username\n");
        c.gridx = 2;
        c.gridy = 2;
        loginPanel.add(userLabel);

        JLabel passwordLabel = new JLabel("\nPassword");
        loginPanel.add(passwordLabel);

        JTextField userField = new JTextField(20);
        loginPanel.add(userField);

        JTextField passwordField = new JTextField(15);
        loginPanel.add(passwordField);

        JButton submitButton = new JButton("Submit");
        loginPanel.add(submitButton);


        JButton clearButton = new JButton("Clear");
        loginPanel.add(clearButton);


        JFrameWindow.setVisible(true);


    }
}



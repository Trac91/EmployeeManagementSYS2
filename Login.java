import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import java.awt.*;


public class Login extends JFrame {
    public static void main(String[] args) {

        // LOGIN Window --- Username & Password
        JFrame JFrameWindow = new JFrame();

        JFrameWindow.setTitle("Login");
        GridBagLayout flowLayout = new GridBagLayout();
        JFrameWindow.setLayout(flowLayout);
        JFrameWindow.setSize(1000, 500);
        JFrameWindow.setBackground(Color.blue);

        JFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setLocation(30, 50);
        JFrameWindow.add(loginLabel);

        JLabel userLabel = new JLabel("Username\n");
        JFrameWindow.add(userLabel);

        JTextField userField = new JTextField(20);
        JFrameWindow.add(userField);

        JLabel passwordLabel = new JLabel("\nPassword");
        JFrameWindow.add(passwordLabel);

        JTextField passwordField = new JTextField(15);
        JFrameWindow.add(passwordField);

        JButton submitButton = new JButton("Submit");
        JFrameWindow.add(submitButton);



        JButton clearButton = new JButton("Clear");
        JFrameWindow.add(clearButton);

        JFrameWindow.setVisible(true);


    }

     /*   JFrame optionWindow = new JFrame();
        JFrameWindow.setTitle("Select");
        FlowLayout optionLayout = new FlowLayout();
        JFrameWindow.setLayout(optionLayout);
        JFrameWindow.setSize(1000,500);
        JFrameWindow.setBackground(Color.blue);

        JButton employeeButton = new JButton("Employee Management System");
        JFrameWindow.add(employeeButton);

        JButton mortgageButton = new JButton("Mortgage Calculator");
        JFrameWindow.add(mortgageButton);

        JFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrameWindow.setVisible(true);

*/
}



import javax.swing.*;
import java.awt.*;


public class UserLogin {
    public void userLogin()
    {
        JPanel mainLoginPanel = new JPanel();
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints cLogin = new GridBagConstraints();
        loginPanel.setSize(300,500);
        loginPanel.setBackground(Color.lightGray);
        cLogin.gridx=0;
        cLogin.gridy=0;

        mainLoginPanel.add(loginPanel,cLogin);

        JLabel userLabel = new JLabel("Username\n");
        cLogin.gridx = 0;
        // cLogin.gridy ++;
        cLogin.anchor = GridBagConstraints.LINE_END;
        cLogin.insets = new Insets(30,15,0,0);
        loginPanel.add(userLabel,cLogin);

        JLabel passwordLabel = new JLabel("\nPassword");
        cLogin.gridx = 0;
        cLogin.gridy = 1;
        loginPanel.add(passwordLabel,cLogin);

        // Create Login fields
        JTextField userField = new JTextField(20);
        cLogin.gridx = 1;
        cLogin.gridy = 0;
        loginPanel.add(userField,cLogin);

        // Password
        JPasswordField passwordField = new JPasswordField(20);
        cLogin.gridx = 1;
        cLogin.gridy = 1;
        cLogin.anchor = GridBagConstraints.LINE_START;
        cLogin.insets = new Insets(30,20,5,0);
        loginPanel.add(passwordField,cLogin);

        // Create Login submit button
        JButton submitButton = new JButton("Submit");
        cLogin.gridx = 4;
        cLogin.gridy = 2;
        cLogin.insets = new Insets(15,0,10,20);
        cLogin.anchor = GridBagConstraints.LINE_START;
        // add submit button
        loginPanel.add(submitButton,cLogin);

        // Create Login clear button
        JButton clearButton = new JButton("Clear");
        cLogin.gridx = 3;
        cLogin.gridy = 2;
        cLogin.insets = new Insets(15,0,10,20);
        // add clear button
        loginPanel.add(clearButton,cLogin);

        // show on JFrame
        loginPanel.setVisible(true);


    }



}

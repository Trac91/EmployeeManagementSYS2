import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class menuGUI extends JFrame {
    public static void main(String[] args) {


        // Create Application Window
        JFrame JFrameWindow = new JFrame();
        JFrameWindow.setTitle("Employee Management System");
        JFrameWindow.setSize(1000,600);
        JFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(); // Creates Main Panel where additional panels will be on top
        JFrameWindow.getContentPane().add(mainPanel);

        JPanel employeeForm = new JPanel(new GridBagLayout()); // Employee details panel
        employeeForm.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        mainPanel.add(employeeForm);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10,20,5,20);


        JLabel idLabel = new JLabel("Employee ID");
        employeeForm.add(idLabel,c);
        c.gridy++; // Moves to row below

        JLabel nameLabel = new JLabel("\nName\n");
        employeeForm.add(nameLabel,c);
        c.gridy++;

        JLabel addressLabel = new JLabel("\nAddress\n");
        employeeForm.add(addressLabel,c);
        c.gridy++;

        JLabel emailLabel = new JLabel("\nEmail");
        employeeForm.add(emailLabel,c);
        c.gridy++;

        JLabel phoneLabel = new JLabel("\nPhone No.");
        employeeForm.add(phoneLabel,c);
        c.gridy++;

        JLabel departmentLabel = new JLabel("Department");
        employeeForm.add(departmentLabel,c);
        c.gridy++;

        JLabel jobTitleLabel = new JLabel("Title");
        employeeForm.add(jobTitleLabel,c);
        c.gridy++;

        c.gridx=1;
        c.gridy=0;
        c.anchor = GridBagConstraints.LINE_START;


        JTextField idField = new JTextField(7);
        employeeForm.add(idField,c);
        c.gridy++;

        JTextField nameField = new JTextField(20);
        employeeForm.add(nameField,c);
        c.gridy++;


        JTextArea addressField = new JTextArea(5,20);
        employeeForm.add(addressField,c);
        c.gridy++;

        JTextField emailField = new JTextField(20);
        employeeForm.add(emailField,c);
        c.gridy++;

        JTextField phoneField = new JTextField(20);
        employeeForm.add(phoneField,c);
        c.gridy++;

        String [] departments = {"Accounts", "Mortgages", "Front Desk", "Marketing"};
        JComboBox departmentField = new JComboBox(departments);
        employeeForm.add(departmentField,c);
        c.gridy++;

        String [] jobTitles = {"Branch Manager","Accounts Manager", "Mortgage Manager", "General Manager", "Marketing Manager", "Admin", "Mortgage Consultants", "Bank Teller","Marketing Consultants"};

        JComboBox divisionField = new JComboBox(jobTitles);
        employeeForm.add(divisionField,c);
        c.gridy++;

        JButton clearButton = new JButton("Clear");
        c.gridx = 0;
        c.gridy = 7;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(20,20,20,20);
        employeeForm.add(clearButton,c);

        JButton registerButton = new JButton("Register Employee");
        c.gridx = 1;
        c.gridy = 7;
        c.anchor = GridBagConstraints.LINE_END;
        employeeForm.add(registerButton,c);

        JFrameWindow.add(mainPanel); // Add main panel to JFrame
        JFrameWindow.setVisible(true); // JFrame can be seen



        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        mainPanel.add(searchPanel);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy=0;


        JLabel searchLabel = new JLabel("EmployeeID / Name / Surname");

       c1.gridx = 10;
       c1.gridy = 10;
       c1.anchor = GridBagConstraints.LINE_START;
       c1.insets = new Insets(10,30,5,0);
       c1.ipadx = 10;
       c1.ipady = 10;
        searchPanel.add(searchLabel);

        JTextField searchField = new JTextField(20);
        c1.gridx = 11;
        c1.gridy = 12;
        searchPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);












    }
}

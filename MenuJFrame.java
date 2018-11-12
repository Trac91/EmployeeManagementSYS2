import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuJFrame implements ActionListener {

    JPanel employeeForm;
    JFrame JFrameWindow;
    JMenuBar menuBar;
    JMenu file,employees,mortgages;
    JMenuItem exit, addEmployee, editEmployee, deleteEmployee, applyMortgage,viewMortgages;
    JButton addEmployeeButton;

    public MenuJFrame() {
        JFrameWindow = new JFrame();
        JFrameWindow.setVisible(true);
        JFrameWindow.setTitle("Employee Management System");
        JFrameWindow.setSize(1500, 1000);
        JFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JFrameWindow.setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        JMenu employees = new JMenu("Employees");
        JMenu mortgages = new JMenu("Mortgages");
        JMenuItem exit = new JMenuItem("Exit");
            exit.addActionListener(this);
        JMenuItem addEmployee = new JMenuItem("Add Employee");
            addEmployee.addActionListener(this);
        JMenuItem editEmployee = new JMenuItem("Edit Employee");
            editEmployee.addActionListener(this);
        JMenuItem deleteEmployee = new JMenuItem("Delete Employee");
            deleteEmployee.addActionListener(this);
        JMenuItem applyMortgage = new JMenuItem("Apply");
            applyMortgage.addActionListener(this);
        JMenuItem viewMortgage = new JMenuItem("View Applications");
            viewMortgage.addActionListener(this);

        menuBar.add(file);
        menuBar.add(employees);
        menuBar.add(mortgages);
        file.add(exit);
        employees.add(addEmployee);
        employees.add(editEmployee);
        employees.add(deleteEmployee);
        mortgages.add(applyMortgage);
        mortgages.add(viewMortgage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("Exit")) // program closes when exit is clicked
        {
            System.exit(0);
        }
        else if(e.getActionCommand().equals("Add Employee")) // Add employee form appears
        {
            EmployeeForm();
        }
        else if(e.getActionCommand().equals("Edit Employee"))
        {
            EmployeeForm();
            searchPanel();
            // search bar appears to find employee to edit
            // employee form appears with fields filled with employee details ready to be edited
        }

        else if(e.getActionCommand().equals("Delete Employee"))
        {
            // search bar to find employee to be deleted
            // employee form appears with fields filled with employee details ready to be edited
            // Delete option with confirmation message
        }
        else if(e.getActionCommand().equals("Apply"))
        {
            // Application form appears
            //details will be saved to file
        }

        else if(e.getActionCommand().equals("View Applications"))
        {
            //JTable with Mortgage details appear showing the status of the application
            // Options to cancel application
        }
    }
    public class EmployeeForm
    {
        JFrame JFrameWindow;
            JPanel employeeForm;
            JLabel idLabel, nameLabel,addressLabel,emailLabel,phoneLabel, departmentLabel,jobTitleLabel;
            JTextField idField, nameField, addressField,emailField,phoneField;
            JComboBox divisionField, departmentField;
            JButton clearButton,registerButton;
    }

    public void EmployeeForm()
    {
        JOptionPane.showMessageDialog(null,"Loading Employee panel");
        // EmployeeForm JPanel
        JPanel employeeForm = new JPanel(new GridBagLayout()); // Employee details panel
        employeeForm.setSize(500,600);
        employeeForm.setBackground(Color.lightGray);
        employeeForm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,1,true),"Employee Details"));

        // Set constraints to Position components in JPanel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; // Referenced from Mr Java Help Youtube
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10,20,5,20);

        //JLabels for Employee Form
        JLabel idLabel = new JLabel("Employee ID");
        employeeForm.add(idLabel,c);
        c.gridy++; // Increments and moves to row below

        JLabel nameLabel = new JLabel("Name");
        employeeForm.add(nameLabel,c);
        c.gridy++;

        JLabel addressLabel = new JLabel("Address");
        employeeForm.add(addressLabel,c);
        c.gridy++;

        JLabel emailLabel = new JLabel("Email");
        employeeForm.add(emailLabel,c);
        c.gridy++;

        JLabel phoneLabel = new JLabel("Phone No.");
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

        // Creates fields/combobox for employee form

        JTextField idField = new JTextField(5);
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

        JTextField phoneField = new JTextField(15);
        employeeForm.add(phoneField,c);
        c.gridy++;

        // Create array for departments
        String [] departments = {"Accounts", "Mortgages", "Front Desk", "Marketing"};
        // Create combo box
        JComboBox departmentField = new JComboBox(departments);
        employeeForm.add(departmentField,c);
        c.gridy++;

        // Create arrays for Job Titles
        String [] jobTitles = {"Branch Manager","Accounts Manager", "Mortgage Manager", "General Manager", "Marketing Manager", "Admin", "Mortgage Consultants", "Bank Teller","Marketing Consultants"};

        JComboBox divisionField = new JComboBox(jobTitles);
        employeeForm.add(divisionField,c);
        c.gridy++;

        // Create Clear/ Register button for employee form
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

        Container pane = JFrameWindow.getContentPane();
        pane.add(employeeForm);
    }

    public class searchPanel
    {
        JFrame JFrameWindow;
        JPanel searchPanel;
        JTextField searchField;
        JButton searchButton;
    }

    public void searchPanel()
    {
        JOptionPane.showMessageDialog(null,"Loading search panels");
        JPanel searchPanel = new JPanel(new GridBagLayout());

        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,1,true),"Search Employee ID / Name"));
        searchPanel.setSize(100,200);


        searchPanel.setBackground(Color.cyan);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx =0;
        c1.gridy=0;

        JLabel searchLabel= new JLabel("Search Employee eg. Name, ID , Department");
        c1.gridx = 12;
        c1.gridy = 11;

        JTextField searchField = new JTextField(20);
        c1.gridx = 14;
        c1.gridy = 12;

        JButton searchButton = new JButton("Search");
        c1.gridx = 16;
        c1.gridy = 13;
        // c.insets = new Insets(0,20,0,20);
        searchPanel.add(searchField,c1); // add search field on search panel
         searchPanel.add(searchLabel,c1);
        searchPanel.add(searchButton,c1); // add search button to search panel
        searchPanel.setVisible(true);

        Container pane = JFrameWindow.getContentPane();
        pane.add(searchPanel);



    }

}













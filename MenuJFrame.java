import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MenuJFrame implements ActionListener {

    JPanel employeeForm;
    JFrame JFrameWindow;
    JMenuBar menuBar;
    JMenu file, employees, mortgages;
    JMenuItem exit, addEmployee, editEmployee, deleteEmployee, applyMortgage, viewMortgages;
    JButton addEmployeeButton;
    GridBagConstraints c = new GridBagConstraints();

    public MenuJFrame() {
        JFrameWindow = new JFrame();

        JFrameWindow.setTitle("Employee Management System");
        JFrameWindow.setSize(1000, 800);
        JFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrameWindow.setVisible(true);
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
        JFrameWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Exit")) // program closes when exit is clicked
        {
            System.exit(0);
        } else if (e.getActionCommand().equals("Add Employee")) // Add employee form appears
        {
            EmployeeForm();
            JFrameWindow.repaint();
        } else if (e.getActionCommand().equals("Edit Employee")) {

            //EmployeeForm();
            searchPanel();
            JFrameWindow.repaint();
            // search bar appears to find employee to edit
            // employee form appears with fields filled with employee details ready to be edited
        } else if (e.getActionCommand().equals("Delete Employee")) {
            JFrameWindow.revalidate();
            searchPanel();

            // search bar to find employee to be deleted
            // employee form appears with fields filled with employee details ready to be edited
            // Delete option with confirmation message
        } else if (e.getActionCommand().equals("Apply")) {
            JFrameWindow.revalidate();
            // employeeForm.setVisible(false);
            // JFrameWindow.repaint();
            mortgageForm();
            // Application form appears
            //details will be saved to file
        } else if (e.getActionCommand().equals("View Applications")) {
            //JTable with Mortgage details appear showing the status of the application
            // Options to cancel application
        }
    }

    public class EmployeeForm {
        JFrame JFrameWindow;
        JPanel employeeForm;
        JLabel idLabel, nameLabel, addressLabel, emailLabel, phoneLabel, departmentLabel, jobTitleLabel;
        JTextField idField, nameField, addressField, emailField, phoneField;
        JComboBox divisionField, departmentField;
        JButton clearButton, registerButton;
    }

    public void EmployeeForm() {

        // EmployeeForm JPanel
        JPanel employeeForm = new JPanel();// Employee details panel
        employeeForm.setLayout(new GridBagLayout());
        employeeForm.setLocation(150, 150);
        employeeForm.setPreferredSize(new Dimension(200, 300));
        employeeForm.setBackground(Color.lightGray);
        employeeForm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true), "Employee Details"));

        //   JFrameWindow.pack();
        // Set constraints to Position components in JPanel

        c.gridx = 0; // Referenced from Mr Java Help Youtube
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10, 20, 5, 20);

        //JLabels for Employee Form
        JLabel idLabel = new JLabel("Employee ID");
        JLabel nameLabel = new JLabel("Name");
        JLabel addressLabel = new JLabel("Address");
        JLabel emailLabel = new JLabel("Email");
        JLabel phoneLabel = new JLabel("Phone No.");
        JLabel departmentLabel = new JLabel("Department");
        JLabel jobTitleLabel = new JLabel("Title");
        //add Jlabels
        employeeForm.add(idLabel, c);
        c.gridy++; // Increments and moves to row below
        employeeForm.add(nameLabel, c);
        c.gridy++;
        employeeForm.add(addressLabel, c);
        c.gridy++;
        employeeForm.add(emailLabel, c);
        c.gridy++;
        employeeForm.add(phoneLabel, c);
        c.gridy++;
        employeeForm.add(departmentLabel, c);
        c.gridy++;
        employeeForm.add(jobTitleLabel, c);
        c.gridy++;

        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;

        String[] departments = {"Accounts", "Mortgages", "Front Desk", "Marketing"};
        String[] jobTitles = {"Branch Manager", "Accounts Manager", "Mortgage Manager", "General Manager", "Marketing Manager", "Admin", "Mortgage Consultants", "Bank Teller", "Marketing Consultants"};

        // Creates fields/combobox for employee form
        JTextField idField = new JTextField(5);
        JTextField nameField = new JTextField(20);
        JTextArea addressField = new JTextArea(5, 20);
        JTextField emailField = new JTextField(20);
        JTextField phoneField = new JTextField(15);
        JComboBox departmentField = new JComboBox(departments);
        JComboBox divisionField = new JComboBox(jobTitles);

        //add fields/combo box
        employeeForm.add(idField, c);
        c.gridy++;
        employeeForm.add(nameField, c);
        c.gridy++;
        employeeForm.add(addressField, c);
        c.gridy++;
        employeeForm.add(emailField, c);
        c.gridy++;
        employeeForm.add(phoneField, c);
        c.gridy++;
        employeeForm.add(departmentField, c);
        c.gridy++;
        employeeForm.add(divisionField, c);
        c.gridy++;

        // Create Clear/ Register button for employee form
        JButton clearButton = new JButton("Clear");
        JButton registerButton = new JButton("Register Employee");

        c.gridx = 0;
        c.gridy = 7;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(20, 20, 20, 20);
        employeeForm.add(clearButton, c);
        c.gridx = 1;
        c.gridy = 7;
        c.anchor = GridBagConstraints.LINE_END;
        employeeForm.add(registerButton, c);

        Container pane = JFrameWindow.getContentPane();
        pane.add(employeeForm);
        JFrameWindow.setVisible(true);
    }

    public class searchPanel {
        JFrame JFrameWindow;
        JPanel searchPanel;
        JTextField searchField;
        JButton searchButton;
    }

    public void searchPanel() {
        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true), "Search Employee ID / Name"));
        searchPanel.setSize(100, 200);
        // searchPanel.setBounds(12,12,100,100);
        searchPanel.setVisible(true);
        //GridBagConstraints c1 = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        searchPanel.setBackground(Color.cyan);
        c.gridx = 0;
        c.gridy = 0;

        //JLabel searchLabel= new JLabel("Search Employee eg. Name, ID , Department");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // c.insets = new Insets(0,20,0,20);
        searchPanel.add(searchField, c);
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridwidth = 2;

        /*// add search field on search panel
        searchPanel.add(searchLabel,c);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START; */

        searchPanel.add(searchButton, c);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;

        // add search button to search panel
        //searchPanel.setVisible(true);
        Container pane = JFrameWindow.getContentPane();
        pane.add(searchPanel, BorderLayout.PAGE_START);
        JFrameWindow.setVisible(true);
    }

    public class mortgageForm {
        JPanel mortgageForm;

        JComboBox numApplicantsBox, statusBox, firstTimeBox, numChildrenBox;

        JLabel numApplicants, fName, sName, status, dob, numChildren, firstTimeBuyer,
                income, additionalIncome, childcare, maintenance, price, loanRequired;

        JTextField fNameField, sNameField, dobField, incomeField, additionalIncomeField,
                childcareField, maintenanceField, priceField, loanRequiredField;
    }

    public void mortgageForm()

    {
        JPanel mortgagePanel = new JPanel(new GridBagLayout());
        mortgagePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true), "Mortgage Application"));
        mortgagePanel.setSize(100, 200);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(10, 20, 10, 20);

        // create labels
        JLabel numApplicants = new JLabel("No. of applicants");
        JLabel status = new JLabel("Marital status");
        JLabel fName = new JLabel("Forename");
        JLabel sName = new JLabel("Surname");
        JLabel dob = new JLabel("Date of birth");
        JLabel numChildren = new JLabel("No. of dependant children");
        JLabel firstTimeBuyer = new JLabel("First time buyer");
        JLabel income = new JLabel("Basic income");
        JLabel additionalIncome = new JLabel("Additional Income");
        JLabel childcare = new JLabel("Childcare costs");
        JLabel maintenance = new JLabel("Maintenance costs");
        JLabel price = new JLabel("Purchase Price");
        JLabel loanRequired = new JLabel("Mortgage loan required");

        //create fields
        String[] numApp = {"1", "2"};
        JComboBox numApplicantsCombo = new JComboBox(numApp);
        String[] statusArray = {"Single", "Married", "Divorced/Separated", "Widowed", "Cohabitant"};
        JComboBox statusCombo = new JComboBox(statusArray);
        JTextField fNameField = new JTextField(20);
        JTextField sNameField = new JTextField(20);
        // date picker here

        String[] numChildrenArray = {"None", "1", "2", "3", "4", "5", "6", "7", "8", "9+"};
        JComboBox numChildrenCombo = new JComboBox(numChildrenArray);
        String[] options = {"Yes", "No"};
        JComboBox firstTimeBuyerCombo = new JComboBox(options);
        JTextField incomeField = new JTextField(20);
        JTextField additionalIncomeField = new JTextField(20);
        JTextField childcareField = new JTextField(20);
        JTextField maintenanceField = new JTextField(20);
        JTextField priceField = new JTextField(20);
        JTextField loanRequiredField = new JTextField(20);

        //add labels
        mortgagePanel.add(numApplicants, c);
        c.gridy++;
        mortgagePanel.add(fName, c);
        c.gridy++;
        mortgagePanel.add(sName, c);
        c.gridy++;
        mortgagePanel.add(status, c);
        c.gridy++;
        mortgagePanel.add(dob, c);
        c.gridy++;
        mortgagePanel.add(numChildren, c);
        c.gridy++;
        mortgagePanel.add(firstTimeBuyer, c);
        c.gridy++;
        mortgagePanel.add(income, c);
        c.gridy++;
        mortgagePanel.add(additionalIncome, c);
        c.gridy++;
        mortgagePanel.add(childcare, c);
        c.gridy++;
        mortgagePanel.add(maintenance, c);
        c.gridy++;
        mortgagePanel.add(price, c);
        c.gridy++;
        mortgagePanel.add(loanRequired, c);
        c.gridy++;

        //addfields
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        mortgagePanel.add(numApplicantsCombo, c);
        c.gridy++;
        mortgagePanel.add(fNameField, c);
        c.gridy++;
        mortgagePanel.add(sNameField, c);
        c.gridy++;
        mortgagePanel.add(statusCombo, c);
        c.gridy++;
        mortgagePanel.add(dob, c);
        c.gridy++;
        mortgagePanel.add(numChildrenCombo, c);
        c.gridy++;
        mortgagePanel.add(firstTimeBuyerCombo, c);
        c.gridy++;
        mortgagePanel.add(incomeField, c);
        c.gridy++;
        mortgagePanel.add(additionalIncomeField, c);
        c.gridy++;
        mortgagePanel.add(childcareField, c);
        c.gridy++;
        mortgagePanel.add(maintenanceField, c);
        c.gridy++;
        mortgagePanel.add(priceField, c);
        c.gridy++;
        mortgagePanel.add(loanRequiredField, c);
        c.gridy++;

        Container pane = JFrameWindow.getContentPane();
        pane.add(mortgagePanel);
        mortgagePanel.setVisible(true);
        JFrameWindow.setVisible(true);
    }

    public class createEmployeeTable extends JFrame{
        JTable table;

        public void createEmployeeTable()
        {
             setLayout(new FlowLayout());

             String[] columns = {"Employee ID", "Forename", "Surname", "Address", "Email", "Phone", "Department","Division"};

             Object[] [] data = {
                     {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR","Accounts"},
             };
             table = new JTable(data,columns);
             table .setPreferredScrollableViewportSize(new Dimension(500,50));
             table.setFillsViewportHeight(true);

             JScrollPane scrollPane = new JScrollPane(table);
             table.add(scrollPane);
            JFrameWindow.setVisible(true);

        }
    }

}


//https://stackoverflow.com/questions/8770617/java-items-appear-only-after-the-window-is-resize







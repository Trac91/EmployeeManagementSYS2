import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.TableColumn; //added by JB to manipulate width of table columns

public class MenuJFrame implements ActionListener {

    private String email, forename, surname, address, phoneNo, empID, department, division;
    private JMenuItem applyMortgage;
    private GridBagConstraints c; //JB removed instantiation of constraints object here - instead do it within EmployeeForm() constructor
    private EmployeeForm empForm;
    private SearchPanel searchPanel;
    private UserLogin userLogin;
    private Handler handler = new Handler();
    private JPanel employeeForm;
    private JLabel idLabel, addressLabel, emailLabel, phoneLabel, departmentLabel, jobTitleLabel;
    private JTextField employeeID, surnameField, forenameField, emailField, phoneField, addressField;
    private JButton clearButton, registerButton;
    private ArrayList<Employee> allEmployees = new ArrayList<>(); //array list to hold all the Employee objects in the system
    //private ArrayList<Mortgage> mortgages = new ArrayList<>();
    private JFrame myFrame;
    private JPanel mortgageForm;
    private JPanel Userlogin;
    private JPanel mortgagePanel;
    private JComboBox<String> divisionField;
    private JComboBox<String> departmentField;

    // Employee employee = new Employee(empID,surname,forename,address,email,phoneNo,department,division);

    /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public MenuJFrame() throws IOException, ClassNotFoundException {
        //  Employee employee = new Employee(new Person(String empID,String department,String division));

        // InputOutput.OpenEmployees(); **** Must Code I/O Exceptions

        myFrame = new JFrame();
        myFrame.setTitle("Employee Management System");
        myFrame.setSize(1000, 800);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        // Menu Bar
        // I Want the login in panel to display when the application opens
        userLogin = new UserLogin();
        userLogin.userLogin();

        JMenuBar menuBar = new JMenuBar();
        myFrame.setJMenuBar(menuBar);
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

        // add menu components
        menuBar.add(file);
        menuBar.add(employees);
        menuBar.add(mortgages);
        file.add(exit);
        employees.add(addEmployee);
        employees.add(editEmployee);
        employees.add(deleteEmployee);
        mortgages.add(applyMortgage);
        mortgages.add(viewMortgage);

        myFrame.setVisible(true);
    } // End MenuJframe

    /**
     * Create employee form and positions then
     */
    public class EmployeeForm {

        JPanel employeeForm;

        public EmployeeForm() {

            c = new GridBagConstraints(); //JB Added this crucial code here to prevent rendering issues on GUI
            //the constraints instance needs to be reset for each subsequent layout
            employeeForm = new JPanel();// Employee details panel
            employeeForm.setLayout(new GridBagLayout());
            employeeForm.setLocation(150, 150);
            employeeForm.setPreferredSize(new Dimension(200, 300));
            employeeForm.setBackground(Color.lightGray);
            employeeForm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true), "Employee Details"));

            // Set constraints to Position components in JPanel
            c.gridx = 0; // Referenced from Mr Java Help Youtube
            c.gridy = 0;
            c.anchor = GridBagConstraints.LINE_START;
            c.insets = new Insets(10, 20, 5, 20);

            //JLabels for Employee Form
            idLabel = new JLabel("Employee ID");
            JLabel forenameLabel = new JLabel("Forename");
            JLabel surnameLabel = new JLabel("Surname");
            addressLabel = new JLabel("Address");
            emailLabel = new JLabel("Email");
            phoneLabel = new JLabel("Phone No.");
            departmentLabel = new JLabel("Department");
            jobTitleLabel = new JLabel("Title");

            //add Jlabels
            employeeForm.add(idLabel, c);
            c.gridy++; // Increments and moves to row below
            employeeForm.add(forenameLabel, c);
            c.gridy++;
            employeeForm.add(surnameLabel, c);
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
            employeeID = new JTextField(5);
            forenameField = new JTextField(20);
            surnameField = new JTextField(20);
            addressField = new JTextField(20);
            emailField = new JTextField(20);
            phoneField = new JTextField(15);
            departmentField = new JComboBox<>(departments);
            divisionField = new JComboBox<>(jobTitles);

            //add fields/combo box
            employeeForm.add(employeeID, c);
            employeeID.addActionListener(handler);
            c.gridy++;
            employeeForm.add(forenameField, c);
            forenameField.addActionListener(handler);
            c.gridy++;
            employeeForm.add(surnameField, c);
            surnameField.addActionListener(handler);
            c.gridy++;
            employeeForm.add(addressField, c);
            addressField.addActionListener(handler);
            c.gridy++;
            employeeForm.add(emailField, c);
            emailField.addActionListener(handler);
            c.gridy++;
            employeeForm.add(phoneField, c);
            phoneField.addActionListener(handler);
            c.gridy++;
            employeeForm.add(departmentField, c);
            departmentField.addActionListener(handler);
            c.gridy++;
            employeeForm.add(divisionField, c);
            divisionField.addActionListener(handler);
            c.gridy++;

            // Create Clear/ Register button for employee form
            clearButton = new JButton("Clear");
            clearButton.addActionListener(handler);
            registerButton = new JButton("Register Employee");
            registerButton.addActionListener(handler);
            c.gridx = 0;
            c.gridy = 10;
            c.anchor = GridBagConstraints.LINE_END;
            c.insets = new Insets(20, 20, 20, 20);
            employeeForm.add(clearButton, c);
            c.gridx = 1;
            c.gridy = 10;
            c.anchor = GridBagConstraints.LINE_END;
            employeeForm.add(registerButton, c);

            Container pane = myFrame.getContentPane();
            pane.add(employeeForm);

        } // end constructor
    }// end addemployee form

    /**
     * @param
     *
     * * is pressed the system closes
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Exit")) // program closes when exit is clicked
        {
            System.exit(0);
        }
        /*JB Added/Modified code here to ensure the Add/Edit Employees and Mortgage forms rendered successfully*/

        /**
         * If add employee is selected Employee form appears,
         */
        else if (e.getActionCommand().equals("Add Employee")) // Add employee form appears
        {
            if (empForm != null) {

                myFrame.remove(empForm.employeeForm);
            }
            if (searchPanel != null) {
                myFrame.remove(searchPanel.getSearchPanel());
            }

            if (mortgagePanel != null) {
                myFrame.remove(mortgagePanel);

            }
            empForm = new EmployeeForm();

            //JB Advice - user can now interact with the GUI and enter details of a new Employee on the text-fields/combos
            //Then, when the user hits the "Register Employee" button, the details entered onto the text-fields/combos are
            //retrieved and a new Employee object created from their data
            //This Employee object would then be added to the array list of all Employee objects (I've put this array list
            //at the top of this file, along with other globals), which could subsequently be saved to a file on disk when
            //the application is closing

            myFrame.revalidate();

            /**
             * When Edit employee is clicked, the search bar appears on top to let the user search for a specific employee/department
             */
        } else if (e.getActionCommand().equals("Edit Employee")) {

            if (empForm != null) {
                System.out.println(myFrame);
                System.out.println(empForm.employeeForm);
                myFrame.remove(empForm.employeeForm);
            }

            if (searchPanel != null) {
                myFrame.remove(searchPanel.getSearchPanel());
            }

            if (mortgagePanel != null) {
                myFrame.remove(mortgagePanel);
                //JFrameWindow.revalidate();
            }

            searchPanel = new SearchPanel();
            myFrame.add(searchPanel.getSearchPanel(), BorderLayout.PAGE_START);

            //Container pane = myFrame.getContentPane();
            //pane.add(searchPanel, BorderLayout.PAGE_START);

            empForm = new EmployeeForm(); //code modified by JB
            myFrame.revalidate();

            // search bar appears to find employee to edit
            // employee form appears with fields filled with employee details ready to be edited
        } else if (e.getActionCommand().equals("Delete Employee")) {

            if (empForm != null) {
                System.out.println(myFrame);
                System.out.println(empForm.employeeForm);
                myFrame.remove(empForm.employeeForm);
            }

            if (searchPanel != null) {
                myFrame.remove(searchPanel.getSearchPanel());
            }


            if (mortgagePanel != null) {
                myFrame.remove(mortgagePanel);
            }

            searchPanel = new SearchPanel();
            myFrame.add(searchPanel.getSearchPanel(), BorderLayout.PAGE_START);
            empForm = new EmployeeForm(); //code modified by JB
            myFrame.revalidate();
            // search bar to find employee to be deleted
            // employee form appears with fields filled with employee details ready to be edited


            // Delete option with confirmation message
            /**
             * If user clicks apply, input dialogs take in information from the user regarding there income details for the mortgage calculator
             */
        } else if (e.getActionCommand().equals("Apply")) {

            if (empForm != null) {
                System.out.println(myFrame);
                System.out.println(empForm.employeeForm);
                myFrame.remove(empForm.employeeForm);
            }

            if (searchPanel != null) {

                myFrame.remove(searchPanel.getSearchPanel());
            }

            int loanAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter Loan Amount"));
            double deposit = Double.parseDouble(JOptionPane.showInputDialog("Deposit"));
            int years = Integer.parseInt(JOptionPane.showInputDialog("Enter term in year"));
            int annualInterestRate = Integer.parseInt(JOptionPane.showInputDialog("Enter annual interest rate"));
            double valueOfHome = Double.parseDouble(JOptionPane.showInputDialog("Enter Value of home"));
            double annualIncome = Double.parseDouble(JOptionPane.showInputDialog("Annual Income"));

            mortgageCalculator(loanAmount, years, valueOfHome, annualIncome, deposit);

            calculateMonthlyPayment(loanAmount, years, annualInterestRate);


            // Application form appears
            //details will be saved to file
        } else if (e.getActionCommand().equals("View Applications")) {
            addMortgageForm();
            //JTable with Mortgage details appear showing the status of the application
            // Options to cancel application
        } else if ((e.getActionCommand().equals("Search"))) //code added by JB here just for this option
        {
            System.out.println("Search on Employees happens now!!");
            // String[] columns = {"Employee ID", "Forename", "Surname", "Address", "Email", "Phone", "Department", "Division"};
            //JFrame empTable; //code added by JB to demo creation of JTable of employees
            //  empTable = addEmployeeTable(employee, columns);

        } else if (e.getActionCommand().equals("Apply Mortgage")) {
            myFrame.add(mortgageForm);
            myFrame.revalidate();


            //  CalculateMortgage.(loanAmount, years, annualInterestRate,valueOfHome,annualIncome);

        }

        /*JB - modified existing code to create an EmployeeForm class to ensure that the panel employeeForm
         *would be globally accessible within the event-handling methods so that existing forms could be
         *removed*/
    }

    /**
     * Create employee form
     */
    private void addMortgageForm() {

        // Must do!
    }

    public class Handler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            empID = employeeID.getText();
            forename = forenameField.getText();
            surname = surnameField.getText();
            address = addressField.getText();
            email = emailField.getText();
            phoneNo = phoneField.getText();
            int intPhone = Integer.parseInt(phoneNo);
            department = (String) departmentField.getSelectedItem();
            division = (String) divisionField.getSelectedItem();

            if (event.getSource() == registerButton) {

                //empForm = new EmployeeForm();
                //for (int i = 0; i < allEmployees.size(); i++) {
                Employee employee = new Employee(forename, surname, address, email, intPhone, empID, department, division);

                empID = employeeID.getText();
                forename = forenameField.getText();
                surname = surnameField.getText();
                address = addressField.getText();
                email = emailField.getText();
                intPhone = Integer.parseInt(phoneNo);
                phoneNo = phoneField.getText();
                department = (String) departmentField.getSelectedItem();
                division = (String) divisionField.getSelectedItem();

                allEmployees.add(employee);

                for (Employee e : allEmployees) {
                    System.out.println(e);
                }

                JOptionPane.showMessageDialog(null, "Employee added");

                new EmployeeTable();
                displayEmployees(allEmployees);

            }

            if (event.getSource() == clearButton) {

                employeeID.setText("");
                forenameField.setText("");
                surnameField.setText("");
                addressField.setText("");
                emailField.setText("");
                phoneField.setText("");
            }

            // End if registered button

            else if (event.getSource() == applyMortgage) {



                //mortgageForm = new JPanel();

            }
             /*   forename = fNameField.getText();
                surname = sNameField.getText();
                String status = (String) statusBox.getSelectedItem();
                dob = dobField.getText();
                String numChildren = (String) numChildrenBox.getSelectedItem();
                int numChildrenInt = Integer.parseInt(numChildren);
                String firstTimeBuyer = (String) firstTimeBox.getSelectedItem();
                income = incomeField.getText();
                int incomeInt = Integer.parseInt(incomeField.getText());
                additionalIncome = additionalIncomeField.getText();
                int additionInt = Integer.parseInt(additionalIncomeField.getText());
                price = priceField.getText();
                int priceInt = Integer.parseInt(priceField.getText());
                loanRequired = loanRequiredField.getText();
                int loanInt = Integer.parseInt(loanRequiredField.getText());

            }
            myFrame.add(mortgageForm);
*/
            // Calculate the monthly repayments


        }

    } // End Handler

    //Mortgage m = new Mortgage(forename,surname,status,dob,numChildren,firstTimeBuyer,income,additionalIncome,price,loanRequired);

    // Mortgage.add(m);

    // JOptionPane.showMessageDialog(null, "Mortgage Inquiry Added");


    /**
     * Create JTable with Values from ArrayList
     */
    public class EmployeeTable extends JFrame {
        JTable table;


        //ArrayList<Employee> allEmployees = new ArrayList<>();
        public EmployeeTable() {

            String[] columns = {"Employee ID", "Forename", "Surname", "Address", "Email", "Phone", "Department", "Division"};

            //displayEmployees(allEmployees);

            Object[][] employees = {
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"}
            };

            table = new JTable(employees, columns);

            //The code below added by JB, adapted from https://stackoverflow.com/questions/5775602/jtable-set-column-size-problem
            //Alters the column width of table columns so they render reasonably first time

            TableColumn column = null;

            for (int i = 0; i < columns.length; i++) {
                column = table.getColumnModel().getColumn(i);

                column.setPreferredWidth(100);
            }

            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);

            setLocation(500, 300);
            setSize(column.getPreferredWidth() * columns.length, 200);

            setVisible(true);

        } // End constructor

    } // End employee table

    /**
     * Create Mortgage table
     */
    public class MortgageTable extends JFrame {
        JTable MTable;

        public MortgageTable() {

            String[] columns = {"No. of Applicants", "Forename", "Surname", "Status", "Dob", "No. Children", "First Time Buyer", "Additional Income", "Childcare fees", "Maintance", "Price", "Loan Required"};

            //ArrayList<Mortgage> mortgages = new ArrayList<>();

            TableColumn column = null;

            for (int i = 0; i < columns.length; i++) {
                column = MTable.getColumnModel().getColumn(i);

                column.setPreferredWidth(100);
            }

            JScrollPane scrollPane = new JScrollPane(MTable);
            add(scrollPane, BorderLayout.CENTER);

            setLocation(500, 300);
            setSize(column.getPreferredWidth() * columns.length, 200);

            setVisible(true);


        } // End Mortgage table constructor

        /**
         * Constuctor for mortgage form
         */
        public void MortgageForm() {
            mortgagePanel = new JPanel(new GridBagLayout());
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
            JComboBox<String> numApplicantsCombo = new JComboBox<>(numApp);
            String[] statusArray = {"Single", "Married", "Divorced/Separated", "Widowed", "Cohabitant"};
            JComboBox<String> statusCombo = new JComboBox<>(statusArray);
            JTextField fNameField = new JTextField(20);
            JTextField sNameField = new JTextField(20);
            // date picker here

            String[] numChildrenArray = {"None", "1", "2", "3", "4", "5", "6", "7", "8", "9+"};
            JComboBox<String> numChildrenCombo = new JComboBox<>(numChildrenArray);
            String[] options = {"Yes", "No"};
            JComboBox<String> firstTimeBuyerCombo = new JComboBox<>(options);
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
            numApplicantsCombo.getSelectedItem();
            c.gridy++;
            mortgagePanel.add(fNameField, c);
            fNameField.addActionListener(e -> setName(fNameField.getText()));
            c.gridy++;
            mortgagePanel.add(sNameField, c);
            sNameField.addActionListener(handler);
            c.gridy++;
            mortgagePanel.add(statusCombo, c);
            statusCombo.getSelectedItem();
            c.gridy++;
            mortgagePanel.add(dob, c);

            c.gridy++;
            mortgagePanel.add(numChildrenCombo, c);
            numChildrenCombo.getSelectedItem();

            c.gridy++;
            mortgagePanel.add(firstTimeBuyerCombo, c);
            firstTimeBuyerCombo.getSelectedItem();
            c.gridy++;
            mortgagePanel.add(incomeField, c);
            incomeField.addActionListener(handler);
            c.gridy++;
            mortgagePanel.add(additionalIncomeField, c);
            additionalIncomeField.addActionListener(handler);
            c.gridy++;
            mortgagePanel.add(childcareField, c);
            childcareField.addActionListener(handler);
            c.gridy++;
            mortgagePanel.add(maintenanceField, c);
            maintenanceField.addActionListener(handler);
            c.gridy++;
            mortgagePanel.add(maintenanceField, c);
            maintenanceField.addActionListener(handler);
            c.gridy++;
            mortgagePanel.add(maintenanceField, c);
            maintenanceField.addActionListener(handler);
            c.gridy++;

            Container pane = myFrame.getContentPane();
            pane.add(mortgagePanel);
            mortgagePanel.setVisible(true);
            myFrame.setVisible(true);


        } // End Mortgage Form

    } // End mortgage Table

    /**
     *
     * @param allEmployees are displayed and added to array list
     */
    public void displayEmployees(ArrayList<Employee> allEmployees) {
        String employeeDetails = "";
        for (Employee employee : allEmployees) {
            System.out.println("Emp ID" + employee.getEmployeeID() + "Dep" + employee.getDepartment() + employee.getDivision() + employee.getEmployee());
        }
        JOptionPane.showMessageDialog(null, employeeDetails);
    }

    /**
     *
     * @param loanAmount
     * @param years
     * @param annualInterestRate
     *method calculates the monthly repayments
     */
    void calculateMonthlyPayment(int loanAmount, int years, double annualInterestRate) {

        double monthlyInterestRate = annualInterestRate / 12.0;

        int months = years * 12;

        double monthlyPayment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -months));

        JOptionPane.showMessageDialog(null, monthlyPayment);
    }

    /**
     *
     * @param loanAmount
     * @param years
     * @param valueOfHome
     * @param annualIncome
     * @param deposit
     * method that calculates mortgage approval
     */
    void mortgageCalculator(int loanAmount, int years, double valueOfHome, double annualIncome, double deposit) {

       final double percentage = 0.10;



        if(deposit < (valueOfHome / 100) * percentage)
        {
            if(loanAmount > valueOfHome)
            {
                if(loanAmount > (annualIncome*3.5))
                {
                    JOptionPane.showMessageDialog(null, "Application Denied");

                } else JOptionPane.showMessageDialog(null,"The loan amount has exceeded the value of the house");

            }else loanAmount = Integer.parseInt(JOptionPane.showInputDialog(" Loan amount must not be greater tha the value of the property"));

        }else
            deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Deposit Must at least 10% of the House value"));
    }
}

// End MortgageTable//


    /*
    private void displayMortgages(){
        for(int i =0; i < mortgages.size(); i++)
        {
            JTable table1 = new JTable();
            table1.setModel(new DefaultTableModel(
                    new Object[][] {mortgages.get(i).
                    }
            ));
        }
*/












//https://stackoverflow.com/questions/8770617/java-items-appear-only-after-the-window-is-resize





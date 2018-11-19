import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Handler;
import javax.swing.table.TableColumn; //added by JB to manipulate width of table columns



public class MenuJFrame implements ActionListener {

    JTextField forenameField;
    JTextField surnameField;
    String email;
    String forename;
    String surname ;
    JTextArea output = new JTextArea();
    //JPanel employeeForm;
    JFrame JFrameWindow;
    JMenuBar menuBar;
    JMenu file, employees, mortgages;
    JMenuItem exit, addEmployee, editEmployee, deleteEmployee, applyMortgage, viewMortgages;
    JButton addEmployeeButton;
    GridBagConstraints c; //JB removed instantiation of constraints object here - instead do it within EmployeeForm() constructor
    EmployeeForm empForm;
    JPanel searchPanel;
    String address = "";
    ArrayList<Employee> employee = new ArrayList<Employee>();
    Handler handler = new Handler();

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
        }
        /*JB Added/Modified code here to ensure the Add/Edit Employees forms rendered successfully*/

        else if (e.getActionCommand().equals("Add Employee")) // Add employee form appears
        {
            if (empForm != null) {
                //System.out.println(JFrameWindow);
                //System.out.println(empForm.employeeForm);
                JFrameWindow.remove(empForm.employeeForm);

                //JFrameWindow.revalidate();
            }
            if (searchPanel != null) {
                JFrameWindow.remove(searchPanel);
                //JFrameWindow.revalidate();
            }
            empForm = new EmployeeForm();
            //JFrameWindow.repaint();
            JFrameWindow.revalidate();

        } else if (e.getActionCommand().equals("Edit Employee")) {

            //EmployeeForm();
            if (empForm != null) {
                System.out.println(JFrameWindow);
                System.out.println(empForm.employeeForm);
                JFrameWindow.remove(empForm.employeeForm);
                //JFrameWindow.revalidate();
            }

            if (searchPanel != null) {
                JFrameWindow.remove(searchPanel);
                //JFrameWindow.revalidate();
            }
            empForm = new EmployeeForm(); //code modified by JB
            JFrameWindow.revalidate();

            // search bar appears to find employee to edit
            // employee form appears with fields filled with employee details ready to be edited
        } else if (e.getActionCommand().equals("Delete Employee")) {
            JFrameWindow.revalidate();
            JFrameWindow.add(searchPanel);

            // search bar to find employee to be deleted
            // employee form appears with fields filled with employee details ready to be edited
            // Delete option with confirmation message
        } else if (e.getActionCommand().equals("Apply")) {
            JFrameWindow.revalidate();
            // employeeForm.setVisible(false);
            // JFrameWindow.repaint();
            JFrameWindow.addMortgageForm();
            // Application form appears
            //details will be saved to file
        } else if (e.getActionCommand().equals("View Applications")) {
            //JTable with Mortgage details appear showing the status of the application
            // Options to cancel application
        } else if ((e.getActionCommand().equals("Search"))) //code added by JB here just for this option
        {
            System.out.println("Search on Employees happens now!!");
            JFrame empTable = new EmployeeForm.EmployeeTable(); //code added by JB to demo creation of JTable of employees
        }
    }

    /*JB - modified existing code to create an EmployeeForm class to ensure that the panel employeeForm
     *would be globally accessible within the event-handling methods so that existing forms could be
     *removed*/

    public class EmployeeForm {
        //JFrame JFrameWindow;
        JPanel employeeForm;
        JLabel idLabel, nameLabel, addressLabel, emailLabel, phoneLabel, departmentLabel, jobTitleLabel;
        JTextField employeeID, surnameField, forenameField, emailField, phoneField;
        JTextArea addressField;
        JComboBox divisionField, departmentField;
        JButton clearButton, registerButton;
        String forename, surname, empID, phoneNo;
        SearchPanel searchPanel;
        Employee employee;

        public EmployeeForm() {

            // EmployeeForm JPanel

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
            nameLabel = new JLabel("Name");
            addressLabel = new JLabel("Address");
            emailLabel = new JLabel("Email");
            phoneLabel = new JLabel("Phone No.");
            departmentLabel = new JLabel("Department");
            jobTitleLabel = new JLabel("Title");
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
            employeeID = new JTextField(5);
            forenameField = new JTextField(20);

            surnameField = new JTextField(20);
            addressField = new JTextArea(5, 20);
            emailField = new JTextField(20);

            phoneField = new JTextField(15);
            departmentField = new JComboBox(departments);
            divisionField = new JComboBox(jobTitles);


            //add fields/combo box
            employeeForm.add(employeeID, c);
            employeeID.addActionListener((ActionListener) handler);
            c.gridy++;

            employeeForm.add(forenameField, c);
            forenameField.addActionListener((ActionListener) handler);
            c.gridy++;
            employeeForm.add(surnameField, c);
            surnameField.addActionListener((ActionListener) handler);
            c.gridy++;
            employeeForm.add(addressField, c);
            addressField.addActionListener((ActionListener) handler);
            c.gridy++;
            employeeForm.add(emailField, c);
            emailField.addActionListener((ActionListener) handler);
            c.gridy++;
            employeeForm.add(phoneField, c);
            phoneField.addActionListener((ActionListener) handler);
            c.gridy++;
            employeeForm.add(departmentField, c);
            departmentField.addActionListener((ActionListener) handler);
            c.gridy++;
            employeeForm.add(divisionField, c);
            divisionField.addActionListener((ActionListener) handler);
            c.gridy++;

            // Create Clear/ Register button for employee form
            clearButton = new JButton("Clear");
            clearButton.addActionListener((ActionListener) handler);
            registerButton = new JButton("Register Employee");

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

        private class handler implements  ActionListener {

            public void actionPerformed(ActionEvent event) {


                empID = employeeID.getText();
                forename = forenameField.getText();
                surname = surnameField.getText();
                address = addressField.getText();
                email = emailField.getText();
                phoneNo = phoneField.getText();

                Employee employee = new Employee(new Person, forename,surname,address,email,phoneNo,empID);

                while(event.getSource() == registerButton)
                {
                    Employee.add(employee);
                    empID = employeeID.getText();
                    forename = forenameField.getText();
                    surname = surnameField.getText();
                    address = addressField.getText();
                    email = emailField.getText();
                    phoneNo = phoneField.getText();

                    Employee.add(employee);

                    employeeID.setText("");
                    forenameField.setText("");
                    surnameField.setText("");
                    addressField.setText("");
                    emailField.setText("");
                    phoneField.setText("");

                    JOptionPane.showMessageDialog(null, "Employee added");


                 }

        }

       /* public class handler implements ActionListener {
            public void actionPerformed(ActionEvent event) {

                String employee = "";

                if (event.getSource() == employeeID)
                    employee = String.format("Employee ID: ", event.getActionCommand());
                else if (event.getSource() == forenameField)
                    employee = String.format("Forename:", event.getActionCommand());
                else if (event.getSource() == surnameField)
                    employee = String.format("Surname:", event.getActionCommand());
                else if (event.getSource() == addressField)
                    employee = String.format("Address:", event.getActionCommand());
                else if (event.getSource() == emailField)
                    employee = String.format("Forename:", event.getActionCommand());
                else if (event.getSource() == phoneField)
                    employee = String.format("Phone No:", event.getActionCommand());
                else if (event.getSource() == departmentField)
                    if (event.getSource().equals("Branch Manager"))
                        employee = String.format("Department:", event.getActionCommand());
                    else (event.getSource() == divisionField)
                employee = String.format("Division:", event.getActionCommand());

                JOptionPane.showMessageDialog(null, employee);

            }
*/
        }

        /*JB Advice - Tracey you could create a class called SearchPanel here just as I did above for the EmployeeForm class if you wish
         *Then searchPanel() could  become the constructor for the class and you would create an instance of SearchPanel when
         *you want to create the panel for your GUI*/


        public class mortgageForm {
            JPanel mortgageForm;
            JComboBox numApplicantsBox, statusBox, firstTimeBox, numChildrenBox;
            JLabel numApplicants, fName, sName, status, dob, numChildren, firstTimeBuyer,
                    income, additionalIncome, childcare, maintenance, price, loanRequired;
            JTextField fNameField, sNameField, dobField, incomeField, additionalIncomeField,
                    childcareField, maintenanceField, priceField, loanRequiredField;


            public void mortgageForm() {
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

            public class EmployeeTable extends JFrame {
                JTable table;

                public EmployeeTable() {

                    String[] columns = {"Employee ID", "Forename", "Surname", "Address", "Email", "Phone", "Department", "Division"};

                    /*JB Advice - the values below are perfect for testing purposes but, in reality, at this point the table will
                     *be populated with data of the Employee objects that matched your search criteria when the "Search" button
                     *was pressed, which are obtained by traversing through the ArrayList of Employee objects*/


                    ArrayList<Employee> employees = new ArrayList<>();
                    /*Object[][] data = {
                            {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                            {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                            {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                            {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                            {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                            {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"}
                    };
                    */

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

                }

            }
        }


    }

}







//https://stackoverflow.com/questions/8770617/java-items-appear-only-after-the-window-is-resize







import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn; //added by JB to manipulate width of table columns


public class MenuJFrame implements ActionListener {

    String email;

    JMenu file, employees;
    JMenuItem exit, addEmployee, editEmployee, deleteEmployee, applyMortgage, viewMortgages;
    JButton addEmployeeButton;
    GridBagConstraints c; //JB removed instantiation of constraints object here - instead do it within EmployeeForm() constructor
    EmployeeForm empForm;
    JPanel searchPanel;
    String address = "";
    Handler handler = new Handler();
    int phoneNoInt;


    JPanel employeeForm;
    JLabel idLabel, nameLabel, addressLabel, emailLabel, phoneLabel, departmentLabel, jobTitleLabel;
    JTextField employeeID, surnameField, forenameField, emailField, phoneField, addressField;
    JComboBox divisionField, departmentField;
    JButton clearButton, registerButton,clearButton2,submitButton;
    String forename, surname, empID, phoneNo, numApp, dob, income, additionalIncome, childcare,maintenance,price, loanRequired;
   // SearchPanel searchPanel;
    //Employee employee;
    JFrame myFrame;

    JPanel mortgageForm;
    JComboBox numApplicantsBox, statusBox, firstTimeBox, numChildrenBox;
    JLabel numApplicants;

    JTextField fNameField, sNameField, dobField, incomeField, additionalIncomeField,
            childcareField, maintenanceField, priceField, loanRequiredField;
    ArrayList<Mortgage> mortgages= new ArrayList<>();

    public MenuJFrame() {
        myFrame = new JFrame();
        myFrame.setTitle("Employee Management System");
        myFrame.setSize(1000, 800);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        // Menu Bar
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

        addEmployeeForm();
        myFrame.setVisible(true);
    } // End MenuJframe

    public void addEmployeeForm() {

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
        addressField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(15);
        departmentField = new JComboBox(departments);
        divisionField = new JComboBox(jobTitles);


        //add fields/combo box
        employeeForm.add(employeeID, c);
        employeeID.addActionListener((ActionListener) handler);c.gridy++;
        employeeForm.add(forenameField, c);
        forenameField.addActionListener((ActionListener) handler);c.gridy++;
        employeeForm.add(surnameField, c);
        surnameField.addActionListener((ActionListener) handler);c.gridy++;
        employeeForm.add(addressField, c);
        addressField.addActionListener((ActionListener) handler);c.gridy++;
        employeeForm.add(emailField, c);
        emailField.addActionListener((ActionListener) handler);c.gridy++;
        employeeForm.add(phoneField, c);
        phoneField.addActionListener((ActionListener) handler);c.gridy++;
        employeeForm.add(departmentField, c);
        departmentField.addActionListener((ActionListener) handler);c.gridy++;
        employeeForm.add(divisionField, c);
        divisionField.addActionListener((ActionListener) handler);c.gridy++;

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

        Container pane = myFrame.getContentPane();
        pane.add(employeeForm);

        // JFrameWindow.setVisible(true);

    } // end addemployee form


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
                myFrame.remove(empForm.employeeForm);

                //JFrameWindow.revalidate();
            }
            if (searchPanel != null) {
                myFrame.remove(searchPanel);
                //JFrameWindow.revalidate();
            }
            empForm = new EmployeeForm();
            //JFrameWindow.repaint();
            addEmployeeForm();
            myFrame.revalidate();

        }   else if (e.getActionCommand().equals("Edit Employee")) {

            //EmployeeForm();
            if (empForm != null) {
                System.out.println(myFrame);
                System.out.println(empForm.employeeForm);
                myFrame.remove(empForm.employeeForm);
                //JFrameWindow.revalidate();
            }

            if (searchPanel != null) {
                myFrame.remove(searchPanel);
                //JFrameWindow.revalidate();
            }
            empForm = new EmployeeForm(); //code modified by JB
            myFrame.revalidate();

            // search bar appears to find employee to edit
            // employee form appears with fields filled with employee details ready to be edited
        } else if (e.getActionCommand().equals("Delete Employee")) {
            myFrame.revalidate();
            myFrame.add(searchPanel);

            // search bar to find employee to be deleted
            // employee form appears with fields filled with employee details ready to be edited
            // Delete option with confirmation message
        } else if (e.getActionCommand().equals("Apply")) {
            myFrame.revalidate();
            // employeeForm.setVisible(false);
            // JFrameWindow.repaint();
            myFrame.addMortgageForm();
            // Application form appears
            //details will be saved to file
        } else if (e.getActionCommand().equals("View Applications")) {
            //JTable with Mortgage details appear showing the status of the application
            // Options to cancel application
        } else if ((e.getActionCommand().equals("Search"))) //code added by JB here just for this option
        {
            System.out.println("Search on Employees happens now!!");
            JFrame empTable = new EmployeeTable(); //code added by JB to demo creation of JTable of employees

        }
        else if (e.getActionCommand().equals("Apply Mortgage"))
        {
            myFrame.add(mortgageForm);
        }

      /*JB - modified existing code to create an EmployeeForm class to ensure that the panel employeeForm
         *would be globally accessible within the event-handling methods so that existing forms could be
         *removed*/
    }

    public class Handler implements ActionListener {

        public void actionPerformed(ActionEvent event) {


            empID = employeeID.getText();
            forename = forenameField.getText();
            surname = surnameField.getText();
            address = addressField.getText();
            email = emailField.getText();
            phoneNo = phoneField.getText();
            int phoneNoInt = Integer.parseInt(phoneField.getText());

            Employee employee = new Employee(new Person(forename, surname, address, email, phoneNoInt), empID);

            if (event.getSource() == registerButton) {
                Employee.addEmployee(employee);
                empID = employeeID.getText();
                forename = forenameField.getText();
                surname = surnameField.getText();
                address = addressField.getText();
                email = emailField.getText();
                phoneNo = phoneField.getText();

                Employee.addEmployee(employee);

                employeeID.setText("");
                forenameField.setText("");
                surnameField.setText("");
                addressField.setText("");
                emailField.setText("");
                phoneField.setText("");

                JOptionPane.showMessageDialog(null, "Employee added");


            } // End if registered button

            if(event.getSource() == submitButton)
            {
               // numApp=numApplicants.getText();
                forename = fNameField.getText();
                surname = sNameField.getText();
                String status = (String)statusBox.getSelectedItem();
                dob = dobField.getText();
                String numChildren = (String)numChildrenBox.getSelectedItem();
                int numChildrenInt = Integer.parseInt(numChildren);
                String firstTimeBuyer = (String)firstTimeBox.getSelectedItem();
                income =incomeField.getText();
                int incomeInt = Integer.parseInt(incomeField.getText());
                additionalIncome = additionalIncomeField.getText();
                int additionInt = Integer.parseInt(additionalIncomeField.getText());
                price = priceField.getText();
                int priceInt = Integer.parseInt(priceField.getText());
                loanRequired=loanRequiredField.getText();
                int loanInt = Integer.parseInt(loanRequiredField.getText());

                Mortgage m = new Mortgage(forename,surname,status,dob,numChildren,firstTimeBuyer,income,additionalIncome,price,loanRequired);

                Mortgage.add(m);

                JOptionPane.showMessageDialog(null, "Mortgage Inquiry Added");



            }

            if(event.getActionCommand().equals("View Application")){
                displayMortgages();
            }



        } // End action Event
    } // End handler

    /*JB Advice - Tracey you could create a class called SearchPanel here just as I did above for the EmployeeForm class if you wish
     *Then searchPanel() could  become the constructor for the class and you would create an instance of SearchPanel when
     *you want to create the panel for your GUI*/


    public class EmployeeTable extends JFrame {
        JTable table;

        public EmployeeTable() {

            String[] columns = {"Employee ID", "Forename", "Surname", "Address", "Email", "Phone", "Department", "Division"};

            /*JB Advice - the values below are perfect for testing purposes but, in reality, at this point the table will
             *be populated with data of the Employee objects that matched your search criteria when the "Search" button
             *was pressed, which are obtained by traversing through the ArrayList of Employee objects*/


             ArrayList<Employee> employees = new ArrayList<>();
            Object[][] data = {
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"},
                    {"1", "Tracey", "Brosnan", " Killarney", "TB@yahoo.co.uk ", "0891232345", "HR", "Accounts"}
            };

            table = new JTable(data, columns);

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

    public void MortgageForm()
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
        JLabel status = new JLabel("Marital status");
        JLabel fName = new JLabel("Forename");
        JLabel sName = new JLabel("Surname");
        JLabel dob = new JLabel("Date of birth");
        JLabel numChildren = new JLabel("No. of dependant children");
        JLabel firstTimeBuyer = new JLabel("First time buyer");
        JLabel income = new JLabel("Basic income");
        JLabel additionalIncome = new JLabel("Additional Income");
        JLabel price = new JLabel("Purchase Price");
        JLabel loanRequired = new JLabel("Mortgage loan required");

        //create fields

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
        JTextField priceField = new JTextField(20);
        JTextField loanRequiredField = new JTextField(20);

        //add labels
        mortgagePanel.add(numApplicants, c);c.gridy++;
        mortgagePanel.add(fName, c);c.gridy++;
        mortgagePanel.add(sName, c);c.gridy++;
        mortgagePanel.add(status, c);c.gridy++;
        mortgagePanel.add(dob, c);c.gridy++;
        mortgagePanel.add(numChildren, c);c.gridy++;
        mortgagePanel.add(firstTimeBuyer, c);c.gridy++;
        mortgagePanel.add(income, c);c.gridy++;
        mortgagePanel.add(additionalIncome, c);c.gridy++;
        mortgagePanel.add(price, c);c.gridy++;
        mortgagePanel.add(loanRequired, c);c.gridy++;

        //addfields
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        mortgagePanel.add(fNameField, c);c.gridy++;
        mortgagePanel.add(sNameField, c);c.gridy++;
        mortgagePanel.add(statusCombo, c);c.gridy++;
        mortgagePanel.add(dob, c);c.gridy++;
        mortgagePanel.add(numChildrenCombo, c);c.gridy++;
        mortgagePanel.add(firstTimeBuyerCombo, c);c.gridy++;
        mortgagePanel.add(incomeField, c);c.gridy++;
        mortgagePanel.add(additionalIncomeField, c);c.gridy++;
        mortgagePanel.add(childcareField, c);c.gridy++;
        mortgagePanel.add(maintenanceField, c);c.gridy++;
        mortgagePanel.add(priceField, c);c.gridy++;
        mortgagePanel.add(loanRequiredField, c);c.gridy++;

        JButton clearButton2 = new JButton("Clear");
        clearButton.addActionListener( handler);
        JButton submitButton = new JButton("Register Employee");
        submitButton.addActionListener(handler);

        c.gridx = 0;
        c.gridy = 7;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(20, 20, 20, 20);
        mortgageForm.add(clearButton2, c);
        c.gridx = 1;
        c.gridy = 7;
        c.anchor = GridBagConstraints.LINE_END;
        mortgageForm.add(submitButton, c);
        Container pane = myFrame.getContentPane();
        pane.add(mortgagePanel);
        mortgagePanel.setVisible(true);
        myFrame.setVisible(true);


    } // End Mortgage Form


    public class MortgageTable extends JFrame{
        JTable MTable;

        public MortgageTable()
        {

            String [] columns = {"No. of Applicants", "Forename", "Surname","Status", "Dob", "No. Children", "First Time Buyer", "Additional Income", "Childcare fees","Maintance","Price","Loan Required"};

            ArrayList<Mortgage> mortgages = new ArrayList<>();

            TableColumn column = null;

            for(int i = 0; i < columns.length; i++)
            {
                column = MTable.getColumnModel().getColumn(i);

                column.setPreferredWidth(100);
            }

            JScrollPane scrollPane = new JScrollPane(MTable);
            add(scrollPane,BorderLayout.CENTER);

            setLocation(500,300);
            setSize(column.getPreferredWidth()*columns.length,200);

            setVisible(true);



        } // End Mortgage table constructor


    } // End MortgageTable

    private void displayMortgages(){
        for(int i =0; i < mortgages.size(); i++)
        {
            JTable table1 = new JTable();
            table1.setModel(new DefaultTableModel(
                    new Object[][] {mortgages.get(i).
                    }
            ));
        }




    }


}// End Menu Jframe










//https://stackoverflow.com/questions/8770617/java-items-appear-only-after-the-window-is-resize







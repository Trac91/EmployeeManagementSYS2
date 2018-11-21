import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class BankApplication{

    static ArrayList<Employee> employee = new ArrayList<>();

    public static void main(String arg[])
    {

        MenuJFrame guiApp = new MenuJFrame();
        BranchManager[] branchManager = new BranchManager[1];
        ArrayList<Accounts> account = new ArrayList<>();

        addEmployee();
        //Employee employee;
        for(int i =0;i<employee.size();i++);
        {
            addEmployeeForm(employee);

        }
        System.out.print((employee.toArray()));

        //addEmployeeForm(employee);
        displayEmployeeTable(employee);

        addMortgageForm();

        addMortgage();

        displayMortgageTable();

        calcMortgage();
    }



    // method to add the employee form
    private static void addEmployeeForm(ArrayList<Employee> employee) {
        // Do i put handling code in here if add button is clicked???
        addEmployeeForm(employee);
        Employee.addEmployee(employee);
    }

    // Method to add an employee to employee Array list
    private static void  addEmployee(){

    }

    // Method to display employee array list to JTable
    private static void displayEmployeeTable(ArrayList<Employee> employee)
    {

    }
    // Method to display the mortgage application form
    private static void addMortgageForm() {
        // Do i put handling code in here ie if Apply mortgage is pressed show form?

    }
    // Method to add mortgage application to mortgage arraylist
    private static void  addMortgage()
    {

    }
    // Method to display mortgage array list on a JTable
    private static void displayMortgageTable() {
    }

    // Method to calculate elegibilty and breakdown of repayments
    private static void calcMortgage(){
        // Take in financial details from the user and plug them into formula
        /* -- Get Interest Rate per year
           -- Calculate the monthly interest rate
                    monthlyInterest = annualinterest/12
           -- Get amount of years
           -- calculate monthly repayment
                   monthlypayment = loanamount * monthly interestrate(1-1/math.pow(1 + monthlyInterestRate,
                   numberOf years * 12);
           -- Total Payment = MonthlyPayment * numberOfyears * 12

        */


    }


}

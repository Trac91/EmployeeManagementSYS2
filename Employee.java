import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person implements Serializable {

    private String employeeID;
    private Person employee;
    private  String department;
    private String division;

    // No Argument Constructor
    //Employee() {
      //  this( "Unknown","Unknown","Unknown");

    //}

    public Employee(String forename, String surname, String address, String email ,int phoneNo, String employeeID, String department,String division) {

        super(forename,surname,address,email,phoneNo);

        setEmployeeID(employeeID);
        setDepartment(department);
        setDivision(division);
        setEmployee(employee);

    }

    private ArrayList <Employee> allEmployees = getEmployee();



    public void setEmployee(Person employee) {
        this.employee = employee;
    }

    public Person getEmployee() {
        return employee;
    }

    /**
     * @return
     */
    // Getters
    public String getEmployeeID() {
        return employeeID;
    }
    //Setters
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    //toString Method

    /**
     *
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String toString() {

        return "EmployeeID: " + getEmployeeID() + "\nForename: " + getForename() + "\nSurname: " + getSurname() +
                "\nAddress: " + getAddress() + "\nEmail: " + getEmail() + "\nPhone No: " + getPhoneNo() +
                "\nDepartment: " + getDepartment() + "\nDivision: " + getDivision();
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee extends Person {

    private String employeeID;
    private Person employee;
    private  String department;
    private String division;

    // No Argument Constructor
    public Employee() {
        this( "Unknown","Unknown","Unknown");

    }

    public Employee(String employeeID, String department, String division) {

        setEmployeeID(employeeID);
        setDepartment(department);
        setDivision(division);
        setEmployee(employee);
    }

    private List<Employee> allEmployees = new ArrayList<>();


    public static void addEmployee(Employee employee ) {


        // need to code this *************
    }

    public  void get(ArrayList<Employee> e) {
        return;
    }

    public void setEmployee(Person employee) {
        this.employee = employee;
    }

    public Person getEmployee() {
        return employee;
    }

    // Getters
    public String getEmployeeID() {
        return employeeID;
    }
    //Setters
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    //toString Method


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

    return super.toString()  +" " +getEmployee() + " " + getDepartment() + " " + getDivision();
    }


    public List<Employee> getAllEmployees() {
        return allEmployees;
    }
}


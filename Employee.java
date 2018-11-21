import java.util.ArrayList;

public  class Employee extends Person {

    private String employeeID;
    private Person employee;
    private  String department;
    private String division;

    // No Argument Constructor
    public Employee() {
        this(new Person(), "Unknown","Unknown","Unknown");

    }

    public Employee(Person employee, String employeeID, String department, String division) {

        super();
        this.employeeID = employeeID;
        this.department = department;
        this.division = division;

    }

    public static void addEmployee() {

        // need to code this *************
    }

    public void setEmployee(Person employee) {
        this.employee = employee;
    }

    public Person getEmployee() {
        return employee;
    }

    public  void addEmployee(Employee employee) {
    this.employee = employee;
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
        return super.toString() + "Employee ID: " + getEmployeeID() + "\nDepartment: " + getDepartment() + "\nDivision: " + getDivision();
    }


}


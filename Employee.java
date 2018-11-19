public abstract class Employee extends Person {

    private String employeeID;
    private Person employee;


    // No Argument Constructor
    public Employee()
    {
      this(new Person(),"Unknown");

    }
    public Employee(Person employee, String employeeID){
        this.employeeID = employeeID;
        this.employee=employee;
    }

    public static void add(Employee employee) {
        // need to code this *************
    }


    // Getters
    public  String getEmployeeID() {
        return employeeID;

    }
    //Setters
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }


    //toString Method
    public String toString()
    {
        return employee.toString() + "Employee ID: " + employeeID;
    }
}



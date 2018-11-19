public class BranchManager extends Employee {
   //private String TYPE = "Branch";
    private String department;
    Person person;
    Employee employee;


    public BranchManager(String department)
    {
        this.department=department;

    }

    public BranchManager() {
        this(null,null ,null );
    }

    public BranchManager(Person employee, String employeeID, String department) {

        super(employee, employeeID);
        this.department=department;

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return "Department: " + department + super.toString() ;

    }
}



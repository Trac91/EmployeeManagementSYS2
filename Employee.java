public class Employee {

    private String employeeID;
    private String name;
    private String address;
    private int phoneNo;
    private String email;


    // No Argument Constructor
    public Employee()
    {
      this("Unknown", "Unknown", "Unknown", 0, "Unknown");

    }
    // 5 Argument Constructor //
    public Employee(String employeeID, String name, String address, int phoneNo, String email){
        this.employeeID = employeeID;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    // Getters
    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }
    //Setters
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString Method
    public String toString()
    {
        return "Employee ID: " + getEmployeeID()+ "\nName: " + getName() + "\nAddress: " + getAddress() +
                "\nPhone No: " + getPhoneNo() + "\nEmail: " + getEmail();
    }
}



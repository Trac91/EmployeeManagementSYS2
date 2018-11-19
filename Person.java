import javax.swing.*;

public class Person {
    private String forename;
    private String surname;
    private String address;
    private String email;
    private int phoneNo;


    public Person() {
        this("Unknown", "Unknown", "Unknown", "Unknown", Integer.parseInt(null));
    }

    public Person(String forename, String surname, String address, String email, int phoneNo) {


        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = getSurname();
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = getForename();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addressField) {
        this.address = getAddress();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailField) {
        this.email = email;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "\n Forename: " + getForename() + "\nSurname" + getSurname() + "\nAddress" + getAddress() + "\nEmail " + getEmail() + "\nPhone No " + getPhoneNo();
    }

}





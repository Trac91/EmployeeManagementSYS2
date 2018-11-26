import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;


public class Person extends ArrayList<Employee> implements Serializable {
    private String forename;
    private String surname;
    private String address;
    private String email;
    private int phoneNo;


    public Person() {
       this("Unknown", "Unknown", "Unknown", "Unknown", 0);

    }

    public Person(String forename, String surname, String address, String email, int phoneNo) {

        setSurname(surname);
        setForename(forename);
        setAddress(address);
        setEmail(email);
        setPhoneNo(phoneNo);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
        return  "\nSurname: " + getSurname() +"\n Forename: " + getForename() + "\nAddress: " + getAddress() + "\nEmail: " + getEmail() + "\nPhone No: " + getPhoneNo();
    }

}





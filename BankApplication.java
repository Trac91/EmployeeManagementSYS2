import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class BankApplication  {

    public static void main(String arg[])
    {

        MenuJFrame guiApp = new MenuJFrame();
        ArrayList<Employee> employee = new ArrayList<>();
        BranchManager[] branchManager = new BranchManager[1];
        ArrayList<Accounts> account = new ArrayList<>();
        ArrayList<Mortgage> mortgages= new ArrayList<>();

        //Employee employee;

    }
    /*
    // Save Employees to file
    public static void SaveEmployees(ArrayList<Employee> employees)
    {
        File file = new File("employee.dat");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(employees);
        oos.close();
    }

    // Read in employees from file
    public static void OpenEmployees()
    {
        File file = new File("employee.dat");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Employee> employees = ois.readObject();
        ois.close();
    }
*/
}

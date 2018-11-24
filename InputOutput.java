import java.io.*;
import java.util.ArrayList;

public class InputOutput {

    // Save Employees to file
  public static void SaveEmployees(ArrayList<Employee> employees) throws IOException {
        File file = new File("employee.dat");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(employees);
        oos.close();
    }

    // Read in employees from file
    public static void OpenEmployees() throws IOException, ClassNotFoundException {
        File file = new File("employee.dat");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Employee> employees = (ArrayList<Employee>) ois.readObject();
        ois.close();
    }

}

import javax.swing.*;

public class BankApplication extends Employee  {
    public static void main(String arg[])
    {
        String name, address,email;
        double phoneNum;

        Employee employee = new Employee();

        name = JOptionPane.showInputDialog("Please enter name");

        address =  JOptionPane.showInputDialog("Please enter address");

        phoneNum =  Double.parseDouble(JOptionPane.showInputDialog("Please enter phone no"));

        email =  JOptionPane.showInputDialog("Please enter email address");

        JOptionPane.showMessageDialog(null,employee.toString(),"Employee Details",JOptionPane.INFORMATION_MESSAGE);


    }


}

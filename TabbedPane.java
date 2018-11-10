import javax.swing.*;
import java.awt.*;

public class TabbedPane extends JFrame { // JTabbedPane referenced from https://github.com/BranislavLazic/SwingTutorials

    JPanel filePanel = new JPanel();
    JPanel employPanel = new JPanel();
    JPanel mortgagePanel = new JPanel();

    JLabel fileLabel = new JLabel("File");
    JLabel employLabel = new JLabel("Employee Details");
    JLabel mortgageLabel =  new JLabel("Mortgage Calculator");

    JTabbedPane tabbedPane = new JTabbedPane();

    public TabbedPane()
    {
        filePanel.add(fileLabel);
        employPanel.add(employLabel);
        mortgagePanel.add(mortgageLabel);

        JPanel employeeForm = new JPanel(); // Employee details panel
        employeeForm.setSize(1000,600);
        employeeForm.setBackground(Color.lightGray);
        employeeForm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,1,true),"Register Employee"));

        employPanel.add(employeeForm);

        add(tabbedPane);
        tabbedPane.add("File",filePanel);
        tabbedPane.add("Employee Details",employPanel);
        tabbedPane.add("Mortgage Calculator",mortgagePanel);
 tabbedPane.setVisible(true);

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchPanel implements ActionListener {
    //public class searchPanel { //Code modified by JB here
    JFrame JFrameWindow;
    JPanel searchPanel;
    JTextField searchField;
    JButton searchButton;
    GridBagConstraints c;


    public SearchPanel() {

        c = new GridBagConstraints(); //JB Added this crucial code here to prevent rendering issues on GUI
        //the constraints instance needs to be reset for each subsequent layout

        searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true), "Search Employee ID / Name"));
        searchPanel.setSize(100, 200);
        searchPanel.setVisible(true);
        c.anchor = GridBagConstraints.LINE_START;
        searchPanel.setBackground(Color.cyan);
        c.gridx = 0;
        c.gridy = 0;

        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this); //code added by JB

        // c.insets = new Insets(0,20,0,20);
        searchPanel.add(searchField, c);
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridwidth = 2;

        searchPanel.add(searchButton, c);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;
        // add search button to search panel
        //Container pane = JFrameWindow.getContentPane();
        //pane.add(searchPanel, BorderLayout.PAGE_START);
        //JFrameWindow.add(searchPanel);
        //JFrameWindow.setVisible(true);
    }

    //Code added by JB to ensure search panel available to relevant GUI options such as edit and delete employee
    public JPanel getSearchPanel()
    {
        return searchPanel;
    }


    public void actionPerformed(ActionEvent e)
    {
        //What happens when search button gets pressed on this panel
        System.out.println("The search button was pressed!");

        //JB Advice
        //You'd display the Employee objects that matched the search value in a JTable at this point
        //So if you just entered Smith, it might populate the table with all Employee objects whose
        //surname contains "Smith"

        //You could then maybe select the particular employee you want from the JTable and their details
        //get added automatically to the GUI text-fields/combos for deletion/amending



    }
}
//}
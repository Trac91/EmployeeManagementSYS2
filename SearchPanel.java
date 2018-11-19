import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchPanel {
    public class searchPanel {
        JFrame JFrameWindow;
        JPanel searchPanel;
        JTextField searchField;
        JButton searchButton;
        GridBagConstraints c;


        public searchPanel() {

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
            searchButton.addActionListener((ActionListener) this); //code added by JB

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
            Container pane = JFrameWindow.getContentPane();
            pane.add(searchPanel, BorderLayout.PAGE_START);
            JFrameWindow.add(searchPanel);
            JFrameWindow.setVisible(true);
        }
    }
}

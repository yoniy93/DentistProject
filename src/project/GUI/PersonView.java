package project.GUI;

import javax.swing.*;

public class PersonView extends JFrame {

    private JButton editPersonalDetails = new JButton("Edit personal details");

    public PersonView(){
        setLayout(null);
        setLocationAndSize();
        addComponentsToContainer();

        setBounds(500, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {
        editPersonalDetails.setBounds(150, 250, 150, 30);

    }

    private void addComponentsToContainer() {
        add(editPersonalDetails);
    }

    public JButton getEditPersonalDetails() {
        return editPersonalDetails;
    }
}

package project.GUI.Admin;

import javax.swing.*;

public class RegisterPatientView extends RegisterView {

    private JLabel height=new JLabel("Height: ");
    private JLabel weight=new JLabel("Weight :");

    public RegisterPatientView()
    {
        setLayout(null);
        setPatientComponents();
        addPatientComponents();

        setTitle("Register New Patient");
        setBounds(300, 100, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setPatientComponents()
    {


    }

    private void addPatientComponents()
    {
        add(height);
        add(weight);
    }

    public JLabel getHeightButton() {  return height; }

    public JLabel getWeight() { return weight; }



}

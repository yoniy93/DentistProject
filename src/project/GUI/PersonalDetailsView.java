package project.GUI;

import java.awt.Font;
import javax.swing.*;

public class PersonalDetailsView extends JFrame {
    private JButton editButton = new JButton("Edit");
    private JButton cancelButton = new JButton("Cancel");

    private JLabel firstnameLabel = new JLabel("First Name: ");
    private JLabel lastnameLabel = new JLabel( "Last Name: ");
    private JLabel emailLabel = new JLabel( "Email: ");
    private JLabel passwordLabel = new JLabel("Password: ");

    private JTextField lastnameTextField = new JTextField();
    private JTextField firstnameTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JTextField passwordTextField  = new JTextField();

    public PersonalDetailsView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setBounds(300, 100, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {
        editButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        editButton.setBounds(80, 400, 100, 30);

        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelButton.setBounds(220, 400, 100, 30);

        firstnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        firstnameLabel.setBounds(60, 40, 100, 30);

        lastnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lastnameLabel.setBounds(60, 80, 100, 30);

        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        emailLabel.setBounds(60, 120, 100, 30);

        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(60, 160, 100, 30);

        firstnameTextField.setBounds(170, 40, 150, 30);
        lastnameTextField.setBounds(170, 80, 150, 30);
        emailTextField.setBounds(170, 120, 150, 30);
        passwordTextField.setBounds(170, 160, 150, 30);
    }
    private void addComponentsToFrame(){
        add(editButton);
        add(cancelButton);

        add(firstnameLabel);
        add(lastnameLabel);
        add(emailLabel);
        add(passwordLabel);

        add(lastnameTextField);
        add(firstnameTextField);
        add(emailTextField);
        add(passwordTextField);
    }
}

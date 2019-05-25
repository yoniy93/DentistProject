package project.GUI.Doctor;
import javax.swing.*;
import java.util.Vector;

public class PersonalDetailsViewDoctor extends JFrame{
    private JButton editButton = new JButton("Edit");
    private JButton cancelButton = new JButton("Cancel");

    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel firstnameLabel = new JLabel("First Name: ");
    private JLabel lastnameLabel = new JLabel( "Last Name: ");
    private JLabel emailLabel = new JLabel( "Email: ");
    private JLabel yearsOfExpLabel = new JLabel("Years of experience: ");

    private JPasswordField passwordField = new JPasswordField();

    private JTextField lastnameTextField = new JTextField();
    private JTextField firstnameTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JTextField yearsOfExpTextField = new JTextField();


    public PersonalDetailsViewDoctor() {

        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Edit Personal Details ");
        setBounds(300, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {

        editButton.setBounds(50, 500, 100, 30);
        cancelButton.setBounds(170, 500, 100, 30);



        /*

        idLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 150, 100, 30);
        firstnameLabel.setBounds(50, 150, 100, 30);
        lastnameLabel.setBounds(50, 150, 100, 30);
        dateOfBirthLabel.setBounds(50, 150, 100, 30);
        emailLabel.setBounds(50, 150, 100, 30);
        yearsOfExpLabel.setBounds(50, 150, 100, 30);
        genderLabel.setBounds(50, 150, 100, 30);
        heightLabel.setBounds(50, 150, 100, 30);
        weightLabel.setBounds(50, 150, 100, 30);
        idTextField.setBounds(50, 150, 100, 30);
        passwordTextField.setBounds(50, 150, 100, 30);
        lastnameTextField.setBounds(50, 150, 100, 30);
        firstnameTextField.setBounds(50, 150, 100, 30);
        emailTextField.setBounds(50, 150, 100, 30);
        yearsOfExTextField.setBounds(50, 150, 100, 30);
        heightTextField.setBounds(50, 150, 100, 30);
        weightTextField.setBounds(50, 150, 100, 30);
        maleRadioButton.setBounds(50, 150, 100, 30);
        femaleRadioButton.setBounds(50, 150, 100, 30);
        monthComboBox.setBounds(50, 150, 100, 30);
        dayComboBox.setBounds(50, 150, 100, 30);
        yearComboBox.setBounds(50, 150, 100, 30);
        */
    }

    private void addComponentsToFrame(){
        add(editButton);
        add(cancelButton);

        add(passwordLabel);
        add(firstnameLabel);
        add(lastnameLabel);
        add(emailLabel);
        add(yearsOfExpLabel);


        add(passwordField);
        add(lastnameTextField);
        add(firstnameTextField);
        add(emailTextField);
        add(yearsOfExpTextField);

    }

    public JButton getEditButton() {
        return editButton;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getLastnameTextField() {
        return lastnameTextField;
    }

    public JTextField getFirstnameTextField() {
        return firstnameTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JTextField getYearsOfExpTextField() {
        return yearsOfExpTextField;
    }
}
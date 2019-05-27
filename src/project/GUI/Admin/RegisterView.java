package project.GUI.Admin;
import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame
{
    private JLabel role= new JLabel( "What is the user's role? ");
    private JLabel firstnameLabel = new JLabel("First Name: ");
    private JLabel lastnameLabel = new JLabel( "Last Name: ");
    private JLabel emailLabel = new JLabel( "Email: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel gender= new JLabel("Gender: ");

    private JRadioButton doctor= new JRadioButton("Doctor");
    private JRadioButton patient=new JRadioButton("Patient");
    private ButtonGroup roleGroup = new ButtonGroup();
    private JRadioButton male= new JRadioButton("Male");
    private JRadioButton female=new JRadioButton("Female");
    private ButtonGroup genderGroup = new ButtonGroup();
    private JTextField lastnameTextField = new JTextField();
    private JTextField firstnameTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JPasswordField passwordField  = new JPasswordField();


    public RegisterView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Register New User");
        setBounds(300, 100, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize()
    {
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
        passwordField.setBounds(170, 160, 150, 30);
    }

    private void addComponentsToFrame()
    {
        add(role);
        add(firstnameLabel);
        add(lastnameLabel);
        add(emailLabel);
        add(passwordLabel);
        add(gender);
        add(doctor);
        add(patient);
        add(male);
        add(female);
        add(lastnameTextField);
        add(firstnameTextField);
        add(emailTextField);
        add(passwordField);
       // add();

    }


    public ButtonGroup getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(ButtonGroup roleGroup) {
        this.roleGroup = roleGroup;
    }

    public ButtonGroup getGenderGroup() {
        return genderGroup;
    }

    public void setGenderGroup(ButtonGroup genderGroup) {
        this.genderGroup = genderGroup;
    }

    public JTextField getLastnameTextField() {
        return lastnameTextField;
    }

    public void setLastnameTextField(JTextField lastnameTextField) {
        this.lastnameTextField = lastnameTextField;
    }

    public JTextField getFirstnameTextField() {
        return firstnameTextField;
    }

    public void setFirstnameTextField(JTextField firstnameTextField) {
        this.firstnameTextField = firstnameTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }
}

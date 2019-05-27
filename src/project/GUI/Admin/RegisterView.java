package project.GUI.Admin;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class RegisterView extends JFrame
{
    private JLabel role= new JLabel( "What is the user's role? ");
    private JLabel firstNameLabel = new JLabel("First Name: ");
    private JLabel lastNameLabel = new JLabel( "Last Name: ");
    private JLabel emailLabel = new JLabel( "Email: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel gender= new JLabel("Gender: ");
    private JLabel id = new JLabel("Id: " );
    private JLabel dateOfBirth= new JLabel("Date Of Birth: ");

    private Vector year= new Vector<>(100);
    private Vector month= new Vector<>(12);
    private Vector day= new Vector<>(31);

    private JComboBox yearBox = new JComboBox(year);
    private JComboBox monthBox= new JComboBox(month);
    private JComboBox dayBox=new JComboBox(day);

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
    private JTextField idTextFiled= new JTextField();



    public RegisterView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        setDateOfBirth();

        setTitle("Register New User");
        setBounds(300, 100, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setDateOfBirth()
    {
        for(int i=0;i<30; i++)
        {
            day.set(i,i+1);
        }
        for(int i=0;i<12; i++)
        {
            month.set(i,i+1);
        }
        int max=1920;
        for (int i=2019; i<=1920; i--)
        {
            year.set(i,i);
        }
    }

    private void setLocationAndSize()
    {
        firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        firstNameLabel.setBounds(60, 40, 100, 30);

        lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lastNameLabel.setBounds(60, 80, 100, 30);

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
        add(firstNameLabel);
        add(lastNameLabel);
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
        add(id);
        add(idTextFiled);
        add(dateOfBirth);
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

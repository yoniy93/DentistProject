package project.GUI.Admin.Register;
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
    private JLabel height=new JLabel("Height: ");
    private JLabel weight=new JLabel("Weight: ");
    private JLabel yearOfEx=new JLabel("Years Of Experience: ");

    private Vector<Integer> yearVector = new Vector<Integer>();
    private Vector<Integer> monthVector = new Vector<Integer>();
    private Vector<Integer> dayVector = new Vector<Integer>();

    private JComboBox yearBox;
    private JComboBox monthBox;
    private JComboBox dayBox;

    private JRadioButton doctor = new JRadioButton("Doctor");
    private JRadioButton patient =new JRadioButton("Patient");
    private ButtonGroup roleGroup = new ButtonGroup();

    private JRadioButton male= new JRadioButton("Male");
    private JRadioButton female=new JRadioButton("Female");
    private ButtonGroup genderGroup = new ButtonGroup();

    private JTextField lastnameTextField = new JTextField();
    private JTextField firstnameTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JPasswordField passwordField  = new JPasswordField();
    private JTextField idTextFiled= new JTextField();
    private JTextField heightTextField=new JTextField("לא שדה חובה");
    private JTextField weightTextField=new JTextField("לא שדה חובה");
    private JTextField yearsOfExTextField=new JTextField("לא שדה חובה");


    public RegisterView() {

        setDateOfBirth();
        configDateComboBox();
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();


        setTitle("Register New User");
        setBounds(300, 100, 800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setDateOfBirth() {
        for(int i=1; i<=31; i++)
        {
            dayVector.add(i);
        }
        for(int i=1; i<=12; i++)
        {
            monthVector.add(i);
        }
        int maxYear=2019;
        for (int i=0; i<=100; i++)
        {
            yearVector.add(maxYear--);
        }
    }

    private void configDateComboBox(){
        dayBox = new JComboBox(dayVector);
        monthBox = new JComboBox(monthVector);
        yearBox = new JComboBox(yearVector);
    }

    private void setLocationAndSize()
    {
        firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        firstNameLabel.setBounds(60, 40, 100, 30);

        lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lastNameLabel.setBounds(60, 80, 100, 30);

        id.setFont(new Font("Tahoma", Font.BOLD, 14));
        id.setBounds(60,120,100,30);

        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        emailLabel.setBounds(60, 160, 100, 30);

        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(60, 200, 100, 30);

        gender.setBounds(60,240,150,50);
        role.setBounds(60,300,150,50);
        dateOfBirth.setBounds(60,360,150,50);
        weight.setBounds(60,400,150,50);
        height.setBounds(60,440,150,50);
        yearOfEx.setBounds(60,480,150,50);

        firstnameTextField.setBounds(170, 40, 150, 30);
        lastnameTextField.setBounds(170, 80, 150, 30);
        idTextFiled.setBounds(170,120,150,30);
        emailTextField.setBounds(170, 160, 150, 30);
        passwordField.setBounds(170, 200, 150, 30);


        male.setBounds(120,240,150,50);
        male.setVisible(true);
        female.setBounds(200,240,150,50);
        female.setVisible(true);

        patient.setBounds(200,300,150,50);
        doctor.setBounds(280,300,150,50);

        yearBox.setBounds(150,360,150,20);
        monthBox.setBounds(300,360,150,20);
        dayBox.setBounds(450,360,150,20);

        weightTextField.setBounds(170,410,150,25);
        heightTextField.setBounds(170,450,150,25);
        yearsOfExTextField.setBounds(200,490,150,25);
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
        add(yearOfEx);
        add(yearsOfExTextField);
        add(weight);
        add(weightTextField);
        add(height);
        add(heightTextField);
        add(yearBox);
        add(dayBox);
        add(monthBox);

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

    public JComboBox getYearBox() {
        return yearBox;
    }

    public JComboBox getMonthBox() {
        return monthBox;
    }

    public JComboBox getDayBox() {
        return dayBox;
    }

    public JRadioButton getDoctor() {
        return doctor;
    }

    public JRadioButton getPatient() {
        return patient;
    }

    public JRadioButton getMale() {
        return male;
    }

    public JRadioButton getFemale() {
        return female;
    }

    public JTextField getIdTextFiled() {
        return idTextFiled;
    }

    public JTextField getHeightTextField() {
        return heightTextField;
    }

    public JTextField getWeightTextField() {
        return weightTextField;
    }

    public JTextField getYearsOfExTextField() {
        return yearsOfExTextField;
    }
}


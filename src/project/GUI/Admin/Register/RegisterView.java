package project.GUI.Admin.Register;
import project.Database.Locations;
import project.GUI.General.CancleButton;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class RegisterView extends JFrame
{
    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("registerUser.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private CancleButton cancleButton = new CancleButton();
    private JButton addUserButton = new JButton("Submit");
    private JLabel roleLabel = new JLabel( "What is the user's role?");
    private JLabel firstNameLabel = new JLabel("First Name: ");
    private JLabel lastNameLabel = new JLabel( "Last Name: ");
    private JLabel emailLabel = new JLabel( "Email: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel genderLabel= new JLabel("Gender: ");
    private JLabel idLabel = new JLabel("Id: " );
    private JLabel dateOfBirthLabel = new JLabel("Date Of Birth: ");
    private JLabel heightLabel = new JLabel("Height: ");
    private JLabel weightLabel = new JLabel("Weight: ");
    private JLabel yearOfExpLabel = new JLabel("Years Of Experience: ");
    private JLabel yearLabel = new JLabel("Year: ");
    private JLabel monthLabel = new JLabel("Month: ");
    private JLabel dayLabel = new JLabel("Day: ");

    private Vector yearVector = new Vector(100);
    private Vector monthVector = new Vector(12) ;
    private Vector dayVector = new Vector (31);

    private JComboBox yearBox = new JComboBox(yearVector);
    private JComboBox monthBox = new JComboBox(monthVector);
    private JComboBox dayBox = new JComboBox(dayVector);

    private JRadioButton doctorRButton = new JRadioButton("Doctor");
    private JRadioButton patientRButton = new JRadioButton("Patient");
    private ButtonGroup roleGroup = new ButtonGroup();

    private JRadioButton maleRButton = new JRadioButton("Male");
    private JRadioButton femaleRButton = new JRadioButton("Female");
    private ButtonGroup genderGroup = new ButtonGroup();

    private JTextField lastnameTextField = new JTextField();
    private JTextField firstnameTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JPasswordField passwordField  = new JPasswordField();
    private JTextField idTextFiled = new JTextField();
    private JTextField heightTextField = new JTextField();
    private JTextField weightTextField = new JTextField();
    private JTextField yearsOfExTextField = new JTextField();


    public RegisterView() {
        setDateOfBirth();
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        hideDoctorYearsOfExperiensButtoms();

        setTitle("Register New User");
        setBounds(300, 20, 800, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setDateOfBirth() {
        for(int i=0;i<32; i++)
        {
            dayVector.insertElementAt(i+1,i);
        }
        for(int i=0;i<12; i++)
        {
            monthVector.insertElementAt(i+1,i);
        }
        int max=2019;
        for (int i=0; i<=100; i++)
        {
            yearVector.insertElementAt(max--,i);
        }
    }

    public void hidePatientWeightAndHeightButtoms(){
        heightTextField.setEditable(false);
        heightTextField.setBackground(Color.lightGray);
        weightTextField.setEditable(false);
        weightTextField.setBackground(Color.lightGray);
    }

    public void hideDoctorYearsOfExperiensButtoms(){
        yearsOfExTextField.setEditable(false);
        yearsOfExTextField.setBackground(Color.lightGray);

    }


    private void setLocationAndSize()
    {
        firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        firstNameLabel.setBounds(60, 40, 100, 30);

        lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lastNameLabel.setBounds(60, 80, 100, 30);

        idLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        idLabel.setBounds(60,120,100,30);

        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        emailLabel.setBounds(60, 160, 100, 30);

        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(60, 200, 100, 30);

        genderLabel.setBounds(60,240,70,50);
        roleLabel.setBounds(60,300,140,50);
        dateOfBirthLabel.setBounds(60,360,100,50);
        weightLabel.setBounds(60,400,150,50);
        heightLabel.setBounds(60,440,150,50);
        yearOfExpLabel.setBounds(60,480,150,50);

        firstnameTextField.setBounds(170, 40, 150, 30);
        lastnameTextField.setBounds(170, 80, 150, 30);
        idTextFiled.setBounds(170,120,150,30);
        emailTextField.setBounds(170, 160, 150, 30);
        passwordField.setBounds(170, 200, 150, 30);

        maleRButton.setBounds(120,240,60,50);
        femaleRButton.setBounds(190,240,70,50);

        patientRButton.setBounds(210,300,70,50);
        doctorRButton.setBounds(290,300,70,50);

        yearLabel.setBounds(150,380,40,20);
        yearBox.setBounds(200,380,120,20);
        monthLabel.setBounds(330, 380,60,20);
        monthBox.setBounds(400,380,120,20);
        dayLabel.setBounds(530,380,40,20);
        dayBox.setBounds(580,380,120,20);

        weightTextField.setBounds(170,410,150,25);
        heightTextField.setBounds(170,450,150,25);
        yearsOfExTextField.setBounds(200,490,150,25);

        addUserButton.setBounds(200,600,150,30);
        cancleButton.setLocation(400,600,150,30);

        backGround.setBounds(0,0,800,700);

    }



    private void addComponentsToFrame() {


        add(addUserButton);
        add(dayLabel);
        add(yearLabel);
        add(monthLabel);
        add(firstNameLabel);
        add(lastNameLabel);
        add(emailLabel);
        add(passwordLabel);

        add(genderLabel);
        genderGroup.add(maleRButton);
        genderGroup.add(femaleRButton);
        add(maleRButton);
        add(femaleRButton);

        add(roleLabel);
        roleGroup.add(patientRButton);
        roleGroup.add(doctorRButton);
        add(doctorRButton);
        add(patientRButton);
        patientRButton.setSelected(true);

        add(lastnameTextField);
        add(firstnameTextField);
        add(emailTextField);
        add(passwordField);
        add(idLabel);
        add(idTextFiled);
        add(dateOfBirthLabel);
        add(yearOfExpLabel);
        add(yearsOfExTextField);
        add(weightLabel);
        add(weightTextField);
        add(heightLabel);
        add(heightTextField);
        add(yearBox);
        yearBox.setSelectedIndex(0);
        add(dayBox);
        dayBox.setSelectedIndex(0);
        add(monthBox);
        monthBox.setSelectedIndex(0);
        add(cancleButton);

        add(backGround);

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
        return doctorRButton;
    }

    public JRadioButton getPatient() {
        return patientRButton;
    }

    public JRadioButton getMale() {
        return maleRButton;
    }

    public JRadioButton getFemale() {
        return femaleRButton;
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

    public JButton getAddUser() {
        return addUserButton;
    }

    public CancleButton getCancleButton() {
        return cancleButton;
    }

}



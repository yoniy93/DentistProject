package project.GUI.View.Admin;
import project.Database.Locations;
import project.GUI.View.ExitButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class RegisterView extends JFrame
{

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("register.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private ExitButton ExitButton = new ExitButton();
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
    private JLabel phoneNumber=new JLabel("Phone :");

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

    private JTextField lastNameTextField = new JTextField();
    private JTextField firstNameTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JPasswordField passwordField  = new JPasswordField();
    private JTextField idTextFiled = new JTextField();
    private JTextField heightTextField = new JTextField();
    private JTextField weightTextField = new JTextField();
    private JTextField yearsOfExTextField = new JTextField();
    private JTextField phoneNumberTextField=new JTextField();


    public RegisterView() {
        setDateOfBirth();
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        hideDoctorYearsOfExperiensButtons();

        setTitle("Register New User");
        setBounds(500, 100, 800, 700);
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
    }//set values of date vectors

    public void hidePatientWeightAndHeightButtons(){
        heightTextField.setEditable(false);
        heightTextField.setBackground(Color.lightGray);
        weightTextField.setEditable(false);
        weightTextField.setBackground(Color.lightGray);
        heightTextField.setText("");
        weightTextField.setText("");
    }

    public void hideDoctorYearsOfExperiensButtons(){
        yearsOfExTextField.setEditable(false);
        yearsOfExTextField.setBackground(Color.lightGray);
        yearsOfExTextField.setText("");

    }


    private void setLocationAndSize()
    {
        firstNameLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        firstNameLabel.setBounds(60, 40, 100, 30);

        lastNameLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        lastNameLabel.setBounds(60, 80, 100, 30);

        idLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        idLabel.setBounds(60,120,100,30);

        phoneNumber.setFont(new Font("Ariel", Font.BOLD, 14));
        phoneNumber.setBounds(60, 160, 100, 30);

        emailLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        emailLabel.setBounds(60, 200, 100, 30);

        passwordLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        passwordLabel.setBounds(60, 240, 100, 30);

        genderLabel.setBounds(60,300,70,30);
        roleLabel.setBounds(60,340,140,30);
        dateOfBirthLabel.setBounds(60,395,100,50);
        weightLabel.setBounds(60,440,150,50);
        heightLabel.setBounds(60,480,150,50);
        yearOfExpLabel.setBounds(60,540,150,50);


        firstNameTextField.setBounds(170, 40, 150, 30);
        lastNameTextField.setBounds(170, 80, 150, 30);
        idTextFiled.setBounds(170,120,150,30);
        phoneNumberTextField.setBounds(170, 160, 150, 30);
        emailTextField.setBounds(170, 200, 150, 30);
        passwordField.setBounds(170, 240, 150, 30);

        maleRButton.setBounds(120,300,60,30);
        femaleRButton.setBounds(190,300,70,30);

        patientRButton.setBounds(210,340,70,30);
        doctorRButton.setBounds(290,340,70,30);

        yearLabel.setBounds(150,410,40,20);
        yearBox.setBounds(200,410,120,20);
        monthLabel.setBounds(330, 410,60,20);
        monthBox.setBounds(400,410,120,20);
        dayLabel.setBounds(530,410,40,20);
        dayBox.setBounds(580,410,120,20);

        weightTextField.setBounds(170,450,150,25);
        heightTextField.setBounds(170,490,150,25);
        yearsOfExTextField.setBounds(200,550,150,25);

        addUserButton.setBounds(200,600,120,30);
        addUserButton.setFont(new Font("Ariel",Font.BOLD, 12));
        ExitButton.setLocation(400,600,120,30);

        backGround.setBounds(0,0,800,700);

    }



    private void addComponentsToFrame() {

        add(phoneNumber);
        add(phoneNumberTextField);
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

        add(lastNameTextField);
        add(firstNameTextField);
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
        add(ExitButton);

        add(backGround);

    }

    public void setActions(ActionListener addUser, ActionListener SetVisibleTextForDoctor,ActionListener SetVisibleTextForPatient, ActionListener cancel )
    {
        getAddUser().addActionListener(addUser);
        getDoctor().addActionListener(SetVisibleTextForDoctor);
        getPatient().addActionListener(SetVisibleTextForPatient);
        getExitButton().addActionListener(cancel);
    }

    public void setVisibleDoctor()
    {
        yearsOfExTextField.setBackground(Color.WHITE);
        yearsOfExTextField.setEditable(true);
        hidePatientWeightAndHeightButtons();
    }

    public void setVisiblePatient()
    {
        weightTextField.setEditable(true);
        weightTextField.setBackground(Color.WHITE);
        heightTextField.setEditable(true);
        heightTextField.setBackground(Color.WHITE);
        hideDoctorYearsOfExperiensButtons();
    }

    public boolean allFieldsFilled()
    {
        if ( getIdText().equals("") || getPassword().equals("") || getFirstNameText().equals("") ||
                getLastNameText().equals("")|| getEmailText().equals("")|| getDate().equals("") ||
                (!getPatient().isSelected() && !getDoctor().isSelected()) ||
                (!getFemale().isSelected() && !getMale().isSelected()) || getPhoneNumberText().equals("")) {
            return false;
        }
        else {
            if (getDoctor().isSelected())
                return !getYearsOfExText().equals("");
            else
                return !getWeightText().equals("") && !getHeightText().equals("");
        }
    }
    private String getPassword() {
        return new String(passwordField.getPassword());
    }

    private String getDate() {
        int day = (Integer)getDayBox().getSelectedItem();
        int month = (Integer)getMonthBox().getSelectedItem();
        int year =(Integer)getYearBox().getSelectedItem();
        return convertDateToString(day,month,year);
    }

    private String convertDateToString (int day, int month, int year) {
        String dayString=Integer.toString(day);
        String monthString=Integer.toString(month);
        if (day<10)
            dayString="0"+dayString;
        if (month<10)
            monthString="0"+monthString;
        return year+"-"+monthString+"-"+dayString;
    }

    private String convertGenderToString() {
        String genderSelection;
        if (getMale().isSelected())
            genderSelection = "Male";
        else
            genderSelection = "Female";
        return genderSelection;
    }

    public boolean isPatientSelected() {
        if (getPatient().isSelected())
            return true;
        return  false;

    }

    public boolean isDoctorSelected()
    {
        if(getDoctor().isSelected())
            return true;
        return false;

    }

    public String getLastNameText() {
        return lastNameTextField.getText();
    }

    public String getFirstNameText() {
        return firstNameTextField.getText();
    }

    public String getEmailText() {
        return emailTextField.getText();
    }

    public String getPasswordText() {
        return getPassword();
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

    public String getDateOfBirthText()
    {
        return getDate();
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
    public String getGender()
    {
        return convertGenderToString();
    }

    public String getIdText() {
        return idTextFiled.getText();
    }

    public String getHeightText() {
        return heightTextField.getText();
    }

    public String getWeightText() {
        return weightTextField.getText();
    }

    public String getYearsOfExText() {
        return yearsOfExTextField.getText();
    }

    public JButton getAddUser() {
        return addUserButton;
    }

    public ExitButton getExitButton() {
        return ExitButton;
    }

    public String getPhoneNumberText() {
        return phoneNumberTextField.getText();
    }


}



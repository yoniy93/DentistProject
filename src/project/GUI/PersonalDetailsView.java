package project.GUI;
import javax.swing.*;
import java.util.Vector;

public class PersonalDetailsView extends JFrame{
    private JButton editButton = new JButton("Edit");
    private JButton cancelButton = new JButton("Cancel");

    private JLabel idLabel = new JLabel("ID: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel firstnameLabel = new JLabel("First Name: ");
    private JLabel lastnameLabel = new JLabel( "Last Name: ");
    private JLabel dateOfBirthLabel = new JLabel("Date Of Birth: ");
    private JLabel emailLabel = new JLabel( "Email: ");
    private JLabel yearsOfExpLabel = new JLabel("Years of experience: ");
    private JLabel genderLabel = new JLabel("Gender: ");
    private JLabel heightLabel = new JLabel("Height: ");
    private JLabel weightLabel = new JLabel("Weight: ");

    private JTextField idTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JTextField lastnameTextField = new JTextField();
    private JTextField firstnameTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JTextField yearsOfExpTextField = new JTextField();
    private JTextField heightTextField = new JTextField();
    private JTextField weightTextField = new JTextField();

    private JRadioButton maleRadioButton = new JRadioButton("Male");
    private JRadioButton femaleRadioButton = new JRadioButton("Female");
    private ButtonGroup genderButtonGroup = new ButtonGroup();

    private JComboBox monthComboBox = new JComboBox();
    private JComboBox dayComboBox = new JComboBox();
    private JComboBox yearComboBox = new JComboBox();

    private Vector<Integer> yearInfoVector = new Vector();
    private Vector<Integer> monthInfoVector = new Vector();
    private Vector<Integer> dayInfoVector = new Vector();

    public PersonalDetailsView() {

        setLayout(null);

        generateDateInfo();
        configDateComboBox();
        addRadioButtonsToGroup();
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Edit Personal Details ");
        setBounds(300, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void generateDateInfo( ) {
        for (int i=1; i<=31; i++)
        {
            dayInfoVector.add(i);
        }
        for(int i=1; i<=12; i++)
        {
            monthInfoVector.add(i);
        }

        int startYear = 2019;
        for(int i=0; i<100; i++)
        {
            yearInfoVector.add(startYear--);
        }
    }

    private void configDateComboBox(){
        dayComboBox = new JComboBox(dayInfoVector);
        monthComboBox = new JComboBox(monthInfoVector);
        yearComboBox = new JComboBox(yearInfoVector);
    }

    private void addRadioButtonsToGroup(){
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
    }

    private void setLocationAndSize() {
        //  right, down, width, height
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

        add(idLabel);
        add(passwordLabel);
        add(firstnameLabel);
        add(lastnameLabel);
        add(dateOfBirthLabel);
        add(emailLabel);
        add(yearsOfExpLabel);
        add(genderLabel);
        add(heightLabel);
        add(weightLabel);

        add(idTextField);
        add(passwordField);
        add(lastnameTextField);
        add(firstnameTextField);
        add(emailTextField);
        add(yearsOfExpTextField);
        add(heightTextField);
        add(weightTextField);

        add(maleRadioButton);
        add(femaleRadioButton);

        add(monthComboBox);
        add(dayComboBox);
        add(yearComboBox);
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JTextField getIdTextField() {
        return idTextField;
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

    public JTextField getHeightTextField() {
        return heightTextField;
    }

    public JTextField getWeightTextField() {
        return weightTextField;
    }
}
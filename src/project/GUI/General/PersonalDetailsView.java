package project.GUI.General;

import project.Database.Locations;
import project.Entities.Person;
import project.Entities.User;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PersonalDetailsView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("personalDetails.png"));
    private JLabel backGround =new JLabel(imageForBG);

    private JButton editButton = new JButton("Apply");
    private CancelButton cancelButton = new CancelButton();
    private JLabel firstnameLabel = new JLabel("First Name: ");
    private JLabel lastnameLabel = new JLabel( "Last Name: ");
    private JLabel emailLabel = new JLabel( "Email: ");
    private JLabel phoneNumber=new JLabel("Phone: ");
    private JLabel passwordLabel = new JLabel("Password: ");

    private JTextField phoneNumberTextField=new JTextField();
    private JTextField firstnameTextField = new JTextField();
    private JTextField lastnameTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JPasswordField passwordField  = new JPasswordField();

    private Font buttonFont = new Font("Ariel",Font.PLAIN,14);

    public PersonalDetailsView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Edit Personal Details");
        setBounds(300, 100, 400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize(){
        editButton.setFont(new Font("Ariel",Font.BOLD, 12));
        editButton.setBounds(80, 320, 100, 30);

        cancelButton.setLocation(220,320,100,30);

        firstnameLabel.setFont(getButtonFont());
        firstnameLabel.setBounds(60, 40, 100, 30);

        lastnameLabel.setFont(getButtonFont());
        lastnameLabel.setBounds(60, 80, 100, 30);

        emailLabel.setFont(getButtonFont());
        emailLabel.setBounds(60, 120, 100, 30);

        passwordLabel.setFont(getButtonFont());
        passwordLabel.setBounds(60, 160, 100, 30);

        phoneNumber.setBounds(60,200,100,30);
        phoneNumber.setFont(getButtonFont());

        firstnameTextField.setBounds(170, 40, 150, 30);
        lastnameTextField.setBounds(170, 80, 150, 30);
        emailTextField.setBounds(170, 120, 150, 30);
        passwordField.setBounds(170, 160, 150, 30);
        phoneNumberTextField.setBounds(170,200,150,30);

        backGround.setBounds(0,0,400,400);
    }

    private void addComponentsToFrame() {
        add(editButton);
        add(cancelButton);
        add(firstnameLabel);
        add(lastnameLabel);
        add(emailLabel);
        add(passwordLabel);
        add(phoneNumber);
        add(phoneNumberTextField);
        add(lastnameTextField);
        add(firstnameTextField);
        add(emailTextField);
        add(passwordField);
        add(backGround);
    }

    protected JButton getEditButton() {
        return editButton;
    }

    protected CancelButton getCancelButton() {
        return cancelButton;
    }

    public String getFirstNameText() {
        return firstnameTextField.getText();
    }

    public String getLastNameText() {
        return lastnameTextField.getText();
    }

    public String getEmailText() {
        return emailTextField.getText();
    }

    public String getPasswordText() {
        return new String(passwordField.getPassword());
    }

    public String getPhoneNumberText() {
        return phoneNumberTextField.getText();
    }

    private void setFirstNameTextField(String firstname) {
        firstnameTextField.setText(firstname);
    }

    private void setLastNameTextField(String lastnaame) {
        lastnameTextField.setText(lastnaame);
    }

    private void setEmailTextField(String Email) {
        emailTextField.setText(Email);
    }

    private void setPasswordField(String password) {
        passwordField.setText(password);
    }

    private void setPhoneNumberTextField(String phoneNumber) {
        phoneNumberTextField.setText(phoneNumber);
    }

    public void initializePersonFields(User user){
        setFirstNameTextField(user.getFirstName());
        setLastNameTextField(user.getLastName());
        setEmailTextField(user.getEmail());
        setPasswordField(user.getPassword());
        setPhoneNumberTextField(user.getPhoneNumber());
    }

    protected JLabel getBackGround() {
        return backGround;
    }

    protected Font getButtonFont() {
        return buttonFont;
    }

    public void setActions(ActionListener edit, ActionListener cancel){
        getEditButton().addActionListener((edit));
        getCancelButton().addActionListener(cancel);
    }
}

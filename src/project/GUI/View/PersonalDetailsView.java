package project.GUI.View;

import project.Database.Locations;
import project.Entities.User;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

/*view class of edit personal details for user
  user can see his current details and update them
  if all the values entered correctly , the users details are update also in DB
*/
public class PersonalDetailsView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("personalDetails.png"));
    private JLabel backGround =new JLabel(imageForBG);

    private JButton editButton = new JButton("Apply");
    private ExitButton exitButton = new ExitButton();

    private JLabel firstnameLabel = new JLabel("First Name: ");
    private JLabel lastnameLabel = new JLabel( "Last Name: ");
    private JLabel emailLabel = new JLabel( "Email: ");
    private JLabel phoneNumber=new JLabel("Phone: ");
    private JLabel passwordLabel = new JLabel("Password: ");

    private JNumberTextField phoneNumberTextField=new JNumberTextField();
    private JStringTextField firstnameTextField = new JStringTextField();
    private JStringTextField lastnameTextField = new JStringTextField();
    private JTextField emailTextField = new JTextField();
    private JPasswordField passwordField  = new JPasswordField();

    private Font buttonFont = new Font("Ariel",Font.PLAIN,14);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public PersonalDetailsView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Edit Personal Details");
        setBounds(dim.width/2-this.getSize().width/2-200, dim.height/2-this.getSize().height/2-200, 400, 400);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize(){
        editButton.setFont(new Font("Ariel",Font.BOLD, 12));
        editButton.setBounds(80, 320, 100, 30);

        exitButton.setLocation(220,320,100,30);

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
        add(exitButton);
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

    protected ExitButton getExitButton() {
        return exitButton;
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

    private void setLastNameTextField(String lastName) {
        lastnameTextField.setText(lastName);
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


    //set all fields with current details of user
    public void initializeUserFields(User user){
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
        getExitButton().addActionListener(cancel);
    }

    //check if all fields are filled
    public boolean isAllFieldsFilled()
    {
        if(getFirstNameText().equals("")||getLastNameText().equals("")||getEmailText().equals("")||getPhoneNumberText().equals("")||getPasswordText().equals(""))
            return false;
        return true;
    }
}

package project.GUI.General;

import project.Database.Locations;
import java.awt.Font;
import javax.swing.*;

public class PersonalDetailsView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("personalDetails.png"));
    private JLabel backGround =new JLabel(imageForBG);

    private JButton editButton = new JButton("Apply");
    private CancleButton cancelButton = new CancleButton();
    private JLabel firstnameLabel = new JLabel("First Name: ");
    private JLabel lastnameLabel = new JLabel( "Last Name: ");
    private JLabel emailLabel = new JLabel( "Email: ");
    private JLabel passwordLabel = new JLabel("Password: ");

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
        editButton.setFont(buttonFont);
        editButton.setBounds(80, 300, 100, 30);

        cancelButton.setLocation(220,300,100,30);

        firstnameLabel.setFont(buttonFont);
        firstnameLabel.setBounds(60, 40, 100, 30);

        lastnameLabel.setFont(buttonFont);
        lastnameLabel.setBounds(60, 80, 100, 30);

        emailLabel.setFont(buttonFont);
        emailLabel.setBounds(60, 120, 100, 30);

        passwordLabel.setFont(buttonFont);
        passwordLabel.setBounds(60, 160, 100, 30);

        firstnameTextField.setBounds(170, 40, 150, 30);
        lastnameTextField.setBounds(170, 80, 150, 30);
        emailTextField.setBounds(170, 120, 150, 30);
        passwordField.setBounds(170, 160, 150, 30);

        backGround.setBounds(0,0,400,400);
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
        add(passwordField);

        add(backGround);
    }

    public JButton getEditButton() {
        return editButton;
    }

    public CancleButton getCancelButton() {
        return cancelButton;
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

    public JPasswordField getPasswordField() {
        return passwordField;
    }
    public JLabel getBackGround() {
        return backGround;
    }

    public Font getButtonFont() {
        return buttonFont;
    }
}

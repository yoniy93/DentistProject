package project.GUI.Login;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(this.getClass().getResource("pic3.jpg"));
    private JLabel backGround=new JLabel(imageForBG);
    private JLabel userLabel = new JLabel("ID:");
    private JLabel passwordLabel = new JLabel("PASSWORD:");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton clearButton = new JButton("Clear");
    private JCheckBox showPassword = new JCheckBox("Show Password");
    private JLabel goToAdmin=new JLabel("Not register yet? please contact the Admin");

    public LoginView() {
        generateLoginFrame();
    }

    private void generateLoginFrame() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();


        setTitle("Login Form");
        setBounds(500, 100, 370, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(50, 220, 100, 30);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        showPassword.setOpaque(false);
        loginButton.setBounds(50, 300, 100, 30);
        clearButton.setBounds(200, 300, 100, 30);
        goToAdmin.setBounds(60,340,250,30);
        backGround.setBounds(0,0,370,550);
        goToAdmin.setFont(new Font("Tahoma",Font.BOLD,11));

    }

    private void addComponentsToFrame() {
        add(userLabel);
        add(goToAdmin);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        add(showPassword);
        add(loginButton);
        add(clearButton);
        add(backGround);
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JCheckBox getShowPassword() {
        return showPassword;
    }
}
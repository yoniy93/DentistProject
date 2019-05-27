package project.GUI.Login;

import javax.swing.*;

public class LoginView extends JFrame {

    //private JFrame loginFrame = new JFrame();
    private JLabel userLabel = new JLabel("USERNAME:");
    private JLabel passwordLabel = new JLabel("PASSWORD:");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton clearButton = new JButton("Clear");
    private JCheckBox showPassword = new JCheckBox("Show Password");

    public LoginView() {
        generateLoginFrame();
    }

    private void generateLoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();

        setTitle("Login Form");
        setBounds(500, 100, 370, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLayoutManager() {
        setLayout(null);
    }

    private void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        clearButton.setBounds(200, 300, 100, 30);
    }

    private void addComponentsToContainer() {
        add(userLabel);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        add(showPassword);
        add(loginButton);
        add(clearButton);
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
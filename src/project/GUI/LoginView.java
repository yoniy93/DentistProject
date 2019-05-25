package project.GUI;

import javax.swing.*;

public class LoginView {

    private JFrame loginFrame = new JFrame();
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

        loginFrame.setTitle("Login Form");
        loginFrame.setBounds(500, 100, 370, 550);
        loginFrame.setDefaultCloseOperation(loginFrame.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
    }

    private void setLayoutManager() {
        loginFrame.setLayout(null);
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
        loginFrame.add(userLabel);
        loginFrame.add(passwordLabel);
        loginFrame.add(userTextField);
        loginFrame.add(passwordField);
        loginFrame.add(showPassword);
        loginFrame.add(loginButton);
        loginFrame.add(clearButton);
    }

    public JFrame getLoginFrame() {
        return loginFrame;
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



/*
    private void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText =  new String(passwordField.getPassword());

            if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("admin")) {

                AdminFrame adminFrame = new AdminFrame(this);
                this.dispose();
                setVisible(false);
                adminFrame.setResizable(false);
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }
*/

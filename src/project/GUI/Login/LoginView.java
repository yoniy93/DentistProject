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
    private JLabel notLoginMessage =new JLabel("Not register? please contact the admin");
    private JLabel copyrights = new JLabel("© all rights reserved");

    public LoginView() {
        generateLoginFrame();
    }

    private void generateLoginFrame() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        setTitle("Login");
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
        backGround.setBounds(0,0,370,550);
        notLoginMessage.setBounds(70,340,250,30);
        notLoginMessage.setFont(new Font("Tahoma",Font.BOLD,11));
        copyrights.setBounds(140,480,100,30);
        copyrights.setFont(new Font("Tahoma",Font.PLAIN,9));

    }

    private void addComponentsToFrame() {
        add(userLabel);
        add(notLoginMessage);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        add(showPassword);
        add(loginButton);
        add(clearButton);
        add(copyrights);
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

    public ImageIcon getImageForBG() {
        return imageForBG;
    }

    public void setImageForBG(ImageIcon imageForBG) {
        this.imageForBG = imageForBG;
    }

    public JLabel getBackGround() {
        return backGround;
    }

    public void setBackGround(JLabel backGround) {
        this.backGround = backGround;
    }

    public JLabel getNotLoginMessage() {
        return notLoginMessage;
    }

    public void setNotLoginMessage(JLabel notLoginMessage) {
        this.notLoginMessage = notLoginMessage;
    }

    public JLabel getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(JLabel copyrights) {
        this.copyrights = copyrights;
    }
}
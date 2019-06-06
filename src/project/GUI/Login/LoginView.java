package project.GUI.Login;

import project.Database.Locations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class LoginView extends JFrame {

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("login.png"));
    private JLabel backGround=new JLabel(imageForBG);
    private JLabel userLabel = new JLabel("ID:");
    private JLabel passwordLabel = new JLabel("PASSWORD:");
    private JLabel notLoginMessage =new JLabel("Not register? Click");
    private JLabel clickHereLabel =new JLabel("<HTML><U>here</U></HTML>");
    private JLabel copyrights = new JLabel("© all rights reserved");
    private Font labelFont = new Font("Ariel",Font.BOLD,14);
    private Font msgFont = new Font("Ariel",Font.BOLD,11);
    private Font copyrightsFont = new Font("Ariel",Font.PLAIN,9);
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton clearButton = new JButton("Clear");
    private JCheckBox passwordCheckBox = new JCheckBox("Show Password");

    public LoginView() {
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
        userLabel.setFont(this.labelFont);
        passwordLabel.setBounds(50, 220, 100, 30);
        passwordLabel.setFont(this.labelFont);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        passwordCheckBox.setBounds(150, 250, 150, 30);
        passwordCheckBox.setOpaque(false);
        loginButton.setBounds(50, 300, 100, 30);
        clearButton.setBounds(200, 300, 100, 30);
        backGround.setBounds(0,0,370,550);

        notLoginMessage.setBounds(110,340,120,30);
        notLoginMessage.setFont(this.msgFont);

        clickHereLabel.setBounds(217,340,40,30);
        clickHereLabel.setFont(this.msgFont);

        copyrights.setBounds(140,480,100,30);
        copyrights.setFont(this.copyrightsFont);
    }

    private void addComponentsToFrame() {
        add(userLabel);
        add(notLoginMessage);
        add(clickHereLabel);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        add(passwordCheckBox);
        add(loginButton);
        add(clearButton);
        add(copyrights);
        add(backGround);
    }

    public void setAction(ActionListener showPassword, ActionListener login, ActionListener clear, MouseAdapter clickHere) {
        passwordCheckBox.addActionListener(showPassword);
        loginButton.addActionListener(login);
        clearButton.addActionListener(clear);
        clickHereLabel.addMouseListener(clickHere);
    }

    public String getUser(){
        return userTextField.getText();
    }

    public String getPassword(){
        return new String(passwordField.getPassword());
    }

    public void showRegisterMsg() {
        JOptionPane.showMessageDialog(this, "\nAt this moment, registration is valid only via Admin.\nFeel free to contact us by mail for additional assistance.\n\n                      help@dentisitry.com");
    }

    public void showLoginMsg() {
        JOptionPane.showMessageDialog(this, "Invalid Username or Password");
    }

    public void clearText(){
        userTextField.setText("");
        passwordField.setText("");
    }

    public void showHidePassword(){
        if (passwordCheckBox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }

    }
}
package project.GUI.Login;

import project.Database.Locations;
import project.GUI.Login.Interfaces.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Observable;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LoginView extends Observable implements View {

    private JFrame loginFrame = new JFrame();
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

    @Override
    public void startView() {
        loginFrame.setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        loginFrame.setTitle("Login");
        loginFrame.setBounds(500, 100, 370, 550);
        loginFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
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
        loginFrame.add(userLabel);
        loginFrame.add(notLoginMessage);
        loginFrame.add(clickHereLabel);
        loginFrame.add(passwordLabel);
        loginFrame.add(userTextField);
        loginFrame.add(passwordField);
        loginFrame.add(passwordCheckBox);
        loginFrame.add(loginButton);
        loginFrame.add(clearButton);
        loginFrame.add(copyrights);
        loginFrame.add(backGround);
    }

    public void setActions(ActionListener showPassword, ActionListener login, ActionListener clear, MouseAdapter clickHere) {
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
        JOptionPane.showMessageDialog(loginFrame, "\nAt this moment, registration is valid only via Admin.\nFeel free to contact us by mail for additional assistance.\n\n                      help@dentisitry.com");
    }

    public void showLoginMsg() {
        JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password");
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

    public void checkLogin(){
        setChanged();
        notifyObservers(1);
    }

    public void closeFrame(){
        loginFrame.dispose();
    }
}
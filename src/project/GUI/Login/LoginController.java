package project.GUI.Login;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class LoginController {

    private LoginModel loginM;
    private LoginView loginV ;

    public LoginController(LoginModel loginM, LoginView loginV){
        this.loginM = loginM;
        this.loginV = loginV;

        addViewActionListeners();
    }

    public void addViewActionListeners() {
        loginV.getLoginButton().addActionListener(e -> {
            try {
                loginAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        loginV.getClickHere().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                showRegisterMsg();
            }
        });
        loginV.getShowPassword().addActionListener(e -> showPasswordAction());
        loginV.getClearButton().addActionListener(e -> clearAction());
    }

    private void showRegisterMsg() {
        JOptionPane.showMessageDialog(loginV, "\nAt this moment, registration is valid only via Admin.\nFeel free to contact us by mail for additional assistance.\n\n                      help@dentisitry.com");
    }

    public String getUser(){

        return loginV.getUserTextField().getText();
    }

    public String getPassword(){
        return new String(loginV.getPasswordField().getPassword());
    }

    public void loginAction() throws SQLException {
        if(!loginM.CheckLogin(getUser(), getPassword()))
        {
            JOptionPane.showMessageDialog(loginV, "Invalid Username or Password");
        }
        else
            loginV.dispose();
    }

    public void clearAction(){
        loginV.getUserTextField().setText("");
        loginV.getPasswordField().setText("");
    }

    public void showPasswordAction(){
        if (loginV.getShowPassword().isSelected()) {
            loginV.getPasswordField().setEchoChar((char) 0);
        } else {
            loginV.getPasswordField().setEchoChar('*');
        }
    }
}

package project.GUI;

import javax.swing.*;
import java.sql.SQLException;

public class LoginController {

    private LoginModel loginM;
    private LoginView loginV ;

    public LoginController(LoginModel loginM, LoginView loginV){
        this.loginM = loginM;
        this.loginV = loginV;

        initController();
    }

    public void initController() {
        loginV.getLoginButton().addActionListener(e -> loginAction());
        loginV.getShowPassword().addActionListener(e -> showPasswordAction());
        loginV.getClearButton().addActionListener(e -> clearAction());
    }

    public String getUser(){

        return loginV.getUserTextField().getText();
    }

    public String getPassword(){

        return new String(loginV.getPasswordField().getPassword());
    }

    public void loginAction() throws SQLException {
        if(loginM.CheckLogin(getUser(), getPassword()))
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

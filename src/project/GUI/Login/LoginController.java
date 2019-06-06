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

        MouseAdapter click = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                loginV.showRegisterMsg();
            }
        };

        loginV.setAction(e->showPasswordAction(),
                        e-> { try {
                                loginAction();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }},
                        e->clearAction(),click);
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
            loginV.showLoginMsg();
        }
        else
            loginV.dispose();
    }

    public void clearAction(){
        loginV.clearText();
    }

    public void showPasswordAction(){
        loginV.showHidePassword();
    }
}

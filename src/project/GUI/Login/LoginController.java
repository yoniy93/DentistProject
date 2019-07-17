package project.GUI.Login;

import project.GUI.Login.Interfaces.Controller;
import project.GUI.Login.Interfaces.Model;
import project.GUI.Login.Interfaces.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
/*
    Controller between LogIn Model and LogIn View
 */

public class LoginController implements  Controller  {

    private LoginModel loginM;
    private LoginView loginV ;

    public LoginController(Model loginM, View loginV){
        this.loginM = (LoginModel) loginM;
        this.loginV = (LoginView) loginV;

        addViewActionListeners();
    }

    //add action listeners to LOGIN window
    public void addViewActionListeners() {
        MouseAdapter click = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                loginV.showRegisterMsg();
            }
        };

        loginV.setActions(e->showPasswordAction(), e-> loginAction(), e->clearAction(),click);
    }


    public void loginAction() {
        loginV.checkLogin();
    }

    public void clearAction(){
        loginV.clearText();
    }

    public void showPasswordAction(){
        loginV.showHidePassword();
    }

    @Override
    public void update(Observable observable, Object isGrunted) {
        if(observable instanceof LoginView) {//LogIn view needs to check if the details entered are correct according to the DB.
            try {
                loginM.CheckLogin(loginV.getUser(), loginV.getPassword());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            if (observable instanceof LoginModel)//LogIn model returns an answer to the LogIn view
            {
                if ((boolean) isGrunted) {
                    loginV.closeFrame();
                } else {
                    loginV.showLoginMsg();
                }
            }
        }
    }
}

package project.GUI.Login;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

public class LoginController implements Observer {

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

        loginV.setActions(e->showPasswordAction(), e-> loginAction(), e->clearAction(),click);
    }

    public void loginAction() {

        loginV.checkLogin();
/*
        if(!loginM.CheckLogin(loginV.getUser(), loginV.getPassword()))
        {
            loginV.showLoginMsg();
        }
        else
            loginV.closeFrame();
 */
    }

    public void clearAction(){
        loginV.clearText();
    }

    public void showPasswordAction(){
        loginV.showHidePassword();
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof LoginView)
        {
            try {
                loginM.CheckLogin(loginV.getUser(), loginV.getPassword());
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else if (observable instanceof LoginModel) {

                if ((boolean) o) {
                    loginV.closeFrame();
                } else {
                    loginV.showLoginMsg();
                }
            }
    }
}

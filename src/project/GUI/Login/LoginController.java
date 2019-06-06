package project.GUI.Login;

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

        loginV.setActions(e->showPasswordAction(),
                        e-> { try {
                                loginAction();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }},
                        e->clearAction(),click);
    }

    public void loginAction() throws SQLException {
        if(!loginM.CheckLogin(loginV.getUser(), loginV.getPassword()))
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

package project.GUI;

import project.Logic.LogInHandler;

public class LoginModel {

    private LogInHandler logInHandler;

    public LoginModel() {
        logInHandler = new LogInHandler();
    }

    public boolean CheckLogin(String username, String password){

        if(logInHandler.isUserExists(username) && logInHandler.isUserExists(password))
        {
            switch (logInHandler.getUserType(username))
            {
                //enum USER_TYPE { ADMIN, DOCTOR, PATIENT, SECRETARY, ERROR};
                /*
                AdminFrame adminFrame = new AdminFrame();
                loginV.getLoginFrame().setVisible(false);
                adminFrame.setResizable(false);
                */
            }

            return true;
        }
        else
            return  false;
    }
}

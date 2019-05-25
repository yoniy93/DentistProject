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
                /*
                case ADMIN: StartAdminView; break;
                case DOCTOR: StartDoctorView; break;
                case PATIENT: StartPatientView; break;
                case SECRETARY: StartSecretaryView; break;
                case ERROR: return  false;
                */
            }
            return true;
        }
        else
            return false;
    }
}

package project.GUI;
import project.Logic.LogInHandler;

import java.sql.SQLException;

public class LoginModel {

    public LoginModel() {
    }

    public boolean CheckLogin(String username, String password) throws SQLException {

        LogInHandler logInHandler = new  LogInHandler(username);

        if(logInHandler.isUserExists(username) && logInHandler.isUserExists(password))
        {
            switch (logInHandler.getUserType(username))
            {
                /*
                case ADMIN: StartAdminView; break;
                case DOCTOR: StartDoctorView; break;
                case PATIENT: StartPatientView; break;
                case SECRETARY: StartSecretaryView; break;
                case ERROR: return false;
                */
            }
            return true;
        }
        else
            return false;
    }
}
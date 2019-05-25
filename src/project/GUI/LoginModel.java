package project.GUI;
import project.Logic.LogInHandler;

import java.sql.SQLException;

public class LoginModel {

    public LoginModel() {
    }

    public boolean CheckLogin(String username, String password) throws SQLException {

        LogInHandler logInHandler = new  LogInHandler();

        if(logInHandler.isUserExists(username) && logInHandler.isPasswordCorrect(username,password))
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
            return false;
        }
        else
            return false;
    }
}

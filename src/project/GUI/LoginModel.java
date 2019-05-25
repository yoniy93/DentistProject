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
                case ADMIN: new StartAdminView(); break;
                case DOCTOR: new StartDoctorView(); break;
                case PATIENT: new StartPatientView(); break;
                case SECRETARY: new StartSecretaryView(); break;
                case ERROR: return false;
            }
            return true;
        }
        else
            return false;
    }
}

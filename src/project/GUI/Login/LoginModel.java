package project.GUI.Login;
import project.Entities.Admin;
import project.Entities.Doctor;
import project.Entities.Patient;
import project.GUI.Admin.StartAdminView;
import project.GUI.Doctor.StartDoctorView;
import project.GUI.Patient.StartPatientView;
import project.Logic.DatabaseHandler;
import project.Logic.LogInHandler;

import java.sql.SQLException;

public class LoginModel {

    public LoginModel() {
    }

    public boolean CheckLogin(String username, String password) throws SQLException {

        DatabaseHandler databaseHandler=new DatabaseHandler();
        LogInHandler logInHandler = new  LogInHandler();

        if(logInHandler.isUserExists(username) && logInHandler.isPasswordCorrect(username,password))
        {
            switch (logInHandler.getUserType(username))
            {
                case ADMIN:
                {
                    Admin admin=databaseHandler.getAdminDetails(username);
                    new StartAdminView(admin);
                    break;
                }
                case DOCTOR:
                {
                    Doctor doctor=databaseHandler.getDoctorDetails(username);
                    new StartDoctorView(doctor);
                    break;
                }
                case PATIENT:
                    {
                    Patient patient=databaseHandler.getPatientDetails(username);
                    new StartPatientView(patient);
                    break;
                }
                case ERROR: return false;
            }
            return true;
        }
        else
            return false;
    }
}

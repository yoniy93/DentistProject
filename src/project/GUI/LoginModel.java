package project.GUI;
import project.Entities.Admin;
import project.Entities.Doctor;
import project.Entities.Patient;
import project.Entities.USER_TYPE;
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
                    StartAdminView adminConnection=new StartAdminView(admin);
                    break;
                }
                case DOCTOR:
                {
                    Doctor doctor=databaseHandler.getDoctorDetails(username);
                    StartDoctorView doctorConnection=new StartDoctorView();
                    break;
                }

                case PATIENT:
                    {
                    Patient patient=databaseHandler.getPatientDetails(username);
                    StartPatientView patientConnection=new StartPatientView();
                    break;
                }

                case ERROR: return false;

            }
            return false;
        }
        else
            return false;
    }
}

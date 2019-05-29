package project.GUI.Login;
import project.Entities.Admin;
import project.Entities.Doctor;
import project.Entities.Patient;
import project.Entities.USER_TYPE;
import project.GUI.Admin.General.StartAdminView;
import project.GUI.Doctor.General.StartDoctorView;
import project.GUI.Patient.General.StartPatientView;
import project.Database.DBQuerys;

import java.sql.SQLException;

public class LoginModel {

    public LoginModel() {
    }

    public boolean CheckLogin(String username, String password) throws SQLException {

        DBQuerys databaseQuerys=new DBQuerys();

        if(this.isUserExists(username) && this.isPasswordCorrect(username,password))
        {
            switch (this.getUserType(username))
            {
                case ADMIN:
                {
                    Admin admin = databaseQuerys.getAdminDetails(username);
                    new StartAdminView(admin);
                    break;
                }
                case DOCTOR:
                {
                    Doctor doctor = databaseQuerys.getDoctorDetails(username);
                    new StartDoctorView(doctor);
                    break;
                }
                case PATIENT:
                {
                    Patient patient = databaseQuerys.getPatientDetails(username);
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

    public USER_TYPE getUserType (String username)  {
        return new DBQuerys().getTypeOfUser(username);
    }

    public boolean isPasswordCorrect (String userid, String password) {
        return new DBQuerys().isPasswordCorrect(userid,password);
    }

    public boolean isUserExists (String id) {
        return new DBQuerys().isUserExists(id);
    }
}

package project.GUI.Login;
import project.Entities.Admin;
import project.Entities.Doctor;
import project.Entities.Patient;
import project.Entities.USER_TYPE;
import project.GUI.Login.Interfaces.Model;
import project.GUI.Start.StartAdminView;
import project.GUI.Start.StartDoctorView;
import project.GUI.Start.StartPatientView;
import project.Database.DBQuerys;

import java.sql.SQLException;
import java.util.Observable;

public class LoginModel extends Observable implements Model {

    public void CheckLogin(String username, String password) throws SQLException {

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
                case ERROR: {
                    setChanged();
                    notifyObservers(false);
                    return;
                }
            }
            setChanged();
            notifyObservers(true);
        }
        else
            setChanged();
            notifyObservers(false);
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

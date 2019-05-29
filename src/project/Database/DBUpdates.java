package project.Database;

import project.Entities.Admin;
import project.Entities.Doctor;
import project.Entities.MedicalEquipment;
import project.Entities.Patient;

public class DBUpdates extends DBInitializer {

    public void updateEquipmentsQuantity(MedicalEquipment m){
        String sql= "UPDATE medical_equipment SET  quantity="+m.getAmountInStock()+"WHERE id=" +m.getId()+";";
        connectAndExecute(sql);
    }

    public void updatePatientDetails(Patient p){
        String sql= "UPDATE users SET  password="+p.getPassword()+", firstname="+p.getFirstName() +
                ", lastname="+p.getLastName() +", email="+p.getEmail() +"WHERE id=" +p.getId()+";";
        connectAndExecute(sql);
    }

    public void updateDoctorDetails(Doctor d){
        String sql= "UPDATE users SET  password="+d.getPassword()+", firstname="+d.getFirstName() +
                ", lastname="+d.getLastName() +", email="+d.getEmail() +", birthdate="+ d.getDateOfBirth()+
                ", birthdate="+d.getDateOfBirth() +"WHERE id=" +d.getId()+";";
        connectAndExecute(sql);
    }

    public void updateAdmin(Admin a) {
        String sql= "UPDATE users SET  password="+a.getPassword()+", firstname="+a.getFirstName() +
                ", lastname="+a.getLastName() +", email="+a.getEmail() +"WHERE id=" +a.getId()+";";
        connectAndExecute(sql);
    }

    public void deleteFromUsers(String id) {
        String sql="DELETE FROM users WHERE id="+id;
        connectAndExecute(sql);
    }
}

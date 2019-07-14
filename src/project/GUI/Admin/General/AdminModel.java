package project.GUI.Admin.General;

import project.Database.DBInserts;
import project.Database.DBQuerys;
import project.Database.DBUpdates;
import project.Entities.Admin;

public class AdminModel {

    private Admin admin;
    DBInserts dbInserts = new DBInserts();
    DBQuerys dbQuerys = new DBQuerys();

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AdminModel(Admin admin){
        this.admin = admin;
    }


    public int getAvailableId(){
        return dbQuerys.getLastId("treatments");
    }

    public String InsertTreatment(int Id, String Name , int Duration, double Price)
    {
        return dbInserts.insertTreatment(Id, Name,Duration, Price);
    }


    public void UpdateAdmin() {
        DBUpdates databaseUpdates = new DBUpdates();
        databaseUpdates.updateAdmin(admin);
    }
}

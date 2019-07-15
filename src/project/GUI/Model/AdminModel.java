package project.GUI.Model;

import project.Database.DBInserts;
import project.Database.DBQuerys;
import project.Database.DBUpdates;
import project.Entities.Admin;

public class AdminModel {

    private Admin admin;
    private DBInserts dbInserts = new DBInserts();
    private DBQuerys dbQuerys = new DBQuerys();

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

    public String deleteUser (String id) {
        return new DBUpdates().deleteUserFromDB(id);
    }

    public Boolean isUserExists(String id) { return new DBQuerys().isUserExists(id); }

    public void UpdateAdmin() {
        DBUpdates databaseUpdates = new DBUpdates();
        databaseUpdates.updateAdmin(admin);
    }

    public String insertForDoctor(String id, String pswd, String name, String lname, String email, String bdate, String gender,int yearofEx,String phoneNumber)
    {
        String msg=dbInserts.insertForDoctor(id, pswd, name, lname,email,bdate,gender,yearofEx,phoneNumber);
        return msg;
    }

    public String insertForPatient(String id, String pswd, String name, String lname, String email, double wieght, int height, String bdate, String gender,String phoneNumber)
    {
        String msg=dbInserts.insertForPatient(id,pswd,name,lname,email,wieght,height,bdate,gender,phoneNumber);
        return msg;
    }


}

package project.GUI;

import project.Entities.Admin;
import project.Entities.Doctor;
import project.Entities.Patient;
import project.GUI.Login.StartLoginView;
import project.Logic.DatabaseHandler;

import javax.swing.*;
import java.text.SimpleDateFormat;


public class Main {
    public static void main(String[] args)
    {
        CreateDataBase();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
            }
        });
    }

    public static void CreateDataBase(){

        DatabaseHandler db = new DatabaseHandler();
        DatabaseHandler.createNewDatabase();
        DatabaseHandler.createNewTables();
//        String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
            db.insertForAdmin("1234567","1234567","Admin","Admin","mail","13-05-1993","male");
            db.insertForDoctor("302208178","12345","Yoni","Yardeni","yoniy93@gmail.com","13-05-1993","male",3);
            db.insertForPatient("123","123","check","check","check",60.5,178,"13-05-1993","male");
            db.insertTreatment(1,"שיננית",50);
            db.insertMedicalEquipment(11,"מזלג", "12-12-2020",4);

    }
}
package project.GUI;

import project.GUI.Login.StartLoginView;
import project.Logic.DBHandler;
import project.Logic.DBInserts;
import java.io.File;

import javax.swing.*;


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

        File file=new File("projectDB");
        boolean isDBexists=true;
        if (!file.exists())
            isDBexists=false;
        DBHandler db = new DBHandler();
        DBInserts dbInserts=new DBInserts();
        DBHandler.createNewDatabase();
        DBHandler.createNewTables();
//        String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
        if (isDBexists) {
            dbInserts.insertForAdmin("1234567", "1234567", "Admin", "Admin", "mail", "13-05-1993", "male");
            dbInserts.insertForDoctor("302208178", "12345", "Yoni", "Yardeni", "yoniy93@gmail.com", "13-05-1993", "male", 3);
            dbInserts.insertForPatient("123", "123", "check", "check", "check", 60.5, 178, "13-05-1993", "male");
            dbInserts.insertTreatment(1, "שיננית", 50, 100);
            dbInserts.insertMedicalEquipment(11, "מזלג", "12-12-2020", 4);
        }

    }
}
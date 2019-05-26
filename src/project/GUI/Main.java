package project.GUI;

import project.GUI.Login.StartLoginView;
import project.Logic.DatabaseHandler;

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

        DatabaseHandler db = new DatabaseHandler();
        DatabaseHandler.createNewDatabase();
        DatabaseHandler.createNewTables();
        // String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
        db.insertForAdmin("1234567","1234567","Admin","Admin","mail","13-05-1993","male");
        db.insertForDoctor("302208178","12345","Yoni","Yardeni","yoniy93@gmail.com","13-05-1993","male",3);

    }
}
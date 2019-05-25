package project.GUI;


import project.Entities.USER_TYPE;
import project.Logic.DatabaseHandler;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {

        DatabaseHandler.createNewDatabase();
        DatabaseHandler.createNewTables();
        new DatabaseHandler().insert("1","1","a","a","e",1,1,"130593", USER_TYPE.ADMIN,"M");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
            }
        });
    }
}
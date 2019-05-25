package project.GUI;


import project.Entities.USER_TYPE;
import project.GUI.Login.StartLoginView;
import project.Logic.DatabaseHandler;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        DatabaseHandler a = new DatabaseHandler();
        DatabaseHandler.createNewDatabase();
        DatabaseHandler.createNewTables();
        a.insert("1","1","a","a","e",1,1,"130593", USER_TYPE.ADMIN,"M",1);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
            }
        });
    }
}
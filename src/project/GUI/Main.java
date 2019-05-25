package project.GUI;

import project.Logic.CreateTable;
import project.Logic.Database;
import project.Logic.InsertApp;
import project.Logic.SQLiteJDBCDriverConnection;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        SQLiteJDBCDriverConnection.connect();
        Database.createNewDatabase();
        Database.createNewTable();
        InsertApp i = new InsertApp();
        i.insert();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
                new StartDoctorView();
            }
        });
    }
}
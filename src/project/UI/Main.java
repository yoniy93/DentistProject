package project.UI;

import project.Logic.SQLiteJDBCDriverConnection;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        //Database.createNewDatabase();
        SQLiteJDBCDriverConnection.connect();
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new LoginFrame();
            }
        });
    }
}
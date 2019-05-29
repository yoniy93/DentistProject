package project;

import project.GUI.Login.StartLoginView;
import project.Database.DBInitializer;
import javax.swing.*;


public class Main {
    public static void main(String[] args)
    {

        DBInitializer.loadDatabaseWithInitialData();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
            }
        });
    }


}
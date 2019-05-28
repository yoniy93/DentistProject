package project.GUI;

import project.GUI.Login.StartLoginView;
import project.Logic.DBHandler;
import project.Logic.DBInit;
import project.Logic.DBInserts;
import java.io.File;

import javax.swing.*;


public class Main {
    public static void main(String[] args)
    {

        DBInit.loadDatabaseWithInitialData();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
            }
        });
    }


}
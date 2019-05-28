package project.GUI;

import project.GUI.Login.StartLoginView;
import project.Logic.DBInit;
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
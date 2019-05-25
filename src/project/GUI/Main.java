package project.GUI;

import project.Logic.CreateTable;
import project.Logic.InsertApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        CreateTable a = new CreateTable();
        InsertApp i = new InsertApp();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
                new StartDoctorView();
            }
        });
    }
}
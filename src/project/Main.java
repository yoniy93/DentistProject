package project;

import project.Screens.App;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        JFrame frame=new JFrame("App");
        frame.setContentPane(new App().LogInScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

package project.GUI;

import project.GUI.Login.StartLoginView;
import javax.swing.*;

public class PersonController {

    protected PersonController(){

    }

    protected void logoutAction(PersonView personView) {
        personView.dispose();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartLoginView();
            }
        });
    }
}
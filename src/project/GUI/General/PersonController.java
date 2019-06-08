package project.GUI.General;

import project.GUI.Login.StartLoginView;
import javax.swing.*;

public abstract class PersonController {

    protected void logoutAction(PersonView personView) {
       personView.dispose();
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
                new StartLoginView();
            }
       });
    }
}

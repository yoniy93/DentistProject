package project.GUI.General;

import javax.swing.*;
import java.awt.*;

public class ErrorWindow {

    Component jframe;
    String message;
    public ErrorWindow(Component jframe, String message)
    {
        this.jframe=jframe;
        this.message=message;
        JOptionPane.showMessageDialog( jframe,  message);
    }
}

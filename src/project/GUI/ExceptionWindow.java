package project.GUI;

import javax.swing.*;
import java.awt.*;

public class ExceptionWindow {

    Component jframe;
    String message;
    public ExceptionWindow(Component jframe,String message)
    {
        this.jframe=jframe;
        this.message=message;
        JOptionPane.showMessageDialog( jframe,  message);
    }
}

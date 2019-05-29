package project.GUI;

import javax.swing.*;

public class ExceptionWindow {

    JFrame jframe;
    String message;
    public ExceptionWindow(JFrame jframe,String message)
    {
        this.jframe=jframe;
        this.message=message;
        JOptionPane.showMessageDialog( jframe,  message);
    }
}

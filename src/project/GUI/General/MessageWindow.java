package project.GUI.General;

import javax.swing.*;
import java.awt.*;

public class MessageWindow {

    Component jframe;
    String message;
    public MessageWindow(Component jframe, String message) {
        this.jframe=jframe;
        this.message=message;
        JOptionPane.showMessageDialog( jframe,  message);
    }
}

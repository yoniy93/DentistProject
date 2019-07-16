package project.GUI.View;

import javax.swing.*;
import java.awt.*;

public class ExitButton extends JButton {

    public ExitButton( ){
        setText("Cancel");
    }

    public void setLocation(int x, int y, int w, int h) {
        setFont(new Font("Ariel",Font.BOLD, 12));
        setBounds(x, y, w, h);
    }
}

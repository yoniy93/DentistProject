package project.GUI.General;

import javax.swing.*;
import java.awt.*;

public class CancelButton extends JButton {

    public CancelButton( ){
        setText("Cancel");
    }

    public void setLocation(int x, int y, int w, int h) {
        setFont(new Font("Tahoma",Font.BOLD, 12));
        setBounds(x, y, w, h);
    }
}

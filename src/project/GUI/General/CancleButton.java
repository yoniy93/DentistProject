package project.GUI.General;

import javax.swing.*;
import java.awt.*;

public class CancleButton extends JButton {

    public CancleButton( ){
        setText("Cancel");
    }

    public void setLocation(int x, int y, int w, int h) {
        setFont(new Font("Tahoma", Font.BOLD, 14));
        setBounds(x, y, w, h);
    }
}

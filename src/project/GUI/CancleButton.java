package project.GUI;

import javax.swing.*;
import java.awt.*;

public class CancleButton extends JButton {

    public CancleButton( ){
        setText("Cancle");
    }

    public void setLocation(int x, int y, int w, int h) {
        setFont(new Font("Tahoma", Font.PLAIN, 14));
        setBounds(x, y, w, h);
    }
}

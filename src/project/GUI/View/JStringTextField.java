package project.GUI.View;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * A {@link JTextField} that skips all non-digit keys. The user is only able to enter numbers.
 *
 * @author Michi Gysel <michi@scythe.ch>
 *
 */
public class JStringTextField extends JTextField {
    private static final long serialVersionUID = 1L;

    @Override
    public void processKeyEvent(KeyEvent ev) {
        if (Character.isAlphabetic(ev.getKeyChar()) || ev.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            super.processKeyEvent(ev);
        }
        ev.consume();
        return;
    }
}
package project.GUI.View;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_DECIMAL;
import static java.awt.event.KeyEvent.VK_PERIOD;

/**
 * A {@link JTextField} that skips all non-digit keys. The user is only able to enter numbers.
 *
 * @author Michi Gysel <michi@scythe.ch>
 *
 */
public class JDoubleTextField extends JTextField {
    private static final long serialVersionUID = 1L;

    private static int dotCount = 0;

    @Override
    public void processKeyEvent(KeyEvent ev) {

        char keyChar = ev.getKeyChar();
        int keyCode = ev.getKeyCode();

        if (Character.isDigit(keyChar) || keyChar == KeyEvent.VK_BACK_SPACE || keyCode == KeyEvent.VK_PERIOD || keyCode == VK_DECIMAL) {
            if(keyCode == VK_PERIOD || keyCode == VK_DECIMAL)
                dotCount++;
            else
                super.processKeyEvent(ev);

            if(dotCount > 1){
                ev.consume();
                return;
            }

            super.processKeyEvent(ev);
        }

        ev.consume();
        return;
    }
}
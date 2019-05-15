package project.Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {


    int numberOfClicked=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        numberOfClicked++;
        System.out.println(numberOfClicked);

    }
}

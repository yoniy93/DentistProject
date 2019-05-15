package project.Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {


    UI ui;
    public int getNumberOfClicked(){
        return numberOfClicked;
    }

    public MyListener(UI ui){
        this.ui=ui;
    }

    int numberOfClicked=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        numberOfClicked++;
        System.out.println(numberOfClicked);
        ui.update();
    }
}

package project.Screens;

import javax.swing.*;

public class UI {
    JFrame frame;
    JLabel label;
    JButton button;
    MyListener listener;
    JCheckBox checkBox;
    public UI (){
        frame= new JFrame();
        frame.setBounds(100,100,800,600);
        frame.setLayout(null);
        frame.setVisible(true);

         label= new JLabel();
        label.setBounds(100,100,200,60);
        label.setText("hello amit");
        frame.add(label);

        button=new JButton();
        button.setBounds(100,200,200,60);
        button.setText("click me");
        listener=new MyListener();
        button.addActionListener(listener);
        frame.add(button);

        checkBox =new JCheckBox();
        checkBox.setBounds(300,100,200,60);
        checkBox.setText("yes or no");
        frame.add(checkBox);
    }

    public void update() {
        label.setText("number of clicks" + listener.numberOfClicked);

    }
    public static void main(String[] args) {
         UI ui=new UI();
         ui.update();

    }
}

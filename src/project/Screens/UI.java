package project.Screens;

import javax.swing.*;

public class UI {
    public static void main (String[] args){
        JFrame frame= new JFrame();
        frame.setBounds(100,100,800,600);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel label = new JLabel();
        label.setBounds(100,100,200,60);
        label.setText("hello amir");
        frame.add(label);

        JButton button=new JButton();
        button.setBounds(100,200,200,60);
        button.setText("click me");
        MyListener listener=new MyListener();
        button.addActionListener(listener);
        frame.add(button);

    }
}

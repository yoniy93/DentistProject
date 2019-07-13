package project.GUI.Patient.Appointments;

import project.GUI.General.Calendar.DateAndTime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetAnAppointment extends JFrame implements ActionListener{

        DateAndTime dateTimePanel = new DateAndTime();
        JButton button = new JButton("Check Date");

        public SetAnAppointment(){
            setLayout(null);
            setLocationAndSize();

            addComponentsToFrame();
            setBounds(0, 0, 800, 600);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setVisible(true);
        }

        private void setLocationAndSize() {
            dateTimePanel.setLocation(100, 100);
            button.setBounds(200,200,130,30);
        }

        private void addComponentsToFrame() {
            add(dateTimePanel);
            add(button);

            button.addActionListener(this);
        }


        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(this,"Date: " + dateTimePanel.getDate() +"\nTime: " + dateTimePanel.getTime());
        }
    }


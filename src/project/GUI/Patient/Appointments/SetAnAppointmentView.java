package project.GUI.Patient.Appointments;

import project.Database.Locations;
import project.Entities.Doctor;
import project.GUI.General.Calendar.DateAndTime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class SetAnAppointmentView extends JFrame implements ActionListener{

    ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    JLabel backGround = new JLabel(imageForBG);

    DateAndTime dateTimePanel = new DateAndTime();
    JButton checkDateButton = new JButton("Check Date");

    JLabel creditCardLabel = new JLabel("Credit Card");
    JLabel validityLabel= new JLabel("Validity:");
    JLabel cvvLabel=new JLabel("CVV:");

    JTextField cvv=new JTextField();
    JTextField creditCard= new JTextField();

    Vector yearVector = new Vector(100);
    Vector monthVector = new Vector(12) ;
    JComboBox month=new JComboBox(monthVector);
    JComboBox year=new JComboBox(yearVector);

    JLabel doctorLabel=new JLabel("Doctor :");
    JComboBox<Doctor> doctorJComboBox = new JComboBox<Doctor>();



    public SetAnAppointmentView(){
        setLayout(null);
        setLocationAndSize();
        setDateOfBirth();
        addComponentsToFrame();
        setBounds(0, 0, 800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        }

        private void setLocationAndSize() {
            dateTimePanel.setLocation(100, 100);
            checkDateButton.setBounds(200,200,130,30);
        }

        private void addComponentsToFrame() {
            add(dateTimePanel);
            add(checkDateButton);
            add(creditCard);
            add(creditCardLabel);
            add(cvvLabel);
            add(validityLabel);
            add(cvv);
            add(year);
            add(month);
            add(doctorJComboBox);
            add(doctorLabel);
            add(backGround);
            checkDateButton.addActionListener(this);
        }

    private void setDateOfBirth() {
        for(int i=0;i<12; i++)
        {
            monthVector.insertElementAt(i+1,i);
        }
        int min=2019;
        for (int i=0; i<=100; i++)
        {
            yearVector.insertElementAt(min++,i);
        }
    }
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(this,"Date: " + dateTimePanel.getDate() +"\nTime: " + dateTimePanel.getTime());
        }


    public JComboBox getDoctorJComboBox() {
        return doctorJComboBox;
    }

    public void setDoctorList(List<Doctor> values) {
        this.doctorJComboBox.removeAllItems();
        values.forEach(x -> this.doctorJComboBox.addItem(x));
    }
    }


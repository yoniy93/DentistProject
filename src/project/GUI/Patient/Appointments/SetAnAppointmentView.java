package project.GUI.Patient.Appointments;

import project.Database.Locations;
import project.Entities.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import project.GUI.General.Calendar.DateListener;
import project.GUI.General.Calendar.VetoPolicy;
import project.GUI.General.CancelButton;

import static com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement.OneHour;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class SetAnAppointmentView extends JFrame implements ActionListener{

    ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    JLabel backGround = new JLabel(imageForBG);

    JButton insertAppointment = new JButton("Check Date");
    CancelButton cancelButton = new CancelButton();

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
    JComboBox<Doctor> doctorComboBox = new JComboBox<Doctor>();

    DateTimePicker dateTimePicker = new DateTimePicker();


    public SetAnAppointmentView(){
        setLayout(null);
        setLocationAndSize();
        setDateOfBirth();
        addComponentsToFrame();
        setBounds(0, 0, 800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        doctorComboBox.setVisible(true);
        setDateSettings();
        setTimeSettings();
        dateTimePicker.setVisible(true);
        }

    private void setLocationAndSize() {
            insertAppointment.setBounds(200,200,130,30);
    }

    private void addComponentsToFrame() {
            add(insertAppointment);
            add(creditCard);
            add(creditCardLabel);
            add(cvvLabel);
            add(validityLabel);
            add(cvv);
            add(year);
            add(month);
            add(doctorComboBox);
            add(doctorLabel);
            add(dateTimePicker);
            add(backGround);
            insertAppointment.addActionListener(this);
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
        JOptionPane.showMessageDialog(this,"Date: " + getDate() +"\nTime: " + getTime());
    }

    public String getDoctorID() {
        return ((Doctor) doctorComboBox.getSelectedItem()).getId();
    }

    public void setDoctorList(List<Doctor> values) {
        this.doctorComboBox.removeAllItems();
        values.forEach(x -> this.doctorComboBox.addItem(x));
    }

    private void setDateSettings() {
        DatePickerSettings dateSettings = dateTimePicker.datePicker.getSettings();
        dateSettings.setVetoPolicy(new VetoPolicy());
        dateSettings.setVisibleTodayButton(false);
        dateSettings.setVisibleNextYearButton(false);
        dateSettings.setVisiblePreviousYearButton(false);
        dateSettings.setFirstDayOfWeek(DayOfWeek.SUNDAY);
        dateSettings.setFormatForDatesCommonEra("dd-MM-yyyy");
        dateSettings.setFormatForDatesBeforeCommonEra("dd-MM-uuuu");
    }

    private void setTimeSettings() {
        TimePickerSettings timeSettings = dateTimePicker.timePicker.getSettings();
        LocalTime start = LocalTime.of(8,0);
        LocalTime finish = LocalTime.of(17, 0);
        timeSettings.generatePotentialMenuTimes(OneHour,start,finish);
        timeSettings.setFormatForDisplayTime("hh:mm");
        timeSettings.use24HourClockFormat();
    }

    @Override
    public void setLocation(int x, int y) {
        setBounds(x, y,260,35);
    }

    public String getTime(){
        return dateTimePicker.getTimePicker().getText();
    }

    public String getDate() {
        return dateTimePicker.getDatePicker().getText();
    }

    public void setActions(ActionListener select, ActionListener insert ,ActionListener cancel) {
        doctorComboBox.addActionListener(select);
        insertAppointment.addActionListener(insert);
        cancelButton.addActionListener((cancel));
    }

    public void setDateListener(String doctorID){
        dateTimePicker.datePicker.addDateChangeListener(new DateListener(dateTimePicker, doctorID));
    }

}


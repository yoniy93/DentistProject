package project.GUI.Patient.Appointments;

import com.github.lgooddatepicker.components.*;
import project.Database.Locations;
import project.Entities.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import project.GUI.General.Calendar.DateListener;
import project.GUI.General.Calendar.VetoPolicy;
import project.GUI.General.CancelButton;

import static com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement.OneHour;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class SetAnAppointmentView extends JFrame implements ActionListener{

    ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    JLabel backGround = new JLabel(imageForBG);

    JButton setAppointmentButton = new JButton("Set An Appointment");
    CancelButton cancelButton = new CancelButton();

    JLabel doctorLabel = new JLabel("Select Doctor:");
    JLabel dateAndTimeLabel = new JLabel("Select Date & time:");
    JLabel creditCardLabel = new JLabel("Credit Card");
    JLabel validityLabel = new JLabel("Validity:");
    JLabel cvvLabel = new JLabel("CVV:");

    JTextField creditCardTextField = new JTextField();
    JTextField validityTextField = new JTextField();
    JTextField cvvTextField = new JTextField();

    Vector yearVector = new Vector(100);
    Vector monthVector = new Vector(12) ;

    JComboBox monthComboBox = new JComboBox(monthVector);
    JComboBox yearComboBox = new JComboBox(yearVector);

    JComboBox<Doctor> doctorComboBox = new JComboBox<Doctor>();

    JPanel dateTimePickerPanel = new JPanel();

    DatePicker datePicker = new DatePicker();
    TimePicker timePicker = new TimePicker();


    public SetAnAppointmentView(){
        setLayout(null);

        setLocationAndSize();
        setDateOfBirth();
        addComponentsToFrame();
        setDateSettings();
        setTimeSettings();

        setBounds(0, 0, 800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        }

    private void setLocationAndSize() {

        doctorLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        doctorLabel.setBounds(170,50,120, 30);
        doctorComboBox.setBounds(300,50,100,30);

        dateAndTimeLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        dateAndTimeLabel.setBounds(170,130,120, 30);

        dateTimePickerPanel.setBounds(270,130,280,35);
        dateTimePickerPanel.setOpaque(false);

        creditCardLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        creditCardLabel.setBounds(170,220,90, 30);
        creditCardTextField.setBounds(270,220,220, 30);

        validityLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        validityLabel.setBounds(170,270,100, 30);

        monthComboBox.setBounds(270,270,100, 30);
        yearComboBox.setBounds(390,270,100, 30);

        cvvLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        cvvLabel.setBounds(170,320,100, 30);
        cvvTextField.setBounds(270,320,50,30);

        setAppointmentButton.setBounds(270,400,150,30);

        backGround.setBounds(0,0,800,500);
    }

    private void addComponentsToFrame() {
        add(setAppointmentButton);

        add(creditCardLabel);
        add(creditCardTextField);

        add(validityLabel);
        add(validityTextField);

        add(cvvLabel);
        add(cvvTextField);

        add(yearComboBox);
        add(monthComboBox);

        add(doctorLabel);
        add(doctorComboBox);

        add(dateAndTimeLabel);
        dateTimePickerPanel.add(datePicker);
        dateTimePickerPanel.add(timePicker);
        add(dateTimePickerPanel);

        add(backGround);
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

    public void setDoctorList(List<Doctor> values) {
        this.doctorComboBox.removeAllItems();
        values.forEach(x -> this.doctorComboBox.addItem(x));
    }

    private void setDateSettings() {
        DatePickerSettings dateSettings = datePicker.getSettings();
        dateSettings.setVetoPolicy(new VetoPolicy());
        dateSettings.setVisibleTodayButton(false);
        dateSettings.setVisibleNextYearButton(false);
        dateSettings.setVisiblePreviousYearButton(false);
        dateSettings.setFirstDayOfWeek(DayOfWeek.SUNDAY);
        dateSettings.setFormatForDatesCommonEra("dd-MM-yyyy");
        dateSettings.setFormatForDatesBeforeCommonEra("dd-MM-uuuu");
    }

    private void setTimeSettings() {
        TimePickerSettings timeSettings = timePicker.getSettings();
        LocalTime start = LocalTime.of(8,0);
        LocalTime finish = LocalTime.of(17, 0);
        timeSettings.generatePotentialMenuTimes(OneHour,start,finish);
        timeSettings.setFormatForDisplayTime("hh:mm");
        timeSettings.use24HourClockFormat();
    }

    public String getDoctorID() {
        return ((Doctor) doctorComboBox.getSelectedItem()).getId();
    }

    public String getTime(){
        return timePicker.getText();
    }

    public String getDate() {
        return datePicker.getText();
    }

    public void setActions(ActionListener select, ActionListener insert ,ActionListener cancel) {
        doctorComboBox.addActionListener(select);
        setAppointmentButton.addActionListener(insert);
        cancelButton.addActionListener((cancel));
    }

    public void setDateListener(String doctorID){
        datePicker.addDateChangeListener(new DateListener(timePicker, doctorID));
    }

    public void clearDateAndTime(){
        datePicker.clear();
        timePicker.clear();
    }
}


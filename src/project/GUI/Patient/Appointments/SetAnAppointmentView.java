package project.GUI.Patient.Appointments;

import com.github.lgooddatepicker.components.*;
import project.Database.Locations;
import project.Entities.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import project.Entities.Treatments;
import project.GUI.General.Calendar.DateListener;
import project.GUI.General.Calendar.VetoPolicy;
import project.GUI.General.CancelButton;

import static com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement.OneHour;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class SetAnAppointmentView extends JFrame {

    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    private JLabel backGround = new JLabel(imageForBG);

    private JButton setAppointmentButton = new JButton("Set An Appointment");
    private CancelButton cancelButton = new CancelButton();

    private JLabel doctorLabel = new JLabel("Select Doctor:");
    private JLabel treatmentLabel = new JLabel("Select Treatment:");
    private JLabel dateAndTimeLabel = new JLabel("Select Date & time:");
    private JLabel creditCardLabel = new JLabel("Credit Card");
    private JLabel validityLabel = new JLabel("Validity:");
    private JLabel cvvLabel = new JLabel("CVV:");

    private JTextField creditCardTextField = new JTextField("");
    private JTextField cvvTextField = new JTextField("");

    private Vector yearVector = new Vector(100);
    private Vector monthVector = new Vector(12) ;

    private JComboBox monthComboBox = new JComboBox(monthVector);
    private JComboBox yearComboBox = new JComboBox(yearVector);

    private JComboBox<Doctor> doctorComboBox = new JComboBox<Doctor>();
    private JComboBox<Treatments> treatmentComboBox = new JComboBox<Treatments>();

    private JPanel dateTimePickerPanel = new JPanel();

    private DatePicker datePicker = new DatePicker();
    private TimePicker timePicker = new TimePicker();


    public SetAnAppointmentView(){
        setLayout(null);

        setLocationAndSize();
        setDate();
        addComponentsToFrame();
        setDateSettings();
        setTimeSettings();

        setBounds(0, 0, 800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {

        treatmentLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        treatmentLabel.setBounds(200,50,120, 30);
        treatmentComboBox.setBounds(330,50,100,30);

        doctorLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        doctorLabel.setBounds(200,100,120, 30);
        doctorComboBox.setBounds(330,100,100,30);

        dateAndTimeLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        dateAndTimeLabel.setBounds(200,160,150, 30);

        dateTimePickerPanel.setBounds(320,160,280,35);
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

        add(cvvLabel);
        add(cvvTextField);

        add(yearComboBox);
        add(monthComboBox);

        add(treatmentLabel);
        add(treatmentComboBox);

        add(doctorLabel);
        add(doctorComboBox);

        add(dateAndTimeLabel);

        dateTimePickerPanel.add(datePicker);
        dateTimePickerPanel.add(timePicker);
        add(dateTimePickerPanel);

        add(backGround);
    }

    private void setDate() {
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

    public void setDoctorList(List<Doctor> values) {
        this.doctorComboBox.removeAllItems();
        values.forEach(doctor -> this.doctorComboBox.addItem(doctor));
    }

    public void setTreatmentList(List<Treatments> values) {
        this.treatmentComboBox.removeAllItems();
        values.forEach(treatment -> this.treatmentComboBox.addItem(treatment));
    }

    private void setDateSettings() {
        DatePickerSettings dateSettings = datePicker.getSettings();
        dateSettings.setVetoPolicy(new VetoPolicy());
        dateSettings.setVisibleTodayButton(false);
        dateSettings.setVisibleNextYearButton(false);
        dateSettings.setVisiblePreviousYearButton(false);
        dateSettings.setFirstDayOfWeek(DayOfWeek.SUNDAY);
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
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

    public int getTreatmentID() {
        return Integer.parseInt(((Treatments)treatmentComboBox.getSelectedItem()).getId());
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

    public boolean haveEmptyTextFields() {
        String datePickerText = datePicker.getText();
        String timePickerText = timePicker.getText();

        String creditCardText = creditCardTextField.getText();

        int monthIndex = monthComboBox.getSelectedIndex();
        int yearIndex = yearComboBox.getSelectedIndex();

        String cvvCardText = cvvTextField.getText();

        return (datePickerText == null || timePickerText == null || creditCardText.equals("") || monthIndex == -1 || yearIndex == -1 || cvvCardText.equals(""));
    }

}


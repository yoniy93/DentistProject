package project.GUI.Clinic.Staff;

import project.Database.Locations;
import project.Entities.Doctor;
import project.Entities.Treatments;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class ClinicStaffInfoView extends JFrame {
    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    private JLabel backGround = new JLabel(imageForBG);
    private JComboBox<Doctor> doctorJComboBox = new JComboBox<Doctor>();
    private JLabel gender=new JLabel();
    private JLabel genderValue=new JLabel();

    private JLabel firstName=new JLabel();
    private JLabel firstNameValue=new JLabel();

    private JLabel lastName=new JLabel();
    private JLabel lastNameValue=new JLabel();

    private JLabel phoneNumber=new JLabel();
    private JLabel phoneNumberValue=new JLabel();

    private JLabel email=new JLabel();
    private JLabel emailValue=new JLabel();


    public ClinicStaffInfoView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Our Doctors: ");
        setBounds(300, 300, 800, 50);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {

    }

    private void addComponentsToFrame() {

        add(backGround);
        add(doctorJComboBox);
        add(firstName);
        add(firstNameValue);
        add(lastName);
        add(lastNameValue);
        add(gender);
        add(genderValue);
        add(phoneNumber);
        add(phoneNumberValue);
        add(email);
        add(emailValue);

    }

    public void setInfoOfDoctor (String firstName , String lastName, String gender , String phoneNumber, String email)
    {
        firstNameValue.setText(firstName);
        lastNameValue.setText(lastName);
        genderValue.setText(gender);
        phoneNumberValue.setText(phoneNumber);
        emailValue.setText(email);
    }

    public void setList(Vector<Doctor> values) {
        this.doctorJComboBox.removeAllItems();
        values.forEach(x -> this.doctorJComboBox.addItem(x));
    }

    public JComboBox<Doctor> getDoctorJComboBox()
    {
        return doctorJComboBox;
    }
}

package project.GUI.View.Clinic;

import project.Database.Locations;
import project.Entities.Doctor;
import project.GUI.View.ExitButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ClinicStaffInfoView extends JFrame {
    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    private JLabel backGround = new JLabel(imageForBG);

    private JComboBox<Doctor> doctorComboBox = new JComboBox<Doctor>();

    private JLabel selectLable = new JLabel("Select Doctor:");

    private JLabel genderLable = new JLabel("Gender:");
    private JLabel genderValue = new JLabel();

    private JLabel firstNameLable = new JLabel("First name:");
    private JLabel firstNameValue = new JLabel();

    private JLabel lastNameLable = new JLabel("Last name:");
    private JLabel lastNameValue = new JLabel();

    private JLabel phoneNumberLable = new JLabel("Phone number:");
    private JLabel phoneNumberValue = new JLabel();

    private JLabel emailLable = new JLabel("Email:");
    private JLabel emailValue = new JLabel();

    private JLabel yeasOfExperienceLable = new JLabel("Yeas of experience:");
    private JLabel yeasOfExperienceValue = new JLabel();

    private JLabel clinicNameLable = new JLabel( "<HTML><U>Doctors Info:</U></HTML>");

    private Font font = new Font("Ariel",Font.BOLD,14);

    private ExitButton exitButton =new ExitButton();

    public ClinicStaffInfoView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        setFont();

        setTitle("Clinic Staff Information");
        setBounds(500, 150, 800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setFont(){
        selectLable .setFont(font);

        firstNameLable.setFont(font);
        firstNameValue.setFont(font);

        lastNameLable.setFont(font);
        lastNameValue.setFont(font);

        emailLable.setFont(font);
        emailValue.setFont(font);

        phoneNumberLable.setFont(font);
        phoneNumberValue.setFont(font);

        genderLable.setFont(font);
        genderValue.setFont(font);

        yeasOfExperienceLable.setFont(font);
        yeasOfExperienceValue.setFont(font);

        clinicNameLable.setFont(new Font("Ariel",Font.BOLD,30));
    }

    private void setLocationAndSize() {
        clinicNameLable.setHorizontalAlignment(SwingConstants.CENTER);
        clinicNameLable.setBounds(300, 10, 200, 80);

        selectLable.setBounds(130,70,200,50);

        doctorComboBox.setBounds(130, 100, 200, 50);

        firstNameLable.setHorizontalAlignment(SwingConstants.LEFT);
        firstNameLable.setOpaque(false);
        firstNameLable.setBounds(400,80,200,30);
        firstNameValue.setBounds(550,80,200,30);
        firstNameValue.setHorizontalAlignment(SwingConstants.CENTER);
        firstNameValue.setBackground(Color.WHITE);
        firstNameValue.setOpaque(true);
        firstNameValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        lastNameLable.setHorizontalAlignment(SwingConstants.LEFT);
        lastNameLable.setOpaque(false);
        lastNameLable.setBounds(400,120, 200,30);
        lastNameValue.setBounds(550,120,200,30);
        lastNameValue.setHorizontalAlignment(SwingConstants.CENTER);
        lastNameValue.setBackground(Color.WHITE);
        lastNameValue.setOpaque(true);
        lastNameValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        emailLable.setHorizontalAlignment(SwingConstants.LEFT);
        emailLable.setOpaque(false);
        emailLable.setBounds(400,160,200,30);
        emailValue.setBounds(550,160,200,30);
        emailValue.setHorizontalAlignment(SwingConstants.CENTER);
        emailValue.setOpaque(true);
        emailValue.setBackground(Color.WHITE);
        emailValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        phoneNumberLable.setHorizontalAlignment(SwingConstants.LEFT);
        phoneNumberLable.setOpaque(false);
        phoneNumberLable.setBounds(400,200,200,30);
        phoneNumberValue.setHorizontalAlignment(SwingConstants.CENTER);
        phoneNumberValue.setBounds(550,200,200,30);
        phoneNumberValue.setBackground(Color.WHITE);
        phoneNumberValue.setOpaque(true);
        phoneNumberValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        genderLable.setHorizontalAlignment(SwingConstants.LEFT);
        genderLable.setOpaque(false);
        genderLable.setBounds(400,240, 200,30);
        genderValue.setBounds(550,240,200,30);
        genderValue.setHorizontalAlignment(SwingConstants.CENTER);
        genderValue.setBackground(Color.WHITE);
        genderValue.setOpaque(true);
        genderValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        yeasOfExperienceLable.setHorizontalAlignment(SwingConstants.LEFT);
        yeasOfExperienceLable.setOpaque(false);
        yeasOfExperienceLable.setBounds(400,280, 200,30);
        yeasOfExperienceValue.setBounds(550,280,200,30);
        yeasOfExperienceValue.setHorizontalAlignment(SwingConstants.CENTER);
        yeasOfExperienceValue.setBackground(Color.WHITE);
        yeasOfExperienceValue.setOpaque(true);
        yeasOfExperienceValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        exitButton.setLocation(650,400,120,30);
        backGround.setBounds(0,0,800,500);
    }

    private void addComponentsToFrame() {
        add(selectLable);
        add(doctorComboBox);
        add(clinicNameLable);
        add(firstNameLable);
        add(firstNameValue);
        add(lastNameLable);
        add(lastNameValue);
        add(genderLable);
        add(genderValue);
        add(phoneNumberLable);
        add(phoneNumberValue);
        add(emailLable);
        add(emailValue);
        add(yeasOfExperienceLable);
        add(yeasOfExperienceValue);
        add(exitButton);
        add(backGround);
    }

    public void setSelectedDoctorInfo() {
        Doctor doctor = (Doctor) doctorComboBox.getSelectedItem();

        if(doctor != null) {
            firstNameValue.setText(doctor.getFirstName());
            lastNameValue.setText(doctor.getLastName());
            emailValue.setText(doctor.getEmail());
            phoneNumberValue.setText(doctor.getPhoneNumber());
            genderValue.setText(doctor.getGender());
            yeasOfExperienceValue.setText(Integer.toString(doctor.getYearsOfExp()));
        }
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorComboBox.removeAllItems();
        doctorList.forEach(doctor -> this.doctorComboBox.addItem(doctor));
        doctorComboBox.setSelectedIndex(-1);
    }

    public void setActions(ActionListener select, ActionListener cancel) {
        doctorComboBox.addActionListener(select);
        exitButton.addActionListener(cancel);
    }

}

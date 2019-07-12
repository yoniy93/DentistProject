package project.GUI.Clinic.Staff;

import project.Database.Locations;
import project.Entities.Doctor;
import project.GUI.General.CancelButton;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClinicStaffInfoView extends JFrame {
    private ImageIcon imageForBG = new ImageIcon(Locations.getImagePath("clinicInfo.png"));
    private JLabel backGround = new JLabel(imageForBG);

    private JComboBox<Doctor> doctorJComboBox = new JComboBox<Doctor>();
    private JLabel gender=new JLabel("Gender:");
    private JLabel genderValue=new JLabel();

    private JLabel firstName=new JLabel("First name:");
    private JLabel firstNameValue=new JLabel();

    private JLabel lastName=new JLabel("Last name:");
    private JLabel lastNameValue=new JLabel();

    private JLabel phoneNumber=new JLabel("Phone number:");
    private JLabel phoneNumberValue=new JLabel();

    private JLabel email=new JLabel("Email:");
    private JLabel emailValue=new JLabel();

    private JLabel yeasOfExperience=new JLabel("Yeas of experience:");
    private JLabel yeasOfExperienceValue=new JLabel();

    private JLabel clinicNameLable = new JLabel( "<HTML><U>Doctors Info:</U></HTML>");


    CancelButton cancelButton =new CancelButton();


    public ClinicStaffInfoView() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        setLablesFont();
        setTitle("Doctors Information");
        setBounds(300, 300, 800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLablesFont(){
        Font font=new Font("Ariel",Font.BOLD,14);
        this.phoneNumber.setFont(font);
        this.email.setFont(font);
        this.yeasOfExperience.setFont(font);
        this.lastName.setFont(font);
        this.firstName.setFont(font);
        this.gender.setFont(font);
        clinicNameLable.setFont(new Font("Ariel",Font.BOLD,30));


    }

    private void setLocationAndSize() {
        clinicNameLable.setHorizontalAlignment(SwingConstants.CENTER);
        clinicNameLable.setBounds(300, 10, 200, 80);

        doctorJComboBox.setBounds(40, 100, 200, 50);

        firstName.setHorizontalAlignment(SwingConstants.LEFT);
        firstName.setOpaque(false);
        firstName.setBounds(400,80,200,30);
        firstNameValue.setBounds(550,80,200,30);
        firstNameValue.setHorizontalAlignment(SwingConstants.CENTER);
        firstNameValue.setBackground(Color.lightGray);
        firstNameValue.setOpaque(true);
        firstNameValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        lastName.setHorizontalAlignment(SwingConstants.LEFT);
        lastName.setOpaque(false);
        lastName.setBounds(400,120, 200,30);
        lastNameValue.setBounds(550,120,200,30);
        lastNameValue.setHorizontalAlignment(SwingConstants.CENTER);
        lastNameValue.setBackground(Color.lightGray);
        lastNameValue.setOpaque(true);
        lastNameValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        email.setHorizontalAlignment(SwingConstants.LEFT);
        email.setOpaque(false);
        email.setBounds(400,160,200,30);
        emailValue.setBounds(550,160,200,30);
        emailValue.setHorizontalAlignment(SwingConstants.CENTER);
        emailValue.setOpaque(true);
        emailValue.setBackground(Color.lightGray);
        emailValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        phoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
        phoneNumber.setOpaque(false);
        phoneNumber.setBounds(400,200,200,30);
        phoneNumberValue.setHorizontalAlignment(SwingConstants.CENTER);
        phoneNumberValue.setBounds(550,200,200,30);
        phoneNumberValue.setBackground(Color.lightGray);
        phoneNumberValue.setOpaque(true);
        phoneNumberValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        gender.setHorizontalAlignment(SwingConstants.LEFT);
        gender.setOpaque(false);
        gender.setBounds(400,240, 200,30);
        genderValue.setBounds(550,240,200,30);
        genderValue.setHorizontalAlignment(SwingConstants.CENTER);
        genderValue.setBackground(Color.lightGray);
        genderValue.setOpaque(true);
        genderValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        yeasOfExperience.setHorizontalAlignment(SwingConstants.LEFT);
        yeasOfExperience.setOpaque(false);
        yeasOfExperience.setBounds(400,280, 200,30);
        yeasOfExperienceValue.setBounds(550,280,200,30);
        yeasOfExperienceValue.setHorizontalAlignment(SwingConstants.CENTER);
        yeasOfExperienceValue.setBackground(Color.lightGray);
        yeasOfExperienceValue.setOpaque(true);
        yeasOfExperienceValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        cancelButton.setLocation(550,400,80,30);
        backGround.setBounds(0,0,800,500);


    }

    private void addComponentsToFrame() {

        add(doctorJComboBox);
        add(clinicNameLable);
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
        add(yeasOfExperience);
        add(yeasOfExperienceValue);
        add(cancelButton);
        add(backGround);


    }

    public void setInfoOfDoctor (String firstName , String lastName, String gender , String phoneNumber, String email, int yearsOfEx) {
        Font font=new Font("Ariel",Font.PLAIN,14);

        firstNameValue.setFont(font);
        firstNameValue.setText(firstName);

        lastNameValue.setFont(font);
        lastNameValue.setText(lastName);

        genderValue.setFont(font);
        genderValue.setText(gender);

        phoneNumberValue.setFont(font);
        phoneNumberValue.setText(phoneNumber);

        emailValue.setFont(font);
        emailValue.setText(email);

        yeasOfExperienceValue.setFont(font);
        yeasOfExperienceValue.setText(Integer.toString(yearsOfEx));
    }

    public JComboBox getDoctorJComboBox() {
        return doctorJComboBox;
    }

    public void setDoctorList(List<Doctor> values) {
        this.doctorJComboBox.removeAllItems();
        values.forEach(x -> this.doctorJComboBox.addItem(x));
    }

    public void setVisible() {
        setVisible(true);
    }
}

package project.GUI.Patient.General;

import project.GUI.User.UserView;
import javax.swing.*;
import java.awt.event.ActionListener;

public class PatientView extends UserView {

    private JButton setAnAppointment = new JButton("Set An Appointment ");
    private JButton viewTreatments = new JButton("View Treatments");
    private JButton viewAllAppointments=new JButton("View All Appointments");

    public PatientView() {
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Welcome Patient");
    }

    private void setLocationAndSize() {
        viewAllAppointments.setBounds(100,80,230,50);
        viewAllAppointments.setFont(getButtonFont());
        setAnAppointment.setBounds(100, 220, 230, 50);
        setAnAppointment.setFont(getButtonFont());
        viewTreatments.setBounds(100,150,230,50);
        viewTreatments.setFont(getButtonFont());
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame(){
        add(setAnAppointment);
        add(viewAllAppointments);
        add(viewTreatments);
        add(getBackGround());
    }

    public void setActions(ActionListener edit, ActionListener set, ActionListener viewTreatments, ActionListener viewAppointments){
        editPersonalDetails.addActionListener((edit));
        setAnAppointment.addActionListener(set);
        this.viewTreatments.addActionListener(viewTreatments);
        this.viewAllAppointments.addActionListener(viewAppointments);
    }
}

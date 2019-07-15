package project.GUI.Patient.General;

import project.GUI.User.UserView;
import javax.swing.*;
import java.awt.event.ActionListener;

public class PatientView extends UserView {

    private JButton setAnAppointment = new JButton("Set An Appointment ");
    private JButton viewTreatments = new JButton("View Treatments");

    public PatientView() {
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Welcome Patient");
    }

    private void setLocationAndSize() {
        setAnAppointment.setBounds(100, 220, 230, 50);
        setAnAppointment.setFont(getButtonFont());
        viewTreatments.setBounds(100,150,230,50);
        viewTreatments.setFont(getButtonFont());
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame(){
        add(setAnAppointment);
        add(viewTreatments);
        add(getBackGround());
    }

    public void setActions(ActionListener edit, ActionListener set, ActionListener view){
        editPersonalDetails.addActionListener((edit));
        setAnAppointment.addActionListener(set);
        viewTreatments.addActionListener(view);
    }
}

package project.GUI.Patient.General;

import project.GUI.General.PersonView;
import javax.swing.*;

public class PatientView extends PersonView {

    private JButton setAnAppointment = new JButton("Set An Appointment ");
    private JButton viewTreatments = new JButton("View Treatments");

    public PatientView()
    {
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("WELCOME PATIENT");
    }

    private void setLocationAndSize(){
        setAnAppointment.setBounds(150, 220, 150, 30);
        viewTreatments.setBounds(150,430,150,30);
        getBackGround().setBounds(0,0,800,600);
    }

    private void addComponentsToFrame(){
        add(setAnAppointment);
        add(viewTreatments);
        add(getBackGround());
    }

    public JButton getSetAnAppointment() {
        return setAnAppointment;
    }

    public JButton getViewTreatments() {
        return viewTreatments;
    }
}

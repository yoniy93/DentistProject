package project.GUI.Patient.General;

import project.GUI.General.PersonView;
import javax.swing.*;
import java.awt.*;

public class PatientView extends PersonView {

    private JButton setAnAppointment = new JButton("Set An Appointment ");
    private JButton viewTreatments = new JButton("View Treatments");

    public PatientView()
    {
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Welcome Patient");
    }

    private void setLocationAndSize() {
        setAnAppointment.setBounds(100, 220, 230, 50);
        setAnAppointment.setFont(this.getButtonFont());
        viewTreatments.setBounds(100,150,230,50);
        viewTreatments.setFont(this.getButtonFont());
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

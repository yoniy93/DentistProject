package project.GUI.Patient;
import project.GUI.PersonView;

import javax.swing.*;

public class PatientView extends PersonView {

    private JButton setAnAppointment=new JButton("Set An Appointment ");

    public PatientView()
    {
        setLayout(null);
        setLocationAndSize();
        addComponentsToContainer();
        addPatientToContainer();
        setPatient();

        setTitle("WELCOME PATIENT");
        setBounds(500, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    void addPatientToContainer()
    {
        add(setAnAppointment);

    }
    void setPatient()
    {
        setAnAppointment.setBounds(150, 220, 150, 30);
    }
    public JButton getSetAnAppointment() {
        return setAnAppointment;
    }


}

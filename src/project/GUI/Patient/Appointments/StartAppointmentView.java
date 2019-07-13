package project.GUI.Patient.Appointments;

import project.Entities.Patient;

public class StartAppointmentView {

    public StartAppointmentView(Patient patient){
        SetAnAppointmentModel AppointmentM = new SetAnAppointmentModel(patient);
        SetAnAppointmentView AppointmentV = new SetAnAppointmentView();
        new SetAnAppointmentController(AppointmentV, AppointmentM);
    }
}

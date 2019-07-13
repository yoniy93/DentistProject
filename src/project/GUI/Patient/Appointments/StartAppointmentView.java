package project.GUI.Patient.Appointments;

public class StartAppointmentView {

    public StartAppointmentView(){
        SetAnAppointmentModel AppointmentM = new SetAnAppointmentModel();
        SetAnAppointmentView AppointmentV = new SetAnAppointmentView();
        new SetAnAppointmentController(AppointmentV, AppointmentM);
    }
}

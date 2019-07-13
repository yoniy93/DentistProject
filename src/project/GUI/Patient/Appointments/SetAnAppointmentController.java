package project.GUI.Patient.Appointments;

public class SetAnAppointmentController {

    SetAnAppointmentView setAnAppointmentView;
    SetAnAppointmentModel setAnAppointmentModel;


   public SetAnAppointmentController()
   {
       setAnAppointmentModel = new SetAnAppointmentModel();
       setAnAppointmentView = new SetAnAppointmentView();

       addViewActionListeners();
       setAnAppointmentView.setDoctorList (setAnAppointmentModel.getDoctorList());
       setAnAppointmentView.setVisible(true);
   }

    private void addViewActionListeners() {
        setAnAppointmentView.setActions(e->selectDoctorAction(), e->insertAppointmentAction(), e->cancelAction());
    }

    public void selectDoctorAction(){
        setAnAppointmentView.setDateListener(setAnAppointmentView.getDoctorID());
    }

    public void insertAppointmentAction(){

    }

    public void cancelAction(){

    }


}

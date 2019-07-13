package project.GUI.Patient.Appointments;

import javax.swing.*;

public class SetAnAppointmentController {

    SetAnAppointmentView setAnAppointmentView;
    SetAnAppointmentModel setAnAppointmentModel;

   public SetAnAppointmentController(SetAnAppointmentView appointmentV, SetAnAppointmentModel appointmentM)
   {
       setAnAppointmentModel = appointmentM;
       setAnAppointmentView = appointmentV;

       addViewActionListeners();
       setAnAppointmentView.setDoctorList (setAnAppointmentModel.getDoctorList());
       setAnAppointmentView.setVisible(true);
   }

    private void addViewActionListeners() {
        setAnAppointmentView.setActions(e->selectDoctorAction(), e->insertAppointmentAction(), e->cancelAction());
    }

    public void selectDoctorAction(){
        setAnAppointmentView.setDateListener(setAnAppointmentView.getDoctorID());
        setAnAppointmentView.clearDateAndTime();
    }

    public void insertAppointmentAction(){

       if(setAnAppointmentView.haveEmptyTextFields()) {
           JOptionPane.showMessageDialog(setAnAppointmentView, "Some Information haven't been field");
       }
       else
           {
               JOptionPane.showMessageDialog(setAnAppointmentView, "Everything is Correct");
           }


    }

    public void cancelAction(){

    }


}

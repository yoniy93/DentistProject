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
       setAnAppointmentView.setTreatmentList (setAnAppointmentModel.getTreatmentList());
       setAnAppointmentView.setVisible(true);
   }

    private void addViewActionListeners() {
        setAnAppointmentView.setActions(e->selectDoctorAction(), e->insertAppointmentAction(), e->setAnAppointmentView.dispose());
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
               int appointmentID = setAnAppointmentModel.getLastAppointmentID() + 1;
               int treatmentID = setAnAppointmentView.getTreatmentID();
               String date = setAnAppointmentView.getDate();
               String time = setAnAppointmentView.getTime();
               String doctorid = setAnAppointmentView.getDoctorID();

               setAnAppointmentModel.insertAppointment(appointmentID, treatmentID, date, time, doctorid);

               JOptionPane.showMessageDialog(setAnAppointmentView, "Appointment has been Schedule");
               setAnAppointmentView.dispose();
           }
    }
}

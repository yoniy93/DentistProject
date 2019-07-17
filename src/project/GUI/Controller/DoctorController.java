package project.GUI.Controller;

import project.Entities.Appointment;
import project.Entities.Doctor;
import project.GUI.Model.DoctorModel;
import project.GUI.View.Admin.MessageWindow;
import project.GUI.View.Doctor.*;
import javax.swing.*;
import java.util.List;

public class DoctorController extends UserController {


    private DoctorModel doctorModel;
    //all windows related to Doctor user
    private DoctorView doctorView;
    private PersonalDetailsViewDoctor personalDetailsViewDoctor;
    private PatientsHistoryView patientsHistoryView;

    public DoctorController(DoctorModel doctorM,DoctorView doctorV) {
        doctorView = doctorV;
        doctorModel = doctorM;

        addViewActionListeners();
    }

    //add action listener to Doctor main window
    private void addViewActionListeners() {
        addActionsToPerson(doctorView);
        doctorView.setActions(e->openEditDetailsView(), e->openPatientHistoryView());
    }

    //===========================================================================

    //open new sub-window of edit personal details and add action listener
    private void openEditDetailsView() {
        personalDetailsViewDoctor = new PersonalDetailsViewDoctor();
        SetTextFieldsCurrentValues();
        personalDetailsViewDoctor.setActions(e->editAction(), e->personalDetailsViewDoctor.dispose());
    }

    //initialize value of editable fields of window
    private void SetTextFieldsCurrentValues() {
        personalDetailsViewDoctor.initializeFields(doctorModel.getDoctor());
    }

    //action of update details
    private void editAction() {
        if(personalDetailsViewDoctor.isAllFieldsFilled()&&personalDetailsViewDoctor.isYearsOfExFilled()) {
            Doctor doctor = doctorModel.getDoctor();

            //set all new values
            doctor.setFirstName(personalDetailsViewDoctor.getFirstNameText());
            doctor.setLastName(personalDetailsViewDoctor.getLastNameText());
            doctor.setEmail(personalDetailsViewDoctor.getEmailText());
            doctor.setPassword(personalDetailsViewDoctor.getPasswordText());
            doctor.setYearsOfEx(Integer.parseInt(personalDetailsViewDoctor.getYearsOfExpText()));
            doctor.setPhoneNumber(personalDetailsViewDoctor.getPhoneNumberText());

            doctorModel.UpdateDoctor(doctor);//update fields of current doctor in DB

            new MessageWindow(personalDetailsViewDoctor, "Details Updated");
            personalDetailsViewDoctor.dispose();
        }
        else new MessageWindow(personalDetailsViewDoctor, "Error: please fill all fields");
    }

    //===========================================================================

    private void openPatientHistoryView() {
        patientsHistoryView = new PatientsHistoryView();
        patientsHistoryView.setPatientList(doctorModel.getAllPatientsIDList());
        patientsHistoryView.setActions(e->updateSelectedPatientTreatmentHistory(), e->patientsHistoryView.dispose());
    }

    private void updateSelectedPatientTreatmentHistory() {
        List<Appointment> appointmentsList = doctorModel.getPatientAppointmentsList(patientsHistoryView.getSelectedID());

        patientsHistoryView.updatePatientHistoryTable();

        for (Appointment appointment : appointmentsList) {

            patientsHistoryView.addRowToAppointmentsTable(
                    doctorModel.getTreatmentName(appointment.getTreatmentID()),
                    appointment.getTreatmentDate(),
                    appointment.getTreatmentTime(),
                    doctorModel.getDoctorName(appointment.getDoctorId()));
        }
        patientsHistoryView.setColWidth();
    }

    //===========================================================================
}
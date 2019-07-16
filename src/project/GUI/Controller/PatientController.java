package project.GUI.Controller;

import project.Entities.Appointment;
import project.Entities.Patient;
import project.Entities.Treatments;

import project.GUI.Model.PatientModel;
import project.GUI.View.Patient.*;

import javax.swing.*;
import java.util.List;

public class PatientController extends UserController {

    private PatientModel patientModel;

    //all windows related to patient
    private PatientView patientView;
    private SetAnAppointmentView setAnAppointmentView;
    private PersonalDetailsViewPatient pDetailsView;
    private TreatmentsPricesView treatmentsPricesView;
    private PatientAppointmentsView patientAppointmentsView;

    public PatientController(PatientModel patientM, PatientView patientV) {
        patientView = patientV;
        patientModel = patientM;

        addViewActionListeners();
    }

    //add action listener to main patient window
    private void addViewActionListeners() {
        addActionsToPerson(patientView);
        patientView.setActions(e->openEditDetailsActionView(), e->openSetAnAppointmentView(),e->openTreatmentsPriceView(),e-> openPatientAppointmentsView());
    }

    //===========================================================================

    //open new sub-window of view all appointments and add action listener
    private void openPatientAppointmentsView() {
        patientAppointmentsView = new PatientAppointmentsView();
        patientAppointmentsView.setActions(e->patientAppointmentsView.dispose());
        updateSelectedPatientTreatmentHistory();
    }
    //function that updated the table of appointments according to the DB
    private void updateSelectedPatientTreatmentHistory() {
        List<Appointment> appointmentsList = patientModel.getPatientAppointmentsList();

        for (Appointment appointment : appointmentsList) {
            patientAppointmentsView.addRowToAppointmentsTable(
                    patientModel.getTreatmentName(appointment.getTreatmentID()),
                    appointment.getTreatmentDate(),
                    appointment.getTreatmentTime(),
                    patientModel.getDoctorName(appointment.getDoctorId()));
        }
    }

    //===========================================================================
    //open new sub-window of edit personal details and add action listener
    private void openEditDetailsActionView() {
        pDetailsView =  new PersonalDetailsViewPatient();
        pDetailsView.setActions(e->editDetailsAction(), e-> pDetailsView.dispose());
        pDetailsView.initializeFields(patientModel.getPatient());
    }
    //action of update personal details
    private void editDetailsAction() {
        if(pDetailsView.isHeightAndWeightFilled()&&pDetailsView.isAllFieldsFilled()) {
            Patient patient = patientModel.getPatient();

            //set all updated fields
            patient.setFirstName(pDetailsView.getFirstNameText());
            patient.setLastName(pDetailsView.getLastNameText());
            patient.setEmail(pDetailsView.getEmailText());
            patient.setPassword(pDetailsView.getPasswordText());
            patient.setHeight(Integer.parseInt(pDetailsView.getHeightText()));
            patient.setWeight(Double.parseDouble(pDetailsView.getWeightText()));
            patient.setPhoneNumber(pDetailsView.getPhoneNumberText());

            patientModel.UpdatePatient(patient);//update information in DB

            JOptionPane.showMessageDialog(pDetailsView, "Details Updated");

            pDetailsView.dispose();
        }
        JOptionPane.showMessageDialog(pDetailsView, "Error: please fill all fields");
    }

    //===========================================================================
    //new sub-window of set new appointment and add action listener
    private void openSetAnAppointmentView() {
        setAnAppointmentView = new SetAnAppointmentView();

        setAnAppointmentView.setDoctorList (patientModel.getAllDoctorList());
        setAnAppointmentView.setTreatmentList (patientModel.getAllTreatmentsList());

        setAnAppointmentView.setVisible(true);
        setAnAppointmentView.setActions(e->selectDoctorAction(), e->insertAppointmentAction(), e->setAnAppointmentView.dispose());
    }
    // action of select doctor and find the available appointments
    private void selectDoctorAction(){
        setAnAppointmentView.setDateListener(setAnAppointmentView.getDoctorID());
        setAnAppointmentView.clearDateAndTime();
    }
    //insert new appointment details to DB
    private void insertAppointmentAction(){
        if(setAnAppointmentView.haveEmptyTextFields()) {//check if all fields are filled
            JOptionPane.showMessageDialog(setAnAppointmentView, "Some Information Haven't Been Field Yet");
        }
        else {
            int appointmentID = patientModel.getLastAppointmentID() + 1;
            int treatmentID = setAnAppointmentView.getTreatmentID();
            String date = setAnAppointmentView.getDate();
            String time = setAnAppointmentView.getTime();
            String doctorId = setAnAppointmentView.getDoctorID();

            patientModel.insertAppointment(appointmentID, treatmentID, date, time, doctorId);//insert new appointment to DB

            JOptionPane.showMessageDialog(setAnAppointmentView, "Appointment has been Schedule");
            setAnAppointmentView.dispose();
        }
    }

    //===========================================================================
    //new sub-window of view of all treatments that the clinic offers and add action listener
    private void openTreatmentsPriceView(){
        treatmentsPricesView = new TreatmentsPricesView();
        treatmentsPricesView.setTreatmentList(patientModel.getAllTreatmentsList());//get all treatments
        treatmentsPricesView.setActions(e->treatmentListAction(),e->treatmentsPricesView.dispose());
    }
    //update the details in the window according to the treatment that picked
    private void treatmentListAction() {
        Treatments treatment = treatmentsPricesView.getTreatment();

        if (treatment != null) {
            treatmentsPricesView.setTreatmentInfo(Double.toString(treatment.getPrice()),Integer.toString(treatment.getDuration()),"None");
        }
    }

    //===========================================================================
}

package project.GUI.Patient.General;

import project.Entities.Patient;
import project.Entities.Treatments;
import project.GUI.General.PersonController;
import project.GUI.Patient.Appointments.SetAnAppointmentView;
import project.GUI.Patient.PersonalDetails.PersonalDetailsViewPatient;
import project.GUI.Patient.Treatments.TreatmentsPricesView;

import javax.swing.*;

public class PatientController extends PersonController{

    private PatientModel patientModel;
    private PatientView patientView;
    private SetAnAppointmentView setAnAppointmentView;
    private PersonalDetailsViewPatient pDetailsView;
    TreatmentsPricesView treatmentsPricesView;


    public PatientController(PatientModel patientM, PatientView patientV) {
        patientView = patientV;
        patientModel = patientM;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        addActionsToPerson(patientView);
        patientView.setActions(e->editDetailsAction(), e->setAnAppointmentAction(),e->viewTreatmentsAction());
    }


    private void editDetailsAction() {
        pDetailsView =  new PersonalDetailsViewPatient();
        pDetailsView.setActions(e->editAction(), e-> pDetailsView.dispose());
        SetTextFieldsCurrentValues();
    }

    private void SetTextFieldsCurrentValues() {
        pDetailsView.initializeFields(patientModel.getPatient());
    }

    private void editAction() {
        Patient patient = patientModel.getPatient();

        patient.setFirstName(pDetailsView.getFirstNameText());
        patient.setLastName(pDetailsView.getLastNameText());
        patient.setEmail(pDetailsView.getEmailText());
        patient.setPassword(pDetailsView.getPasswordText());
        patient.setHeight(Integer.parseInt(pDetailsView.getHeightText()));
        patient.setWeight(Double.parseDouble(pDetailsView.getWeightText()));
        patient.setPhoneNumber(pDetailsView.getPhoneNumberText());

        patientModel.UpdatePatient(patient);

        JOptionPane.showMessageDialog( pDetailsView,  "Details Updated");

        pDetailsView.dispose();
    }


    private void setAnAppointmentAction() {
        this.setAnAppointmentView = new SetAnAppointmentView();

        setAnAppointmentView.setDoctorList (patientModel.getDoctorList());
        setAnAppointmentView.setTreatmentList (patientModel.getTreatmentList());

        setAnAppointmentView.setVisible(true);
        setAnAppointmentView.setActions(e->selectDoctorAction(), e->insertAppointmentAction(), e->setAnAppointmentView.dispose());
    }

    public void selectDoctorAction(){
        setAnAppointmentView.setDateListener(setAnAppointmentView.getDoctorID());
        setAnAppointmentView.clearDateAndTime();
    }

    public void insertAppointmentAction(){
        if(setAnAppointmentView.haveEmptyTextFields()) {
            JOptionPane.showMessageDialog(setAnAppointmentView, "Some Information Haven't Been Field Yet");
        }
        else {
            int appointmentID = patientModel.getLastAppointmentID() + 1;
            int treatmentID = setAnAppointmentView.getTreatmentID();
            String date = setAnAppointmentView.getDate();
            String time = setAnAppointmentView.getTime();
            String doctorId = setAnAppointmentView.getDoctorID();

            patientModel.insertAppointment(appointmentID, treatmentID, date, time, doctorId);

            JOptionPane.showMessageDialog(setAnAppointmentView, "Appointment has been Schedule");
            setAnAppointmentView.dispose();
        }
    }


    private void viewTreatmentsAction(){
        treatmentsPricesView = new TreatmentsPricesView();
        treatmentsPricesView.setTreatmentList(patientModel.getAllTreatments());
        treatmentsPricesView.setActions(e->treatmentListAction(),e->treatmentsPricesView.dispose());
    }

    private void treatmentListAction() {
        Treatments treatment = treatmentsPricesView.getTreatment();

        if (treatment != null) {
            treatmentsPricesView.setTreatmentInfo(Double.toString(treatment.getPrice()),Integer.toString(treatment.getDuration()),"None");
        }
    }
}

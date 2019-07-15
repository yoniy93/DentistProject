package project.GUI.Controller;

import project.Entities.Doctor;
import project.GUI.Model.DoctorModel;
import project.GUI.View.Doctor.PersonalDetailsViewDoctor;
import project.GUI.Doctor.PatientsHistory.PatientsHistoryView;
import project.GUI.View.Doctor.DoctorView;

import javax.swing.*;

public class DoctorController extends UserController {

    private DoctorModel doctorModel;
    private DoctorView doctorView;
    private PersonalDetailsViewDoctor personalDetailsViewDoctor;
    private PatientsHistoryView patientsHistoryView;

    public DoctorController(DoctorModel doctorM,DoctorView doctorV) {
        doctorView = doctorV;
        doctorModel = doctorM;

        addViewActionListeners();
    }

    private void addViewActionListeners() {
        addActionsToPerson(doctorView);
        doctorView.setActions(e->openEditDetailsView(), e->showHistoryAction());
    }

    private void openEditDetailsView() {
        personalDetailsViewDoctor = new PersonalDetailsViewDoctor();
        SetTextFieldsCurrentValues();
        personalDetailsViewDoctor.setActions(e->editAction(), e->personalDetailsViewDoctor.dispose());
    }

    private void SetTextFieldsCurrentValues() {
        personalDetailsViewDoctor.initializeFields(doctorModel.getDoctor());
    }

    private void editAction() {

        Doctor doctor = doctorModel.getDoctor();

        doctor.setFirstName(personalDetailsViewDoctor.getFirstNameText());
        doctor.setLastName(personalDetailsViewDoctor.getLastNameText());
        doctor.setEmail(personalDetailsViewDoctor.getEmailText());
        doctor.setPassword(personalDetailsViewDoctor.getPasswordText());
        doctor.setYearsOfEx(Integer.parseInt(personalDetailsViewDoctor.getYearsOfExpText()));
        doctor.setPhoneNumber(personalDetailsViewDoctor.getPhoneNumberText());

        doctorModel.UpdateDoctor(doctor);
        JOptionPane.showMessageDialog( personalDetailsViewDoctor,  "Details Updated");
        personalDetailsViewDoctor.dispose();
    }

    private void showHistoryAction() {
        patientsHistoryView = new PatientsHistoryView();
    }
}
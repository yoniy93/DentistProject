package project.GUI.Clinic.Staff;

import project.Entities.Doctor;
import project.Entities.Treatments;

import java.util.ArrayList;

public class ClinicStaffInfoController
{

    ClinicStaffInfoView clinicStaffInfoView;
    ClinicStaffInfoModel clinicStaffInfoModel;

    public ClinicStaffInfoController(ClinicStaffInfoModel clinicStaffInfoModel,ClinicStaffInfoView clinicStaffInfoView)
    {
        this.clinicStaffInfoModel=clinicStaffInfoModel;
        this.clinicStaffInfoView=clinicStaffInfoView;

        initController();
    }


    private void initController()
    {

        clinicStaffInfoView.setList(clinicStaffInfoModel.createDoctorsTable());
        clinicStaffInfoView.getDoctorJComboBox().addActionListener(e->setValues());
    }

    private void setValues()
    {
        Doctor doctor = (Doctor)clinicStaffInfoView.getDoctorJComboBox().getSelectedItem();

        if (doctor != null) {
            clinicStaffInfoView.setInfoOfDoctor(doctor.getFirstName(),doctor.getLastName(),doctor.getGender(),doctor.getPhoneNumber(),doctor.getEmail());
        }
    }
}

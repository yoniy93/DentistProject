package project.GUI.Clinic.Staff;

import project.Entities.Doctor;
import project.Entities.Treatments;

import java.util.ArrayList;

public class ClinicStaffInfoController
{

    ClinicStaffInfoView clinicStaffInfoView;
    ClinicStaffInfoModel clinicStaffInfoModel;

    public ClinicStaffInfoController()
    {
        clinicStaffInfoModel=new ClinicStaffInfoModel();
        clinicStaffInfoView=new ClinicStaffInfoView();
        clinicStaffInfoView.getDoctorJComboBox().setVisible(true);
        addViewActionListeners();
        clinicStaffInfoView.setDoctorList (clinicStaffInfoModel.getDoctorList());
        clinicStaffInfoView.setVisible();
    }

    private void addViewActionListeners() {
        this.clinicStaffInfoView.getDoctorJComboBox().addActionListener(e->doctorlistAction());
    }

    private void doctorlistAction() {
        Doctor d = (Doctor) this.clinicStaffInfoView.getDoctorJComboBox().getSelectedItem();

        if (d != null) {
            clinicStaffInfoView.setInfoOfDoctor(d.getFirstName(),
                                                d.getLastName(),
                                                d.getGender(),
                                                d.getPhoneNumber(),
                                                d.getEmail(),
                                                d.getYearsOfEx()) ;
        }
    }

}

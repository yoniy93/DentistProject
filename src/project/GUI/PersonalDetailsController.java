package project.GUI;

import project.Entities.Doctor;

public class PersonalDetailsController {

    private PersonalDetailsView pDetailsView;
    private PersonalDetailsModel pDetailsModel;

    public PersonalDetailsController (PersonalDetailsModel pDM , PersonalDetailsView pDV)
    {
        this.pDetailsModel=pDM;
        this.pDetailsView=pDV;

        initController();
    }

    private void initController()
    {
        pDetailsView.getEdit().addActionListener(e->EditAction());


    }

    public void EditAction()
    {
        Doctor doctor=new Doctor();
        doctor.setFirstName(pDetailsView.getFirstnameText().toString());
        doctor.setLastName(pDetailsView.getLastnameText().toString());
        doctor.setEmail(pDetailsView.getEmailText().toString());
        doctor.setId(pDetailsView.getIdText().toString());
        doctor.setPassword(pDetailsView.getPswdText().toString());

        /*NOT FINISHED*/

    }
}




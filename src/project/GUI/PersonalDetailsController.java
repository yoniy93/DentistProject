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
        pDetailsView.getEditButton().addActionListener(e->EditAction());

    }

    public void EditAction()
    {
        Doctor doctor= new Doctor();
        doctor.setFirstName(pDetailsView.getFirstnameTextField().getText());
        doctor.setLastName(pDetailsView.getLastnameTextField().getText());
        doctor.setEmail(pDetailsView.getEmailTextField().getText());
        doctor.setId(pDetailsView.getIdTextField().getText());
        doctor.setPassword(new String(pDetailsView.getPasswordField().getPassword()));

        /*NOT FINISHED*/

    }
}




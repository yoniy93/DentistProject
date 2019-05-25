package project.GUI;

import project.Entities.Doctor;
import project.Logic.DatabaseHandler;

public class PersonalDetailsController {

    private PersonalDetailsView pDetailsView;
    private PersonalDetailsModel pDetailsModel;

    public PersonalDetailsController (PersonalDetailsModel pDM , PersonalDetailsView pDV) {
        pDetailsModel=pDM;
        pDetailsView=pDV;

        initController();
    }

    private void initController() {
        pDetailsView.getEditButton().addActionListener(e->EditAction());

    }

    public String getPassword(){
        return new String(pDetailsView.getPasswordField().getPassword());
    }

    public int getYearsOfExp(){
       return Integer.parseInt(pDetailsView.getYearsOfExpTextField().getText());
    }

    public void EditAction() {



    }
}




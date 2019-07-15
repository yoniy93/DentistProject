package project.GUI.Controller;

import project.Entities.Admin;
import project.GUI.Model.AdminModel;
import project.GUI.View.Admin.*;
import project.GUI.General.MessageWindow;
import project.GUI.General.PersonalDetailsView;

import javax.swing.*;

public class AdminController extends UserController {

    private AdminModel adminModel;
    private AdminView adminView;
    private PersonalDetailsView personalDetailsView;
    private AddTreatmentsView addTreatmentsView;
    private RegisterView registerView;
    private UnRegisterView unRegisterView;

    public AdminController(AdminModel adminM, AdminView adminV) {
        adminModel = adminM;
        adminView = adminV;

        addViewActionListeners();
    }

    private void addViewActionListeners () {
        addActionsToPerson(adminView);
        adminView.setActions(e->openEditPersonalDetailsView(), e->openRegisterView(), e->openUnregisterView(), e->openAddTreatmentsView());
    }

    //===========================================================================

    private void openAddTreatmentsView() {
        addTreatmentsView=new AddTreatmentsView();
        addTreatmentsView.setActions(e-> addTreatmentAction(), e->addTreatmentsView.dispose());
    }

    public void addTreatmentAction() {
        String msg_received;
        if (addTreatmentsView.addAction()) {
            msg_received = adminModel.InsertTreatment((adminModel.getAvailableId())+1,
                    addTreatmentsView.getTreatmentNameText(),
                    Integer.parseInt(addTreatmentsView.getTreatmentDurationText()),
                    Double.parseDouble(addTreatmentsView.getTreatmentPriceText()));
            if (msg_received.equals("Sucssesfuly")) {
                new MessageWindow(addTreatmentsView, "New Treatment Added successfully");
                addTreatmentsView.dispose();

            } else new MessageWindow(addTreatmentsView, "ID IS ALREADY EXISTS IN OUR SYSTEM");
        } else {
            new MessageWindow(addTreatmentsView, "Error: please fill all fields");
        }

    }

    //===========================================================================

    private void openRegisterView() {
        registerView=new RegisterView();
        registerView.setActions(e->registerUserAction(), e->setVisibleForDoctor(), e->setVisibleForPatient(), e->registerView.dispose());
    }

    public void registerUserAction() {
        String msg_recieved="";
        if(registerView.allFieldsFilled())
        {
            if(registerView.isPatientSelected())
            {
                msg_recieved=adminModel.insertForPatient(registerView.getIdText(),registerView.getPasswordText(),
                        registerView.getFirstNameText(),registerView.getLastNameText(),
                        registerView.getEmailText(), Double.parseDouble(registerView.getWeightText()),
                        Integer.parseInt(registerView.getHeightText()),
                        registerView.getDateOfBirthText(),registerView.getGender(),registerView.getPhoneNumberText());
            }

            else if(registerView.isDoctorSelected())
            {
                msg_recieved=adminModel.insertForDoctor(registerView.getIdText(),registerView.getPasswordText(),
                        registerView.getFirstNameText(),registerView.getLastNameText(),
                        registerView.getEmailText(),registerView.getDateOfBirthText(),
                        registerView.getGender(),Integer.parseInt(registerView.getYearsOfExText()),registerView.getPhoneNumberText());
            }

            if (msg_recieved.equals("Sucssesfuly")) {
                new MessageWindow(registerView, "New user created successfully");
                registerView.dispose();
            }
            else new MessageWindow(registerView, "User already exists");


        }
        else
            new MessageWindow(registerView,"Error: please fill all fields");
    }

    public void setVisibleForDoctor()
    {
        registerView.setVisibleDoctor();
    }

    public void setVisibleForPatient()
    {
        registerView.setVisiblePatient();
    }

    //===========================================================================

    private void openUnregisterView() {
        unRegisterView = new UnRegisterView();
        unRegisterView.setActions(e->unRegisterAction(),e->unRegisterView.dispose());
    }

    public void unRegisterAction() {
        String msg_recived;
        String id = unRegisterView.getIdTextField();
        if (!adminModel.isUserExists(id))
            new MessageWindow(unRegisterView, "User doesnt exist");
        else {
            if (id.equals("1"))
                new MessageWindow(unRegisterView, "Cannot delete Admin user");
            else {
                msg_recived = adminModel.deleteUser(id);
                if (msg_recived.equals("Sucssesfuly")) {
                    new MessageWindow(unRegisterView, "User has been deleted successfully");
                    unRegisterView.dispose();
                } else new MessageWindow(unRegisterView, msg_recived);
            }
        }
    }

    //===========================================================================

    private void openEditPersonalDetailsView() {
        personalDetailsView=new PersonalDetailsView();
        personalDetailsView.setActions(e->editAction(), e-> personalDetailsView.dispose());
        personalDetailsView.initializeUserFields(adminModel.getAdmin());
    }

    private void editAction() {
        Admin admin = adminModel.getAdmin();

        admin.setFirstName(personalDetailsView.getFirstNameText());
        admin.setLastName(personalDetailsView.getLastNameText());
        admin.setEmail(personalDetailsView.getEmailText());
        admin.setPassword(personalDetailsView.getPasswordText());
        admin.setPhoneNumber(personalDetailsView.getPhoneNumberText());

        adminModel.UpdateAdmin();

        JOptionPane.showMessageDialog( personalDetailsView,  "Details Updated");

        personalDetailsView.dispose();
    }

    //===========================================================================
}

package project.GUI.Controller;

import project.Entities.Admin;
import project.GUI.Model.AdminModel;
import project.GUI.View.Admin.*;
import project.GUI.General.MessageWindow;
import project.GUI.General.PersonalDetailsView;

import javax.swing.*;

public class AdminController extends UserController {


    private AdminModel adminModel;
    //all views related to Admin user
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
    //add action listener to main window
    private void addViewActionListeners () {
        addActionsToPerson(adminView);
        adminView.setActions(e->openEditPersonalDetailsView(), e->openRegisterView(), e->openUnregisterView(), e->openAddTreatmentsView());
    }

    //===========================================================================
    //open new sub-window and add action listener
    private void openAddTreatmentsView() {
        addTreatmentsView=new AddTreatmentsView();
        addTreatmentsView.setActions(e-> addTreatmentAction(), e->addTreatmentsView.dispose());
    }
    //action add new treatment
    public void addTreatmentAction() {
        String msg_received;
        if (addTreatmentsView.addAction()) {//function that checks if all fields are filled
            msg_received = adminModel.InsertTreatment((adminModel.getAvailableId())+1,
                    addTreatmentsView.getTreatmentNameText(),
                    Integer.parseInt(addTreatmentsView.getTreatmentDurationText()),
                    Double.parseDouble(addTreatmentsView.getTreatmentPriceText()));//insert treatment to DB
            if (msg_received.equals("Sucssesfuly")) {//if DB insertion succeeded
                new MessageWindow(addTreatmentsView, "New Treatment Added successfully");
                addTreatmentsView.dispose();

            } else new MessageWindow(addTreatmentsView, "ID IS ALREADY EXISTS IN OUR SYSTEM");//if DB insertion didnt succeed
        } else {
            new MessageWindow(addTreatmentsView, "Error: please fill all fields");//missing details
        }

    }

    //===========================================================================
    //open new sub-window and add action listener
    private void openRegisterView() {
        registerView=new RegisterView();
        registerView.setActions(e->registerUserAction(), e->setVisibleForDoctor(), e->setVisibleForPatient(), e->registerView.dispose());
    }
    //action add new user
    public void registerUserAction() {
        String msg_recieved="";
        if(registerView.allFieldsFilled())//first check if all details are filled
        {
            if(registerView.isPatientSelected())//if the new user is patient
            {
                //insert new patient to DB (by the details entered in register window)
                msg_recieved=adminModel.insertForPatient(registerView.getIdText(),registerView.getPasswordText(),
                        registerView.getFirstNameText(),registerView.getLastNameText(),
                        registerView.getEmailText(), Double.parseDouble(registerView.getWeightText()),
                        Integer.parseInt(registerView.getHeightText()),
                        registerView.getDateOfBirthText(),registerView.getGender(),registerView.getPhoneNumberText());
            }

            else if(registerView.isDoctorSelected())//if the new user is doctor
            {
                //insert new patient to DB (by the details entered in register window)
                msg_recieved=adminModel.insertForDoctor(registerView.getIdText(),registerView.getPasswordText(),
                        registerView.getFirstNameText(),registerView.getLastNameText(),
                        registerView.getEmailText(),registerView.getDateOfBirthText(),
                        registerView.getGender(),Integer.parseInt(registerView.getYearsOfExText()),registerView.getPhoneNumberText());
            }


            if (msg_recieved.equals("Sucssesfuly")) { //if DB insert succeeded
                new MessageWindow(registerView, "New user created successfully");
                registerView.dispose();
            }
            else new MessageWindow(registerView, "User already exists");// ID entered is already exists for another user


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
    //open new sub-window and add action listener
    private void openUnregisterView() {
        unRegisterView = new UnRegisterView();
        unRegisterView.setActions(e->unRegisterAction(),e->unRegisterView.dispose());
    }
    //action delete user
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
    //open new sub-window and add action listener
    private void openEditPersonalDetailsView() {
        personalDetailsView=new PersonalDetailsView();
        personalDetailsView.setActions(e->editAction(), e-> personalDetailsView.dispose());
        personalDetailsView.initializeUserFields(adminModel.getAdmin());
    }
    //action edit personal details of admin
    private void editAction() {
        Admin admin = adminModel.getAdmin();

        //set all fields
        admin.setFirstName(personalDetailsView.getFirstNameText());
        admin.setLastName(personalDetailsView.getLastNameText());
        admin.setEmail(personalDetailsView.getEmailText());
        admin.setPassword(personalDetailsView.getPasswordText());
        admin.setPhoneNumber(personalDetailsView.getPhoneNumberText());

        adminModel.UpdateAdmin();//function that updates fields of admin in DB

        JOptionPane.showMessageDialog( personalDetailsView,  "Details Updated");

        personalDetailsView.dispose();
    }

    //===========================================================================
}

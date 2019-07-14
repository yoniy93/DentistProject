package project.GUI.Admin.General;

import project.Entities.Admin;
import project.Entities.Treatments;
import project.GUI.Admin.AddTreatments.AddTreatmentsView;
import project.GUI.Admin.Register.StartRegisterView;
import project.GUI.Admin.UnRegister.StartUnRegister;
import project.GUI.General.MessageWindow;
import project.GUI.General.PersonController;
import project.GUI.General.PersonalDetailsView;
import javax.swing.*;


public class AdminController extends PersonController {

    private AdminModel adminModel;
    private AdminView adminView;
    private PersonalDetailsView personalDetailsView;
    private AddTreatmentsView addTreatmentsView;

    public AdminController(AdminModel adminM, AdminView adminV) {
        adminModel = adminM;
        adminView = adminV;

        addViewActionListeners();
    }

    private void addViewActionListeners () {
        addActionsToPerson(adminView);
        adminView.setActions(e->editPersonalDetailsAction(), e->registerAction(), e->unregisterAction(), e->newTreatments());

    }

    private void newTreatments() {

        addTreatmentsView=new AddTreatmentsView();
        addTreatmentsView.setActions(e-> addTreatmentAction(), e->addTreatmentsView.dispose());
    }

    public void addTreatmentAction() {
        String msg_received;
        Treatments treatments = addTreatmentsView.addAction();
        if (treatments != null) {
            treatments.setId(Integer.toString(adminModel.getAvailableId()) + 1);
            msg_received = adminModel.InsertTreatment(Integer.parseInt(treatments.getId()),
                    treatments.getName(),
                    treatments.getDuration(),
                    treatments.getPrice());
            if (msg_received.equals("Successfully")) {
                new MessageWindow(addTreatmentsView, "New Treatment Added successfully");
                addTreatmentsView.dispose();

            } else new MessageWindow(addTreatmentsView, "ID IS ALREADY EXISTS IN OUR SYSTEM");
        } else {
            new MessageWindow(addTreatmentsView, "Error: please fill all fields");
        }

    }

    private void registerAction() {

        new StartRegisterView(adminModel.getAdmin());
    }

    private void unregisterAction() {

        new StartUnRegister(adminModel.getAdmin());
    }

    private void editPersonalDetailsAction() {

        personalDetailsView=new PersonalDetailsView();
        personalDetailsView.setActions(e->editAction(), e-> personalDetailsView.dispose());
        personalDetailsView.initializePersonFields(adminModel.getAdmin());
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
}

package project.GUI.Patient.Treatments;

import project.Entities.Treatments;

import javax.swing.*;

public class TreatmentsPricesController
{
    TreatmentsPricesView treatmentsPricesView;
    TreatmentsPricesModel treatmentsPricesModel;

    TreatmentsPricesController() {
        this.treatmentsPricesModel=new TreatmentsPricesModel();
        this.treatmentsPricesView=new TreatmentsPricesView();
        treatmentsPricesView.getTreatmentList().setVisible(true);
        addViewActionListeners();
        treatmentsPricesView.setTreatmentList(treatmentsPricesModel.getAllTreatments());
        treatmentsPricesView.setVisible();
    }
    private void addViewActionListeners() {
        treatmentsPricesView.getTreatmentList().addActionListener(e->treatmentListAction());

    }

    private void treatmentListAction() {
        Treatments treatment = (Treatments)treatmentsPricesView.getTreatmentList().getSelectedItem();

        if (treatment != null) {
            treatmentsPricesView.setTreatmentPrices(Double.toString(treatment.getPrice()));
        }
    }




}

package project.GUI.Patient.Treatments;

import project.Entities.Treatments;

import javax.swing.*;

public class TreatmentsPricesController
{
   TreatmentsPricesView treatmentsPricesView;
    TreatmentsPricesModel treatmentsPricesModel;

    TreatmentsPricesController(TreatmentsPricesModel treatmentsPricesModel) {
        this.treatmentsPricesModel=treatmentsPricesModel;
        JComboBox treatmentList= new JComboBox(treatmentsPricesModel.getAllTreatments());
        treatmentsPricesView=new TreatmentsPricesView (treatmentList);
        addViewActionListeners();
    }
    private void addViewActionListeners() {
        treatmentsPricesView.getTreatmentList().addActionListener(e->treatmentListAction());

    }

    private void treatmentListAction() {
        int i=treatmentsPricesView.getTreatmentList().getSelectedIndex();
        Treatments treatmentSelected=treatmentsPricesModel.getTreatmentsVector().get(i);
        double price= treatmentSelected.getPrice();
        treatmentsPricesView.setTreatmentPrices(Double.toString(price));
    }




}

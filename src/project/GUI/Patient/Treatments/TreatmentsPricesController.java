package project.GUI.Patient.Treatments;

import project.Entities.Treatments;

public class TreatmentsPricesController
{
    TreatmentsPricesView treatmentsPricesView;
    TreatmentsPricesModel treatmentsPricesModel;

    TreatmentsPricesController() {
        this.treatmentsPricesModel=new TreatmentsPricesModel();
        this.treatmentsPricesView=new TreatmentsPricesView();
        treatmentsPricesView.getTreatmentListComboBox().setVisible(true);
        addViewActionListeners();
        treatmentsPricesView.setTreatmentList(treatmentsPricesModel.getAllTreatments());
        treatmentsPricesView.setVisible();
    }
    private void addViewActionListeners() {
        treatmentsPricesView.getTreatmentListComboBox().addActionListener(e->treatmentListAction());
        treatmentsPricesView.cancelButton.addActionListener(e -> treatmentsPricesView.dispose());
    }

    private void treatmentListAction() {
        Treatments treatment = (Treatments)treatmentsPricesView.getTreatmentListComboBox().getSelectedItem();

        if (treatment != null) {
            treatmentsPricesView.setTreatmentInfo(Double.toString(treatment.getPrice()),Integer.toString(treatment.getDuration()),"None");
        }
    }

}

package project.GUI.Patient.Treatments;

import project.Entities.Treatments;

public class TreatmentsPricesController
{
    TreatmentsPricesView treatmentsPricesView;
    TreatmentsPricesModel treatmentsPricesModel;

    TreatmentsPricesController(TreatmentsPricesModel treatmentsPricesModel ,TreatmentsPricesView treatmentsPricesView) {
        this.treatmentsPricesModel = treatmentsPricesModel;
        this.treatmentsPricesView = treatmentsPricesView;

        addViewActionListeners();
        treatmentsPricesView.setTreatmentList(treatmentsPricesModel.getAllTreatments());
    }
    private void addViewActionListeners() {
        treatmentsPricesView.setActions(e->treatmentListAction(),e->treatmentsPricesView.dispose());
    }

    private void treatmentListAction() {
        Treatments treatment = treatmentsPricesView.getTreatment();

        if (treatment != null) {
            treatmentsPricesView.setTreatmentInfo(Double.toString(treatment.getPrice()),Integer.toString(treatment.getDuration()),"None");
        }
    }

}

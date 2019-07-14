package project.GUI.Patient.Treatments;


public class StartTreatmentsPricesView
{
    public StartTreatmentsPricesView() {
        TreatmentsPricesView treatmentsPricesView = new TreatmentsPricesView();
        TreatmentsPricesModel treatmentsPricesModel = new TreatmentsPricesModel();
        new TreatmentsPricesController(treatmentsPricesModel, treatmentsPricesView);
    }
}

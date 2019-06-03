package project.GUI.Patient.Treatments;


public class StartTreatmentsPricesView
{
    public StartTreatmentsPricesView()
    {
        TreatmentsPricesModel treatmentsPricesModel=new TreatmentsPricesModel();
        new TreatmentsPricesController(treatmentsPricesModel);
    }
}

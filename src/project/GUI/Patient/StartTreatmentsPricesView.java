package project.GUI.Patient;

public class StartTreatmentsPricesView
{
    public StartTreatmentsPricesView()
    {
        TreatmentsPricesModel treatmentsPricesModel=new TreatmentsPricesModel();
        TreatmentsPricesView treatmentsPricesView=new TreatmentsPricesView();
        new TreatmentsPricesController(treatmentsPricesModel,treatmentsPricesView);
    }
}

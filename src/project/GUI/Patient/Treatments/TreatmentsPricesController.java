package project.GUI.Patient.Treatments;

import project.Entities.Treatments;
import project.Logic.DBQuerys;

public class TreatmentsPricesController
{
    DBQuerys dbQuerys=new DBQuerys();
    TreatmentsPricesView treatmentsPricesView;
    TreatmentsPricesModel treatmentsPricesModel;
    TreatmentsPricesController(TreatmentsPricesModel treatmentsPricesModel,TreatmentsPricesView treatmentsPricesView)
    {
        this.treatmentsPricesModel=treatmentsPricesModel;
        this.treatmentsPricesView=treatmentsPricesView;

        initController();
    }
    private void initController()
    {
        treatmentsPricesView.getTreatmentList().addActionListener(e->treatmentListAction());

    }

    private void treatmentListAction()
    {
        int i=treatmentsPricesView.getTreatmentList().getSelectedIndex();
       Treatments treatmentSelected=treatmentsPricesView.getTreatmentsVector().get(i);
       double price= ( treatmentSelected.getPrice());
       treatmentsPricesView.setTreatmentPrices(Double.toString(price));

    }




}

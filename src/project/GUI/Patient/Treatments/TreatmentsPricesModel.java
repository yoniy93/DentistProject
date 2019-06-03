package project.GUI.Patient.Treatments;

import project.Database.DBQuerys;
import project.Entities.Treatments;

import java.util.List;
import java.util.Vector;

public class TreatmentsPricesModel
{

    private DBQuerys dbQuerys=new DBQuerys();
    private String [] treatmentsName;
    private List<Treatments> treatmentsList;

    public String[] getTreatmentsName() {
        return treatmentsName;
    }

    public void setTreatmentsName(String[] treatmentsName) {
        this.treatmentsName = treatmentsName;
    }

    public List<Treatments> getTreatmentsVector() {
        return treatmentsList;
    }

    public void setTreatmentsVector(Vector<Treatments> treatmentsVector) {
        this.treatmentsList = treatmentsVector;
    }

    public List<Treatments> getAllTreatments(){
        treatmentsList=dbQuerys.getTreatments();
        return treatmentsList;
    }




}

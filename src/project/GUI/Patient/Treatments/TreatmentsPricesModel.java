package project.GUI.Patient.Treatments;

import project.Database.DBQuerys;
import project.Entities.Treatments;

import java.util.Vector;

public class TreatmentsPricesModel
{

    private DBQuerys dbQuerys=new DBQuerys();
    private String [] treatmentsName;
    private Vector<Treatments> treatmentsVector;

    public String[] getTreatmentsName() {
        return treatmentsName;
    }

    public void setTreatmentsName(String[] treatmentsName) {
        this.treatmentsName = treatmentsName;
    }

    public Vector<Treatments> getTreatmentsVector() {
        return treatmentsVector;
    }

    public void setTreatmentsVector(Vector<Treatments> treatmentsVector) {
        this.treatmentsVector = treatmentsVector;
    }

    public String [] getAllTreatments(){
        treatmentsVector=dbQuerys.getTreatments();
        setTreatmentsName();
        return treatmentsName;
    }

    private void setTreatmentsName() {
        treatmentsName=new String[treatmentsVector.size()];
        for(int i=0;i<treatmentsVector.size();i++) {
            treatmentsName[i]=(treatmentsVector.get(i).getName());
        }
    }



}

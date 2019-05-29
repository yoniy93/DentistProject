package project.GUI.Patient.Treatments;

import project.Database.DBQuerys;

public class TreatmentsPricesModel
{

    private DBQuerys pullTreatments=new DBQuerys();
    public DBQuerys getPullTreatments() {
        return pullTreatments;
    }

    public void setPullTreatments(DBQuerys pullTreatments) {
        this.pullTreatments = pullTreatments;
    }





}

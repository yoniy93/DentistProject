package project.GUI.Admin.AddTreatments;

import project.Database.DBInserts;
import project.Entities.Treatments;

public class AddTreatmentsController {

    //private AddTreatmentsView addTreatmentsView;
    private AddTreatmentsModel addTreatmentsModel;

    public AddTreatmentsController()
    {
       // this.addTreatmentsView=new AddTreatmentsView();
        this.addTreatmentsModel=new AddTreatmentsModel();
    }

    public void addAction(Treatments treatments)
    {
        addTreatmentsModel.InsertTreatment(Integer.parseInt(treatments.getId()),treatments.getName(),treatments.getDuration(),treatments.getPrice());
    }
}

package project.GUI.Admin.AddTreatments;

import project.Database.DBInserts;
import project.Entities.Treatments;

public class AddTreatmentsController {

    private AddTreatmentsView addTreatmentsView;
    private AddTreatmentsModel addTreatmentsModel;

    public AddTreatmentsController(AddTreatmentsView addTreatmentsView)
    {
       this.addTreatmentsView=addTreatmentsView;
        this.addTreatmentsModel=new AddTreatmentsModel();
    }

    public String addAction(Treatments treatments) {
        treatments.setId(Integer.toString(addTreatmentsModel.getAvailableId())+1 );
        return addTreatmentsModel.InsertTreatment(Integer.parseInt(treatments.getId()),
                                                                  treatments.getName(),
                                                                  treatments.getDuration(),
                                                                  treatments.getPrice());
    }
}

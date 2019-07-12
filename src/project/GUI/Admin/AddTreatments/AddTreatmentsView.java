package project.GUI.Admin.AddTreatments;

import project.Database.DBInserts;
import project.Database.Locations;
import project.Entities.Treatments;
import project.GUI.General.ErrorWindow;

import javax.swing.*;
import java.awt.*;

public class AddTreatmentsView extends JFrame
{
    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);

    AddTreatmentsController addTreatmentsController=new AddTreatmentsController(this);

    private JLabel treatmentId= new JLabel("ID:");
    private JLabel treatmentName=new JLabel(" Name:");
    private JLabel treatmentDuration=new JLabel("Duration:");
    private JLabel treatmentPrice=new JLabel("Price:");

    private JTextField treatmentIdTextField=new JTextField();
    private JTextField treatmentNameTextField=new JTextField();
    private JTextField treatmentDurationTextField=new JTextField();
    private JTextField treatmentPriceTextField=new JTextField();

    private JButton addTreatment=new JButton("ADD");
    private JButton cancel=new JButton("Cancel");

    public AddTreatmentsView()
    {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();
        addActionListeners();
        setTitle("Add New Treatment:");
        setBounds(300, 20, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize() {

        treatmentId.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentId.setBounds(60,40,100,30);
        treatmentIdTextField.setBounds(160, 40, 100, 30);

        treatmentName.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentName.setBounds(60,80,100,30);
        treatmentNameTextField.setBounds(160, 80, 100, 30);

        treatmentDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentDuration.setBounds(60,120,100,30);
        treatmentDurationTextField.setBounds(160,120,100,30);

        treatmentPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        treatmentPrice.setBounds(60,160,100,30);
        treatmentPriceTextField.setBounds(160, 160, 100, 30);

        addTreatment.setBounds(150,250,150,30);
        cancel.setBounds(310,250,150,30);
        backGround.setBounds(0,0,700,500);
    }

    private void addComponentsToFrame()
    {
        add(treatmentName);
        add(treatmentNameTextField);
        add(treatmentDuration);
        add(treatmentDurationTextField);
        add(treatmentId);
        add(treatmentIdTextField);
        add(treatmentPrice);
        add(treatmentPriceTextField);
        add(cancel);
        add(addTreatment);
        add(backGround);

    }

    private void addActionListeners()
    {
        getAddTreatment().addActionListener(e->addAction());
        getCancel().addActionListener(e->cancelAction());

    }

    private void addAction() {
        String msg_recieved;
        if(checkAllFields()) {
            Treatments treatments = new Treatments(getTreatmentIdTextField().getText(), getTreatmentNameTextField().getText(),
                    Integer.parseInt(getTreatmentDurationTextField().getText()), Double.parseDouble(getTreatmentPriceTextField().getText()));

            msg_recieved=addTreatmentsController.addAction(treatments);
            if (msg_recieved.equals("Sucssesfuly")) {
                new ErrorWindow(this, "New Treatment Added successfully");
                this.dispose();
            }
            else new ErrorWindow(this, msg_recieved);
        }
        else
        {
            new ErrorWindow(this,"Error: please fill all fields");
        }
    }

    private boolean checkAllFields() {

        if(!getTreatmentIdTextField().getText().equals("") && !getTreatmentNameTextField().getText().equals("")&&
                !getTreatmentDurationTextField().getText().equals("")&& !getTreatmentPriceTextField().getText().equals(""))
            return  true;
        else
            return false;
    }


    private void cancelAction()
    {
     this.dispose();
    }


    public JTextField getTreatmentIdTextField() {
        return treatmentIdTextField;
    }



    public JTextField getTreatmentNameTextField() {
        return treatmentNameTextField;
    }


    public JTextField getTreatmentDurationTextField() {
        return treatmentDurationTextField;
    }


    public JTextField getTreatmentPriceTextField() {
        return treatmentPriceTextField;
    }



    public JButton getAddTreatment() {
        return addTreatment;
    }



    public JButton getCancel() {
        return cancel;
    }




}

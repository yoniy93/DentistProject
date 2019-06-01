package project.GUI.Patient.Treatments;

import project.Database.Locations;
import project.Entities.Treatments;
import project.Database.DBQuerys;

import javax.swing.*;
import java.util.Vector;

public class TreatmentsPricesView extends JFrame {

    private DBQuerys dbQuerys=new DBQuerys();
    private Vector<Treatments> treatmentsVector=dbQuerys.getTreatments();
    private String [] treatmentsName;

    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("searchTreatments.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private JComboBox treatmentList;
    private JLabel treatmentPrices= new JLabel(" ");

    public TreatmentsPricesView()
    {
        setTreatmentsName();
        treatmentList=new JComboBox(treatmentsName);
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();


        setTitle("Search Your Treatment: ");
        setBounds(300, 100, 700, 500);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize()
    {
        treatmentList.setBounds(300, 200, 200, 30);
        treatmentPrices.setBounds(250, 200, 200 , 30);
        backGround.setBounds(0,0,700,500);
    }


    private void addComponentsToFrame()
    {
        add(treatmentList);
        add(treatmentPrices);
        add(backGround);

    }

    public void setTreatmentsName()
    {
        treatmentsName=new String[treatmentsVector.size()];
        for(int i=0;i<treatmentsVector.size();i++)
        {
            treatmentsName[i]=(treatmentsVector.get(i).getName());
        }
    }
    public JComboBox getTreatmentList() {
        return treatmentList;
    }

    public JLabel getTreatmentPrices() {
        return treatmentPrices;
    }

    public void setTreatmentPrices(String price)
    {
        treatmentPrices.setText((String)price);
    }
    public Vector<Treatments> getTreatmentsVector() {
        return treatmentsVector;
    }
}

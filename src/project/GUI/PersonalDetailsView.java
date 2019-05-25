package project.GUI;

import javax.swing.*;
import java.util.Vector;

public class PersonalDetailsView extends JFrame{

    private JButton edit;
    private JButton cancel;

    private JLabel id;
    private JLabel pswd;
    private JLabel lastname;
    private JLabel firstname;
    private JLabel dateOfBirth;
    private JLabel yearsOfEx;

    private JLabel email;
    private JTextField idText;
    private JTextField pswdText;
    private JTextField lastnameText;
    private JTextField firstnameText;
    private JTextField emailText;
    private JTextField yearsOfExText;

    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gender;

    private Vector<Integer> yearInfo;
    private Vector<Integer> monthInfo;
    private Vector<Integer>dayInfo;
    private JComboBox year;
    private JComboBox month;
    private JComboBox day;

    public PersonalDetailsView()
    {
        GenerateDateInfo();
        addComponentsToContainer();
        setLocationAndSize();

        edit=new JButton();
        cancel=new JButton();

        yearInfo=new Vector<Integer>();
        monthInfo=new Vector<Integer>();
        dayInfo=new Vector<Integer>();

        id=new JLabel("ID: ");
        pswd=new JLabel("Password: ");
        firstname=new JLabel("First Name: ");
        lastname =new JLabel( "Last Name: ");
        dateOfBirth= new JLabel("Date Of Birth: ");
        email=new JLabel( "Email: ");
        yearsOfEx=new JLabel("Years of experience: ");

        idText= new JTextField();
        pswdText=new JTextField();
        lastnameText=new JTextField();
        firstnameText=new JTextField();
        emailText=new JTextField();
        yearsOfExText= new JTextField();

        male=new JRadioButton("Male");
        female=new JRadioButton("Female");
        gender=new ButtonGroup();
        gender.add(male);
        gender.add(female);

        month=new JComboBox();
        day=new JComboBox();
        year=new JComboBox();
        setLayout(null);


        setTitle("Edit Personal Details ");
        setBounds(300, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void GenerateDateInfo( )
    {
        for (int i=0;i<31;i++)
        {
            this.dayInfo.set(i,i+1);
        }
        for(int i=0;i<12;i++)
        {
            this.monthInfo.set(i,i+1);
        }
        int startYear=2019;
        for(int i=0;i<100;i++)
        {
            this.yearInfo.set(i,startYear--);
        }
    }

    private void addComponentsToContainer() {
        add(lastname);
        add(firstname);
        add(male);
        add(female);
        add(email);
        add(dateOfBirth);
        add(month);
        add(day);
        add(year);
        add(edit);
        add(cancel);
        add(id);
        add(idText);
        add(lastnameText);
        add(firstnameText);
        add(emailText);
        add(pswd);
        add(pswdText);
        add(yearsOfEx);
        add(yearsOfExText);
    }

    private void setLocationAndSize()
    {


    }

}

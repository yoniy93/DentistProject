package project.GUI.View.Admin;

import project.Database.Locations;
import project.GUI.View.ExitButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UnRegisterView extends JFrame
{
    private ImageIcon imageForBG=new ImageIcon(Locations.getImagePath("unregister.png"));
    private JLabel backGround=new JLabel(imageForBG);

    private JButton submit = new JButton("Submit");
    private JTextField idTextField = new JTextField();
    private JLabel idLabel = new JLabel("Enter id of user :");
    ExitButton exitButton =new ExitButton();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public UnRegisterView()
    {
        setLayout(null);
        setLocationAndSize();
        addComponentsToFrame();

        setTitle("Unregister a user");
        setBounds(dim.width/2-this.getSize().width/2-225, dim.height/2-this.getSize().height/2-100, 450, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLocationAndSize()
    {
        idLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        idLabel.setBounds(20, 40, 150, 30);

        idTextField.setBounds(200,45,100,20);

        submit.setBounds(100,100,120,30);
        submit.setFont(new Font("Ariel",Font.BOLD, 12));
        exitButton.setLocation(240,100,120,30);

        backGround.setBounds(0,0,450,200);
    }

    private void addComponentsToFrame()
    {
        add(idLabel);
        add(idTextField);
        add(submit);
        add(exitButton);
        add(backGround);
    }

    public JButton getSubmit() {
        return submit;
    }

    public String getIdTextField() {
        return idTextField.getText();
    }

    public JButton getCancel() {
        return exitButton;
    }

    public void setActions(ActionListener unRegister,ActionListener cancel)
    {
        getSubmit().addActionListener(unRegister);
        getCancel().addActionListener(cancel);
    }

}

package project.GUI.Admin.UnRegister;

import project.Logic.DBHandler;

import javax.swing.*;

public class UnRegisterController
{
    UnRegisterModel unRegisterModel;
    UnRegisterView unRegisterView;
    public UnRegisterController(UnRegisterView unRegisterView, UnRegisterModel unRegisterModel)
    {
        this.unRegisterModel=unRegisterModel;
        this.unRegisterView=unRegisterView;

        addViewActionListeners();
    }

    private void addViewActionListeners()
    {
        unRegisterView.getSubmit().addActionListener(e-> submitAction());
        unRegisterView.getCancel().addActionListener(e->cancelAction());
    }

    private void submitAction()
    {
        DBHandler dbHandler=new DBHandler();
        dbHandler.deleteFromUsers(unRegisterView.getIdTextField().getText());
        JOptionPane.showMessageDialog(unRegisterView, "User Has Been Deleted");
    }
    private void cancelAction()
    {
        unRegisterView.dispose();
    }
}

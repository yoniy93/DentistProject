package project.GUI.Patient.Payment;

public class PaymentController {

    PaymentModel paymentModel;
    PaymentView paymentView;
    public PaymentController(PaymentView paymentView,PaymentModel paymentModel)
    {
        this.paymentModel=paymentModel;
        this.paymentView=paymentView;
        initController();
    }

    private void initController()
    {
        paymentView.getSubmit().addActionListener(e->submitAction());
        paymentView.getCancel().addActionListener(e->paymentView.dispose());
    }


    private void submitAction()
    {

    }
}

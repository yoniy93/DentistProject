package project.GUI.Patient.Payment;

public class StartPaymentView {

    public StartPaymentView() {
        PaymentModel paymentModel = new PaymentModel();
        PaymentView paymentView = new PaymentView();
        new PaymentController(paymentView, paymentModel);
    }
}

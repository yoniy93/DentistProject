package project.GUI.Patient.Payment;

import project.Entities.Treatments;

public class StartPaymentView {

    public StartPaymentView(Treatments treatment) {
        PaymentModel paymentModel = new PaymentModel(treatment);
        PaymentView paymentView = new PaymentView();
        new PaymentController(paymentView, paymentModel);
    }
}

package eapli.mymoney.bootstrap;

import eapli.mymoney.application.RegisterPaymentMethodController;

/**
 * Created by brunodevesa on 21/05/15.
 */
public class PaymentMethodBootstrapper {
    public void execute() {
        final RegisterPaymentMethodController registerExpenseTypeController = new RegisterPaymentMethodController();

        // FIXME rever como devemos por este código mais elegante
        try {
            registerExpenseTypeController.registerPaymentMethodType("Money");
        } catch (IllegalStateException ex) {
            //nothing to do
        }
        // FIXME rever como devemos por este código mais elegante
        try {
            registerExpenseTypeController.registerPaymentMethodType("Cheque");
        } catch (IllegalStateException ex) {

        }
        try {
            registerExpenseTypeController.registerPaymentMethodType("Credit Card");
        } catch (IllegalStateException ex) {

        }
        try {
            registerExpenseTypeController.registerPaymentMethodType("Debit Card");
        } catch (IllegalStateException ex) {

        }
    }
}

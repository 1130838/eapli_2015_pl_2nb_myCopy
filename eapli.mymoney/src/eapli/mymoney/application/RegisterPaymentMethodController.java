package eapli.mymoney.application;

import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.PaymentMethodsRepository;
import eapli.mymoney.persistence.Persistence;

/**
 * Created by brunodevesa on 21/05/15.
 */
public class RegisterPaymentMethodController {

    public void registerPaymentMethodType (final String paymentMethodTypeText) {
        final PaymentMethod paymentMethod = new PaymentMethod(paymentMethodTypeText);
        final PaymentMethodsRepository repo = Persistence.getRepositoryFactory().
                getPaymentMethodRepository();
        repo.add(paymentMethod);
    }
}

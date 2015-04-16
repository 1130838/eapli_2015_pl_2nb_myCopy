package eapli.mymoney.persistence;

import eapli.mymoney.domain.PaymentMethod;

import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public interface PaymentMethodsRepository {

    List<PaymentMethod> all();

}

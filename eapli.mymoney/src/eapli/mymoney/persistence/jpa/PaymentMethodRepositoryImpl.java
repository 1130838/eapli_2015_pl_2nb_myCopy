package eapli.mymoney.persistence.jpa;

import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.PaymentMethodsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class PaymentMethodRepositoryImpl
        extends JpaRepository<PaymentMethod, Integer>
        implements PaymentMethodsRepository {

    private static final List<PaymentMethod> paymentMethodList = new ArrayList<PaymentMethod>();

    static {
        paymentMethodList.add(new PaymentMethod("Money"));
        paymentMethodList.add(new PaymentMethod("Credit Card"));
        paymentMethodList.add(new PaymentMethod("Debit Card"));
        paymentMethodList.add(new PaymentMethod("Cheque"));
    }


    @Override
    public List<PaymentMethod> all() {
        return Collections.unmodifiableList(paymentMethodList);
    }

    @Override
    protected String persistenceUnitName() {
        return PersistenceSettings.PERSISTENCE_UNIT_NAME;

    }


}

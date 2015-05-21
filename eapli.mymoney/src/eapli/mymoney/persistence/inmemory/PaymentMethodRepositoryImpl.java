package eapli.mymoney.persistence.inmemory;

import eapli.framework.model.Money;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.domain.Period;
import eapli.mymoney.persistence.PaymentMethodsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brunodevesa on 17/04/15.
 */
public class PaymentMethodRepositoryImpl implements PaymentMethodsRepository {


    private static final List<PaymentMethod> data = new ArrayList<>();

    @Override
    public boolean add(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException();
        }
        if (data.contains(paymentMethod)) {
            //TODO rever se deviamos ter outra exceção mais significativa
            throw new IllegalStateException();
        }
        return data.add(paymentMethod);
    }


    @Override
    public long size() {
        return data.size();
    }

    @Override
    public List<PaymentMethod> all() {
        return Collections.unmodifiableList(data);
    }

  /*  @Override
    public Iterator<PaymentMethod> iterator(int pagesize) {
        return null;
    }*/


    public Money getWeekExpediture(Period period) {
        throw new UnsupportedOperationException("not implemented..");
    }
}

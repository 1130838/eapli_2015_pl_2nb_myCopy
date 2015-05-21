package eapli.mymoney.persistence;

import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import java.util.Iterator;

import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public interface PaymentMethodsRepository {

    boolean add(PaymentMethod paymentMethod);

    long size();

    List<PaymentMethod> all();

    public Iterator<PaymentMethod> iterator(int pagesize);

    /**
     * Find an expense type by the ID
     *
     * @param id ID of the expense type
     * @return expense type object
     */
    PaymentMethod findById(int id);

}

package eapli.mymoney.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by brunodevesa on 16/04/15.
 */
@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPaymentMethod;

    public String paymentMethod;

    public PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod() {
        // for ORM purposes
    }

    /**
     * returns the description text of this payment method type
     *
     * this method is only provided for user output
     *
     * @return
     */
    public String description() {

        return paymentMethod;
    }

}


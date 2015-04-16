package eapli.mymoney.domain;

import java.util.Date;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class Expense {

    private float value;
    private ExpenseType expenseType;
    private PaymentMethod paymentMethod;
    private Date date;


    public Expense(float value, ExpenseType expenseType, PaymentMethod paymentMethod, Date date) {
        this.value = value;
        this.expenseType = expenseType;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }


}

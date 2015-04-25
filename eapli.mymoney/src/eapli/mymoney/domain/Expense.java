package eapli.mymoney.domain;

import eapli.framework.model.Money;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by brunodevesa on 16/04/15.
 */
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idExpense;

    Money amount;

    @ManyToOne(cascade = CascadeType.ALL)
    private ExpenseType expenseType;

    @ManyToOne(cascade = CascadeType.ALL)
    private PaymentMethod paymentMethod;

    @Temporal(TemporalType.DATE)
    private Calendar date;

    public Expense(Money amount, ExpenseType expenseType, PaymentMethod paymentMethod, Calendar date) {
        this.amount = amount;
        this.expenseType = expenseType;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public Expense() {
        // for ORM purposes
    }

    @Override
    public String toString() {
        return "Expense{" +
                "idExpense = " + idExpense +
                ", amount = " + amount.amount() +
                ", expenseType = " + expenseType.description() +
                ", paymentMethod = " + paymentMethod.description() +
                ", date = " + date.get(Calendar.DAY_OF_MONTH) + "/" + date.get(Calendar.MONTH) + "/" + date.get(Calendar.YEAR) +
                '}';
    }
}

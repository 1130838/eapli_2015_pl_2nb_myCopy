package eapli.mymoney.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
@Entity
public class Expense {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idExpense;

    BigDecimal amount;

    @ManyToOne
    private ExpenseType expenseType;

    @ManyToOne //(cascade = CascadeType.ALL)
    private PaymentMethod paymentMethod;

    @Temporal(TemporalType.DATE)
    private Calendar date;

    private Expense() {
        // for ORM purposes
    }


    public Expense(BigDecimal amount, ExpenseType expenseType,
                   PaymentMethod paymentMethod, Calendar date) {
        this.amount = amount;
        this.expenseType = expenseType;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    /**
     * getDate method
     *
     * @return Calendar w/date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * getAmount method
     *
     * @return returns the amount of this expense
     */
    public BigDecimal getAmount() {
        return amount;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    @Override
    public String toString() {
        return "Expense{"
                + "idExpense = " + idExpense
                + ", amount = " + amount
                + ", expenseType = " + expenseType.description()
                + ", paymentMethod = " + paymentMethod.description()
                + ", date = " + date.get(Calendar.DAY_OF_MONTH) + "/" + date.
                get(Calendar.MONTH) + "/" + date.get(Calendar.YEAR)
                + '}';
    }

}

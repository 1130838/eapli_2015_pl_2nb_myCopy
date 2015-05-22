package eapli.mymoney.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by brunodevesa on 22/05/15.
 */
public class ExpenseLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idExpensiveLimit;

    BigDecimal budgetLimitValue;

    int limitYellow;

    int limitRed;

    @ManyToOne
    ExpenseType expenseType;


    public ExpenseLimit(int limitYellow, int limitRed, ExpenseType expenseType) {
        this.limitYellow = limitYellow;
        this.limitRed = limitRed;
        this.expenseType = expenseType;
    }

    public int getID(){
        return idExpensiveLimit;
    }

    public List<ExpenseLimit> getLimitsByExpenseType(ExpenseType expenseType) throws UnsupportedOperationException {

        // to do
        return null;
    }


    @Override
    public String toString() {
        return "ExpenseLimit{" +
                "idExpensiveLimit=" + idExpensiveLimit +
                ", limitYellow=" + limitYellow +
                ", limitRed=" + limitRed +
                ", expenseType=" + expenseType +
                '}';
    }

}

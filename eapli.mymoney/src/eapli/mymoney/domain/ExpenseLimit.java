package eapli.mymoney.domain;

import eapli.mymoney.application.ListExpenseTypesController;
import eapli.mymoney.persistence.jpa.ExpenseTypeRepositoryImpl;
import org.eclipse.persistence.internal.oxm.schema.model.All;
import org.eclipse.persistence.jpa.config.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunodevesa on 22/05/15.
 */
@Entity
public class ExpenseLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idExpensiveLimit;

    int budgetLimitValue;

    int limitYellow;

    int limitRed;

    @ManyToOne
    ExpenseType expenseType;

    public int getBudgetLimitValue() {
        return budgetLimitValue;
    }

    public int getLimitYellow() {
        return limitYellow;
    }

    public int getLimitRed() {
        return limitRed;
    }

    public ExpenseLimit(int budgetLimitValue, int limitYellow, int limitRed , ExpenseType expenseType) {
        this.expenseType = expenseType;
        this.budgetLimitValue = budgetLimitValue;
        this.limitYellow = limitYellow;
        this.limitRed = limitRed;

    }

    protected ExpenseLimit() {
        // for ORM purposes
    }

    public int getID(){
        return idExpensiveLimit;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public ExpenseLimit getLimitsByExpenseType(ExpenseType expenseType) throws UnsupportedOperationException {

        // to test
            if (this.expenseType.description().equalsIgnoreCase( expenseType.description())){
                return this;
        }
        return null;

    }

    @Override
    public String toString() {
        return "The expense limits for " +
                 expenseType.description() + " are: " +
                " budgetLimitValue= " + budgetLimitValue +
                ", limitYellow = " + limitYellow + " % " +
                ", limitRed = " + limitRed + " % " ;
    }
}

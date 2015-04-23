package eapli.mymoney.persistence.inmemory;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.Period;
import eapli.mymoney.persistence.ExpenseRepository;

/**
 * Created by brunodevesa on 17/04/15.
 */
public class ExpenseClassRepositoryImpl implements ExpenseRepository {


    public boolean add(Expense entity) {
        return false;
    }

    @Override
    public boolean registerExpense(Expense expense) {
        return false;
    }

    @Override
    public Money getWeekExpediture(Period period) {
        return null;
    }
}

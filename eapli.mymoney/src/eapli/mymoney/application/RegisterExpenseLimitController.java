package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseLimit;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.persistence.ExpenseLimitRepository;
import eapli.mymoney.persistence.Persistence;

/**
 * Created by brunodevesa on 22/05/15.
 */
public class RegisterExpenseLimitController {

    public void registerExpenseLimit(int limitYellow, int limitRed, ExpenseType expenseType) {
        final ExpenseLimit expenseLimit = new ExpenseLimit(limitYellow, limitRed, expenseType);
        final ExpenseLimitRepository repo = Persistence.getRepositoryFactory().
                getExpenseLimitRepository();
        repo.add(expenseLimit);
    }
}


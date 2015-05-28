package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseLimit;
import eapli.mymoney.persistence.ExpenseLimitRepository;
import eapli.mymoney.persistence.Persistence;

import java.util.List;

/**
 * Created by brunodevesa on 22/05/15.
 */
public class ListExpenseLimitsController {

    ExpenseLimitRepository repo = Persistence.getRepositoryFactory().getExpenseLimitRepository();

    public List<ExpenseLimit> getAllExpenseLimits() {

        return repo.all();
    }


}

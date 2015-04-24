/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseGroup;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import eapli.mymoney.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author Joel
 */
public class RegisterExpenseGroupController {

    /**
     * Register a new expense group.
     *
     * @param expenseGroupText name
     * @param beginPeriod beginning of period
     * @param endPeriod end of period
     * @param estimation The value of the budget estimation
     */
    public final void registerExpenseGroup(final String expenseGroupText,
            final Calendar beginPeriod, final Calendar endPeriod,
            final BigDecimal estimation) {
        final ExpenseGroup expenseGroup = new ExpenseGroup(expenseGroupText,
                beginPeriod, endPeriod, estimation);
        final ExpenseGroupRepository repo = Persistence.getRepositoryFactory().
                getExpenseGroupRepository();
        repo.add(expenseGroup);
    }

}

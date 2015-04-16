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
import java.util.Date;

/**
 *
 * @author Joel
 */
public class RegisterExpenseGroupController {

    public void registerExpenseGroup(final String expenseGroupText, final Date dataInicio, final Date dataFim, final BigDecimal estimativa) {
        final ExpenseGroup expenseGroup = new ExpenseGroup(expenseGroupText, dataInicio, dataFim, estimativa);
        final ExpenseGroupRepository repo = Persistence.getRepositoryFactory().
                getExpenseGroupRepository();
        repo.add(expenseGroup);
    }

}

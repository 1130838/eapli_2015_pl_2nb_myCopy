/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import eapli.mymoney.persistence.Persistence;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class RegisterExpenseTypeController {

    public void registerExpenseType(final String expenseTypeText) {
        final ExpenseType expenseType = new ExpenseType(expenseTypeText);
        final ExpenseTypeRepository repo = Persistence.getRepositoryFactory().
                getExpenseTypeRepository();
        repo.add(expenseType);
    }
}

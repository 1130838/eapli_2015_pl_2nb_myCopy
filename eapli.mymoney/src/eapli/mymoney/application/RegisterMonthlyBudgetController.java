/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.Budget;
import eapli.mymoney.persistence.BudgetRepository;
import eapli.mymoney.persistence.Persistence;
import java.util.List;

/**
 *
 * @author ferreirai
 */
public class RegisterMonthlyBudgetController {

    public List<Budget> getTiposDespesa() {
        BudgetRepository repo = Persistence.getRepositoryFactory().
                getBudgetRepository();
        return repo.all();
    }

    public void registerMonthlyBudget() {
//        final ExpenseType expenseType = new ExpenseType(expenseTypeText);
//        final ExpenseTypeRepository repo = Persistence.getRepositoryFactory().
//                getExpenseTypeRepository();
//        repo.add(expenseType);
    }
}

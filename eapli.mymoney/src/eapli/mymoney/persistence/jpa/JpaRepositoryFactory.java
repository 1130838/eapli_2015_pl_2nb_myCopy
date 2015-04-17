/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.jpa;

import eapli.mymoney.persistence.BudgetRepository;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import eapli.mymoney.persistence.RepositoryFactory;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public ExpenseTypeRepository getExpenseTypeRepository() {
        return new eapli.mymoney.persistence.jpa.ExpenseTypeRepositoryImpl();
    }

    @Override
    public ExpenseGroupRepository getExpenseGroupRepository() {
        return new eapli.mymoney.persistence.jpa.ExpenseGroupRepositoryImpl();
    }

    @Override
    public ExpenseGroupRepository getExpenseGroupRepository() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

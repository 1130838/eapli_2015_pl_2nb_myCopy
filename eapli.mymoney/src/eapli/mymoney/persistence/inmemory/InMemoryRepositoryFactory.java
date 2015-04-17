/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.inmemory;

import eapli.mymoney.persistence.BudgetRepository;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import eapli.mymoney.persistence.RepositoryFactory;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    @Override
    public ExpenseTypeRepository getExpenseTypeRepository() {
        return new eapli.mymoney.persistence.inmemory.ExpenseTypeRepositoryImpl();
    }

    @Override
    public ExpenseGroupRepository getExpenseGroupRepository() {
        return new eapli.mymoney.persistence.inmemory.ExpenseGroupRepositoryImpl();
    }
    @Override
    public BudgetRepository getBudgetRepository() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.jpa;

import eapli.mymoney.persistence.*;

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
    public BudgetRepository getBudgetRepository() {
        return new eapli.mymoney.persistence.jpa.BudgetRepositoryImpl();
    }

    @Override
    public ExpenseRepository getExpenseRepository() {
        return new eapli.mymoney.persistence.jpa.ExpenseClassRepositoryImpl();
    }
}

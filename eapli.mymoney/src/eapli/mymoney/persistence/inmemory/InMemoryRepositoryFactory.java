/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.inmemory;

import eapli.mymoney.persistence.*;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    @Override
    public ExpenseTypeRepository getExpenseTypeRepository() {
        return new eapli.mymoney.persistence.inmemory.ExpenseTypeRepositoryImpl();
    }

    /*
    public ExpenseRepository getExpenseRepository() {
        return new eapli.mymoney.persistence.inmemory.ExpenseClassRepositoryImpl();
    }


    public PaymentMethodsRepository getPaymentMethodsRepository() {
        return new eapli.mymoney.persistence.inmemory.PaymentMethodRepositoryImpl();

    }
*/
    @Override
    public ExpenseGroupRepository getExpenseGroupRepository() {
        return new eapli.mymoney.persistence.inmemory.ExpenseGroupRepositoryImpl();
    }
    @Override
    public BudgetRepository getBudgetRepository() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }}

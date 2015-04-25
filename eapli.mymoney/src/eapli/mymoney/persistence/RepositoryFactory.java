/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface RepositoryFactory {

    ExpenseTypeRepository getExpenseTypeRepository();

    ExpenseGroupRepository getExpenseGroupRepository();

    BudgetRepository getBudgetRepository();

    ExpenseRepository getExpenseRepository();

    PaymentMethodsRepository getPaymentMethodRepository();

}

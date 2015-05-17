/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseGroup;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;
import java.util.List;

/**
 *
 * @author Miguel Carneiro
 */
public class ShowExpenseGroupStatusController {

    /**
     * Show Expense Group Status.
     *
     * @param expenseGroup name of Expense Group to check.
     *
     */
    // Expense Group selected to check status
    private ExpenseGroup theExpenseGroup;

    // Get Status of Expense Group selected
    public boolean getStatus(String expenseGroup) {
        List<ExpenseGroup> expenseGroups = getExpenseGroups();

        boolean aux = false;
        for (int i = 0; i < expenseGroups.size(); i++) {
            if (expenseGroups.get(i).getName().equals(expenseGroup)) {
                theExpenseGroup = expenseGroups.get(i);
                aux = true;
            }
        }
        if (aux) {
            System.out.println("\nExpense group name: " + theExpenseGroup.getName());
            List<Expense> expenses = getExpenses();
            float currentValue = 0;
            float estimation = theExpenseGroup.getEstimation().floatValue();

            if (expenses.size() == 0) {
                System.out.println("There are no expenses registered.\n");
                return false;
            } else {
                System.out.println("List of expenses:\n");
                for (int i = 0; i < expenses.size(); i++) {
                    // TODO: add condition to list only expenses of types mentioned in Expense Group's array.
                    currentValue += expenses.get(i).getAmount().floatValue();
                    System.out.println(expenses.get(i).toString());
                }
                System.out.println("End of expense group.\n");
            }

            if (estimation == 0) {
                System.out.println("Current Value: " + currentValue + "\n");
            } else {
                System.out.println("Current Value: " + currentValue);
                //System.out.println("Estimation: " + estimation + "\n");
                float diference = estimation - currentValue;
                System.out.println("Diference: " + diference + "\n");
            }
            return true;
        } else {
            System.out.println("Invalid expense group description.\n");
            return false;
        }
    }

    // List all Expense Groups registered
    public boolean listAllExpenseGroups() {
        List<ExpenseGroup> expenseGroups = getExpenseGroups();

        if (expenseGroups.size() != 0) {
            for (int i = 0; i < expenseGroups.size(); i++) {
                System.out.println(i + " - " + expenseGroups.get(i).getName());
            }
            return true;
        } else {
            System.out.println("There are no expense groups registered\n");
            return false;
        }
    }

    // Get all Expenses registered
    public List<Expense> getExpenses() {
        final ExpenseRepository repo = Persistence.getRepositoryFactory().getExpenseRepository();
        return repo.all();
    }

    public List<ExpenseGroup> getExpenseGroups() {
        ExpenseGroupRepository repo = Persistence.getRepositoryFactory().getExpenseGroupRepository();
        return repo.all();
    }
}

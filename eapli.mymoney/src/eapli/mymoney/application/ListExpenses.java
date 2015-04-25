/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.Expense;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;
import eapli.util.Console;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author celiocerqueira
 */
public class ListExpenses {

    Calendar dateInicial;
    Calendar dateEnd;

    /**
     * RegisterExpenseUI copy
     */
    public ListExpenses(Calendar dateInicial, Calendar dateEnd) {
        this.dateInicial = dateInicial;
        this.dateEnd = dateEnd;
    }

    public void showAllExpenses() {

        final ExpenseRepository repo = Persistence.getRepositoryFactory().getExpenseRepository();

        List<Expense> expenseList = repo.all();

        if (expenseList == null || expenseList.isEmpty()) {
            System.out.println("There is no expenses to list.");
            Console.readLine("Press a key to continue..");
        } else {
            showListResults(expenseList);
        }
    }

    private void showListResults(List<?> list) {

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Test Query results: list of all expenses");
        for (Object result : list) {
            System.out.println(result);
        }
        System.out.println("----------------------------------------------------------------------");
        Console.readLine("Press a key to continue..");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.ListExpenseTypesController;
import eapli.mymoney.domain.ExpenseType;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListExpenseTypesUI extends BaseUI {

    private final ListExpenseTypesController theController = new ListExpenseTypesController();

    @Override
    protected boolean doShow() {
        final List<ExpenseType> expenseTypes = theController.getAllExpenseTypes();
        for (int i = 0; i < expenseTypes.size(); i++) {
            System.out.println(i + " - " + expenseTypes.get(i).description());
        }
//        for (ExpenseType et : expenseTypes) {
//            System.out.println(et.description());
//        }

//		final Iterator<ExpenseType> expenseTypes = theController.iterator();
//		while (expenseTypes.hasNext()) {
//			ExpenseType et = expenseTypes.next();
//			System.out.println(et.description());
//		}
        return true;
    }

    @Override
    public String headline() {
        return "List Expense Types";
    }
}

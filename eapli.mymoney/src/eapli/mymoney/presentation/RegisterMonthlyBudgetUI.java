/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.framework.model.Money;
import eapli.mymoney.application.RegisterMonthlyBudgetController;
import eapli.mymoney.domain.ExpenseType;
import eapli.util.Console;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ferreirai
 */
public class RegisterMonthlyBudgetUI extends BaseUI {

    private RegisterMonthlyBudgetController controller = new RegisterMonthlyBudgetController();
    private List<ExpenseType> expenseTypeList;
    private String budgetName;

    @Override
    public boolean doShow() {
        System.out.println("\n" + headline());

        budgetName = Console.readLine("Type the Budget name:");
        controller.changeBudgetName(budgetName);
        expenseTypeList = controller.getTiposDespesa();
        int option = -1, position = 1;

        while (option != 0) {
            position = 1;
            for (Iterator<ExpenseType> iterator = expenseTypeList.iterator(); iterator.hasNext();) {
                ExpenseType next = iterator.next();
                System.out.println(position + " - " + next.toString());
                position++;
            }
            option = Console.readInteger("Please choose an Expense Type");
            ExpenseType chosenExpenseType = null;
            for (Iterator<ExpenseType> iterator = expenseTypeList.iterator(); iterator.hasNext();) {
                position++;
                if (option == position) {
                    chosenExpenseType = iterator.next();
                }
            }
            double chosenValue = Console.readDouble("Please choose an Value for the Expense");
            Money valor = Money.euros(chosenValue);
            //
            controller.addEntry(chosenExpenseType, valor);
        }
        controller.saveBudget();
        return true;
    }

    private void submit() {
        //controller.registerMonthlyBudget();
        System.out.println("\nMonthly Budget recorded!");
    }

    @Override
    public String headline() {
        return "REGISTER MONTLHY BUDGET";
    }
}

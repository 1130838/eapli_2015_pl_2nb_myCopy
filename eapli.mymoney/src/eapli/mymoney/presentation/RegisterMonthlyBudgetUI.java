/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.RegisterMonthlyBudgetController;
import eapli.mymoney.domain.Budget;
import eapli.util.Console;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ferreirai
 */
public class RegisterMonthlyBudgetUI extends BaseUI {

    private RegisterMonthlyBudgetController controller = new RegisterMonthlyBudgetController();
    private List<Budget> expenseTypeList;

    @Override
    public boolean doShow() {
        System.out.println("\n" + headline());
        expenseTypeList = controller.getTiposDespesa();
        int option = -1, position = 1;
        while (option != 0) {
            position = 1;
            for (Iterator<Budget> iterator = expenseTypeList.iterator(); iterator.hasNext();) {
                Budget next = iterator.next();
                System.out.println(position + " - " + next.toString());
                position++;
            }
            option = Console.readInteger("Please choose an Expense Type");
            Budget chosenBudget = null;
            for (Iterator<Budget> iterator = expenseTypeList.iterator(); iterator.hasNext();) {
                position++;
                if (option == position) {
                    chosenBudget = iterator.next();
                }
            }
        }
        double value = Console.readDouble("Please choose an Value for the Expense");

        return true;
    }

    private void submit() {
        controller.registerMonthlyBudget();
        System.out.println("\nMonthly Budget recorded!");
    }

    @Override
    public String headline() {
        return "REGISTER MONTLHY BUDGET";
    }
}

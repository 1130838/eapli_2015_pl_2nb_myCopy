/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.RegisterExpenseTypeController;
import eapli.util.Console;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class RegisterExpenseTypeUI extends BaseUI {

    private RegisterExpenseTypeController controller = new RegisterExpenseTypeController();
    private String expenseType;

    @Override
    public boolean doShow() {
        expenseType = Console.readLine("Enter expense type description » ");
        submit();

        return true;
    }

    private void submit() {
        controller.registerExpenseType(expenseType);
        System.out.println("\nExpense type recorded!");
    }

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE TYPE";
    }
}

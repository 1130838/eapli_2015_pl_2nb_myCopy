/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.ShowExpenseGroupStatusController;
import eapli.util.Console;

/**
 *
 * @author Miguel Carneiro
 */
public class ShowExpenseGroupStatusUI extends BaseUI {

    // Controller of UC-G-004
    private final ShowExpenseGroupStatusController controller = new ShowExpenseGroupStatusController();

    // Name of expense group to check status.
    private String expenseGroup;

    @Override
    protected boolean doShow() {
        if (controller.listAllExpenseGroups() == true) {
            expenseGroup = Console.readLine("Type an expense group description:\n");
            submit();
            return true;
        }
        Console.readLine("Press a key to continue...\n");
        return false;
    }

    private void submit() {
        controller.getStatus(expenseGroup);
        Console.readLine("Press a key to continue...\n");
    }

    @Override
    public String headline() {
        return "SHOW AN EXPENSE GROUP TYPE";
    }
}

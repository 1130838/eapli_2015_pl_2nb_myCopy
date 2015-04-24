/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.StatusExpGroupController;
import eapli.util.Console;

public class ShowExpGroupUI extends BaseUI {

    private StatusExpGroupController controller = new StatusExpGroupController();

    // Expense Group name to get status
    private String expenseGroup;

    @Override
    public boolean doShow() {

        expenseGroup = Console.readLine("Type expense group description: ");
        submit();

        return true;
    }

    private void submit() {
        controller.getStatus(expenseGroup);

    }

    @Override
    public String headline() {
        return "SHOW AN EXPENSE GROUP TYPE";
    }

}

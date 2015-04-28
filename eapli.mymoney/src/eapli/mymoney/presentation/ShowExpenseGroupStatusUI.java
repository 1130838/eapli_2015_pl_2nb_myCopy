/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.ShowExpenseGroupStatusController;
import eapli.util.Console;
import java.util.List;

/**
 *
 * @author Miguel Carneiro
 */
public class ShowExpenseGroupStatusUI extends BaseUI {

    // Controller of UC-G-004
    private final ShowExpenseGroupStatusController controller = new ShowExpenseGroupStatusController();

    // Name of expense group to check status.
    private String expenseGroup;

    // Get a list of all Expense Groups registed.
    public List<String> getListExpGroup() {
        return controller.getListExpenseGroup();
    }

    @Override
    protected boolean doShow() {

        List<String> listExpGroups = getListExpGroup();
        for (String listExpGroup : listExpGroups) {
            System.out.println(listExpGroup);
        }
        expenseGroup = Console.readLine("Type an expense group description:\n");

        boolean tmp = false;
        for (String listExpGroup : listExpGroups) {
            if (listExpGroup.equals(expenseGroup)) {
                tmp = true;
            }
        }

        if (tmp) {
            submit();
        } else {
            System.out.println("Invalid expense group description.\n");
        }

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

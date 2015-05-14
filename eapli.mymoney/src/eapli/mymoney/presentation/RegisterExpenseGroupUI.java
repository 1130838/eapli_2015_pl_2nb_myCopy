/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.RegisterExpenseGroupController;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author Joel
 */
public class RegisterExpenseGroupUI extends BaseUI {

    /**
     * Controller of use case.
     */
    private final RegisterExpenseGroupController controller
            = new RegisterExpenseGroupController();
    /**
     * The name of the Expense Group.
     */
    private String expenseGroup;
    /**
     * Begin of period.
     */
    private Calendar beginPeriod;
    /**
     * End of period.
     */
    private Calendar endPeriod;
    /**
     * The value of the budget estimation.
     */
    private BigDecimal estimation;

    //1 to enable by default , o to disable
    private int disable = 1;

    @Override
    public final boolean doShow() {
        expenseGroup = Console.
                readLine("Enter expense group description » ");
        beginPeriod = Console.
                readCalendar("Enter expense group begin period (dd-MM-yyyy) » ");
        endPeriod = Console.
                readCalendar("Enter expense group end period (dd-MM-yyyy) » ");
        estimation = new BigDecimal(Console.readDouble(
                "Enter expense group budget estimation » "));
        submit();

        return true;
    }

    /**
     * Records the Group.
     */
    private void submit() {
        controller.registerExpenseGroup(expenseGroup, beginPeriod,
                endPeriod, estimation);
        System.out.println("\nExpense group recorded!");
    }

    @Override
    public final String headline() {
        return "REGISTER AN EXPENSE GROUP";
    }
}

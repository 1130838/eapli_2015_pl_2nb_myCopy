/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.EditExpenseGroupController;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author joaomonteiro
 */
public class EditExpenseGroupUI extends BaseUI {

    /**
     * Controller of the UC.
     */
    private final EditExpenseGroupController controller
            = new EditExpenseGroupController();

    /**
     * Name of the expense group to change data.
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

    public List<String> getListExpenseGroup() {

        return controller.getListExpenseGroup();
    }

    /**
     * Show list of Expense groups and its data to change.
     *
     * @return true
     */
    @Override
    protected boolean doShow() {
        String opcao;
        List<String> listExpenseGroups = getListExpenseGroup();
        System.out.println("Choose one Expense Group: \n");
        int i = 1;
        for (String listExpenseGroup : listExpenseGroups) {
            System.out.println(listExpenseGroup);
        }
        System.out.println("Choose: \n");
        Console.readLine(expenseGroup);//NEED DO ERROR
        beginPeriod = controller.getBeginPeriod(expenseGroup);
        System.out.println("Begin Period:\n");
        System.out.println(beginPeriod);
        opcao = Console.readLine("Do You want change? (y/n)");
        if (opcao == "y") {
            beginPeriod = Console.
                    readCalendar("Enter expense group begin period » ");
        }
        endPeriod = controller.getEndPeriod(expenseGroup);
        System.out.println("Begin Period:\n");
        System.out.println(endPeriod);
        opcao = Console.readLine("Do You want change? (y/n)");
        if (opcao == "y") {
            endPeriod = Console.
                    readCalendar("Enter expense group begin period » ");
        }

        estimation = controller.getEstimation(expenseGroup);
        System.out.println("Begin Period:\n");
        System.out.println(estimation);
        opcao = Console.readLine("Do You want change? (y/n)");
        if (opcao == "y") {
            estimation = BigDecimal.valueOf(Console.readDouble("Enter expense group begin period » "));
        }
        controller.editExpenseGroup(expenseGroup, beginPeriod, endPeriod, estimation);
        return true;

    }

    @Override
    public String headline() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void submit() {
        controller.editExpenseGroup(expenseGroup, beginPeriod,
                endPeriod, estimation);
        System.out.println("\nExpense group recorded!");

    }

}

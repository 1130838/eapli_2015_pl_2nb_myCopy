/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.RegisterExpenseGroupController;
import eapli.util.Console;
import eapli.util.DateTime;
import java.math.BigDecimal;

/**
 *
 * @author Joel
 */
public class RegisterExpenseGroupUI extends BaseUI {

    private RegisterExpenseGroupController controller = new RegisterExpenseGroupController();
    private String expenseGroup;
    private String dataInicio;
    private String dataFim;
    private BigDecimal estimativa;

    @Override
    public boolean doShow() {
        expenseGroup = Console.readLine("Enter expense group description » ");
        dataInicio = Console.readLine("Enter expense group begin period » ");
        dataFim = Console.readLine("Enter expense group end period » ");

        submit();

        return true;
    }

    private void submit() {
        controller.registerExpenseGroup(expenseGroup,
                DateTime.parseDate(dataInicio, "dd-mm-yyyy"),
                DateTime.parseDate(dataFim, "dd-mm-yyyy"), estimativa);
        System.out.println("\nExpense group recorded!");
    }

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE GROUP";
    }
}

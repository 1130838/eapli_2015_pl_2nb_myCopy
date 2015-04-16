/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.RegisterExpenseGroupController;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Joel
 */
public class RegisterExpenseGroupUI extends BaseUI {

    private RegisterExpenseGroupController controller = new RegisterExpenseGroupController();
    private String expenseGroup;
    private Date dataInicio;
    private Date dataFim;
    private BigDecimal estimativa;

    @Override
    public boolean doShow() {
        expenseGroup = Console.readLine("Enter expense group description » ");

        submit();

        return true;
    }

    private void submit() {
        controller.registerExpenseGroup(expenseGroup, dataInicio, dataFim, estimativa);
        System.out.println("\nExpense group recorded!");
    }

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE GROUP";
    }
}

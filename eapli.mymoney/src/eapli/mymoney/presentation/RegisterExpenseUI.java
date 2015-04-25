package eapli.mymoney.presentation;

import eapli.framework.model.Money;
import eapli.mymoney.application.RegisterExpenseController;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.util.Console;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by brunodevesa on 24/04/15.
 */
public class RegisterExpenseUI extends BaseUI {

    private final RegisterExpenseController registerExpenseController = new RegisterExpenseController();

    ExpenseType expensetype = new ExpenseType("vestuario");
    PaymentMethod paymentMethod = new PaymentMethod("cheque");

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
    Calendar date = Calendar.getInstance();

    long value = Console.readInteger("Enter the expense value :");
    Money moneyValue = Money.euros(value);

    @Override
    protected boolean doShow() {

        submit();

        return true;
    }

    private void submit() {

        Expense expense = registerExpenseController.registerExpense(moneyValue, expensetype, paymentMethod, date);
        // System.out.println("teste expense = " + expense.toString());

        showAllExpenses(); // for test purposes for now
    }

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE";
    }


    private void showAllExpenses() {

        List<Expense> expenseList = registerExpenseController.listAllExpenses();

        if (expenseList == null || expenseList.isEmpty()) {
            System.out.println("There is no expenses to list.");
            Console.readLine("Press a key to continue..");
        } else {
            showListResults(expenseList);
        }
    }

    private void showListResults(List<?> list) {

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Test Query results: list of all expenses");
        for (Object result : list) {
            System.out.println(result);
        }
        System.out.println("----------------------------------------------------------------------");
        Console.readLine("Press a key to continue..");
    }
}


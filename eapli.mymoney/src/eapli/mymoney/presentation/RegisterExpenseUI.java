package eapli.mymoney.presentation;

import eapli.framework.model.Money;
import eapli.mymoney.application.RegisterExpenseController;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.util.Console;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by brunodevesa on 24/04/15.
 */
public class RegisterExpenseUI extends BaseUI {

    private RegisterExpenseController registerExpenseController;
    private ExpenseType expensetype;
    private PaymentMethod paymentMethod;
    private Calendar date;
    private Money moneyValue;

    @Override
    protected boolean doShow() {

        Console.readLine("Enter the Expense type:");
        expensetype = new ExpenseType("vestuario");

        Console.readLine("Enter the Payment Method:");
        paymentMethod = new PaymentMethod("cheque");

        //Console.readLine("Enter the Data [yyyy MMM dd]:");
        //sdf = new SimpleDateFormat("yyyy MMM dd");
        date = Calendar.getInstance();

        long value = Console.readInteger("Enter the expense value :");
        //BigDecimal value2 = new BigDecimal(0); //ver celio

        Money moneyValue = Money.euros(value);

        submit();

        return true;
    }

    private void submit() {
        registerExpenseController = new RegisterExpenseController(moneyValue, expensetype, paymentMethod, date);
        Expense expense = registerExpenseController.registerExpense();
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

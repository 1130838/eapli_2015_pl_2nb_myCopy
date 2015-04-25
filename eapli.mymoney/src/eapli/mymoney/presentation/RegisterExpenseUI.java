package eapli.mymoney.presentation;

import eapli.framework.model.Money;
import eapli.mymoney.application.ListExpenseTypesController;
import eapli.mymoney.application.ListPaymentMethodController;
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
    private BigDecimal moneyValue;
    //private BigDecimal value;

    @Override
    protected boolean doShow() {
        /*add Expense type*/
        new ListExpenseTypesUI().show();
        final ListExpenseTypesController theControllerExpenseTypes = new ListExpenseTypesController();
        int exptype = Console.readInteger("Enter the Expense type:");
        final List<ExpenseType> expenseTypes = theControllerExpenseTypes.getAllExpenseTypes();
        expensetype = expenseTypes.get(exptype);
        /*end add Expense type*/

        /*add Payment Method*/
        new ListExpenseTypesUI().show();
        final ListPaymentMethodController theControllerPayment = new ListPaymentMethodController();
        int pay = Console.readInteger("Enter the Payment Method:");
        final List<PaymentMethod> payment = theControllerPayment.getAllPaymentMethod();
        paymentMethod = payment.get(exptype);
        /*add Payment Method*/

        //Console.readLine("Enter the Data [yyyy MMM dd]:");
        //sdf = new SimpleDateFormat("yyyy MMM dd");
        date = Calendar.getInstance();

        moneyValue = BigDecimal.valueOf(Console.readInteger("Enter the expense value :"));
        //BigDecimal value2 = new BigDecimal(0); //ver celio



        submit();

        return true;
    }

    private void submit() {
        registerExpenseController = new RegisterExpenseController(moneyValue, expensetype, paymentMethod, date);
        Expense expense = registerExpenseController.registerExpense();

        System.out.println(expense.toString());
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

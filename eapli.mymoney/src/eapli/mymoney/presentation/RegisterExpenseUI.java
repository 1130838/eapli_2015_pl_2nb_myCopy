package eapli.mymoney.presentation;

import eapli.mymoney.application.ListExpenseTypesController;
import eapli.mymoney.application.ListPaymentMethodController;
import eapli.mymoney.application.RegisterExpenseController;
import eapli.mymoney.application.WatchExpenseController;
import eapli.mymoney.domain.*;
import eapli.util.Console;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Created by brunodevesa on 24/04/15.
 */
public class RegisterExpenseUI extends BaseUI implements Observer {

    private RegisterExpenseController registerExpenseController;
    private WatchExpenseController watchExpenseController;
    public ExpenseType expenseType;
    private PaymentMethod paymentMethod;
    private Calendar date;
    private BigDecimal moneyValue;

    private Observable observable = null;

    @Override
    protected boolean doShow() {

        new ListExpenseTypesUI().show();
        final ListExpenseTypesController theControllerExpenseTypes = new ListExpenseTypesController();
        int option = Console.readInteger("Enter the Expense type:");
        final List<ExpenseType> expenseTypesList = theControllerExpenseTypes.getAllExpenseTypes();

        expenseType = expenseTypesList.get(option);

        new ListPaymenteMethodsUI().show();
        final ListPaymentMethodController theControllerPayment = new ListPaymentMethodController();
        int pay = Console.readInteger("Enter the Payment Method:");
        final List<PaymentMethod> payment = theControllerPayment.getAllPaymentMethod();
        paymentMethod = payment.get(pay);

        date = Calendar.getInstance();
        moneyValue = BigDecimal.valueOf(Console.readInteger("Enter the expense value :"));

        submit();

        return true;
    }

    private void submit() {


        registerExpenseController = new RegisterExpenseController(moneyValue, expenseType, paymentMethod, date);

        Expense expense = registerExpenseController.getExpense();
        watchExpenseController = new WatchExpenseController(this,expense); // vai a despesa toda

        // colocar validação na watchDOg e  so depois registar a despesa
        registerExpenseController.registerExpense();


        List<Expense> expenseList = registerExpenseController.listAllExpenses();
        showListResults(expenseList); // for test purposes for now
    }

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE";
    }

    private void showListResults(List<?> list) {

        if (list == null || list.isEmpty()) {
            System.out.println("There is no expenses to list.");
            Console.readLine("Press a key to continue..");
        } else {

            System.out.println("----------------------------------------------------------------------");
            System.out.println("Test Query results: list of all expenses");

            for (Object result : list) {
                System.out.println(result);
            }

            System.out.println("----------------------------------------------------------------------");
            Console.readLine("Press a key to continue..");
        }
    }

    @Override
    public void subscribe(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void unsubscribe(Observable observable) {
    this.observable.removeObserver(this);
    }

    @Override
    public void update() {
        System.out.println("warning : that expense is way too much for your budget !");
    }
}

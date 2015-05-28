package eapli.mymoney.presentation;

import eapli.mymoney.application.ListExpenseLimitsController;
import eapli.mymoney.application.ListExpenseTypesController;
import eapli.mymoney.application.ListPaymentMethodController;
import eapli.mymoney.application.RegisterExpenseController;
import eapli.mymoney.domain.*;
import eapli.util.Console;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Created by brunodevesa on 24/04/15.
 */
public class RegisterExpenseUI extends BaseUI implements Observer {

    public RegisterExpenseController getRegisterExpenseController() {
        return registerExpenseController;
    }

    private RegisterExpenseController registerExpenseController;

    public ExpenseType expenseType;
    private PaymentMethod paymentMethod;
    private Calendar date;
    private BigDecimal moneyValue;
    private ExpenseLimit expenseLimit;

    private Observable observable = null;

    public RegisterExpenseUI() {


    }

    @Override
    protected boolean doShow() {

        final ListExpenseTypesController theControllerExpenseTypes = new ListExpenseTypesController();

        int user_option_ET;
        do {
            new ListExpenseTypesUI().show();
            user_option_ET = Console.readInteger("Enter the Expense type:");

        } while (user_option_ET >= theControllerExpenseTypes.getAllExpenseTypes().size());

        final List<ExpenseType> expenseTypesList = theControllerExpenseTypes.getAllExpenseTypes();

        expenseType = expenseTypesList.get(user_option_ET);

        // testing
        ListExpenseLimitsController listExpenseLimitsController = new ListExpenseLimitsController();
        List<ExpenseLimit> listExpenseLimits = listExpenseLimitsController.getAllExpenseLimits();


        //<editor-fold desc="testing ExpenseLimits repo">
        for (int i = 0; i < listExpenseLimits.size(); i++) {
            if (listExpenseLimits.get(i).getExpenseType().description().equalsIgnoreCase(expenseType.description())) {

                System.out.println("test info:");
                System.out.println(listExpenseLimits.get(i).getLimitsByExpenseType(expenseType).toString());
            }
        }
        System.out.println("end of teste");
        //</editor-fold>


        final ListPaymentMethodController theControllerPayment = new ListPaymentMethodController();

        int user_option_PM;
        do {

            new ListPaymenteMethodsUI().show();
            user_option_PM = Console.readInteger("Enter the Payment Method:");

        } while (user_option_PM >= theControllerPayment.getAllPaymentMethod().size());

        final List<PaymentMethod> paymentTypeList = theControllerPayment.getAllPaymentMethod();

        paymentMethod = paymentTypeList.get(user_option_PM);

        date = Calendar.getInstance();
        moneyValue = BigDecimal.valueOf(Console.readInteger("Enter the expense value :"));

        submit();

        return true;
    }

    private void submit() {

        registerExpenseController = new RegisterExpenseController(this, moneyValue, expenseType, paymentMethod, date); // necessary to pass UI so the controller pass ot to the Event

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
        System.out.println("warning : i'm RegisterExpenseUI and i'm being notified : that expense is way too much for your budget !");
    }
}

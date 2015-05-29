package eapli.mymoney.application;

import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseRegisteredEvent;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;
import eapli.mymoney.presentation.RegisterExpenseUI;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class RegisterExpenseController {

    private BigDecimal moneyValue;
    private ExpenseType expenseType;
    private PaymentMethod paymentMethod;
    private Calendar date;

    ExpenseRepository repo = Persistence.getRepositoryFactory().getExpenseRepository();

    Expense expense;

    private RegisterExpenseUI registerExpenseUI; // adicionado

    private ExpenseRegisteredEvent expenseRegisteredEvent; // passar por parametro

    public AlertExpenseController alertExpenseController;

    public RegisterExpenseController(RegisterExpenseUI registerExpenseUI, BigDecimal moneyValue, ExpenseType expenseType, PaymentMethod paymentMethod, Calendar date) {
        this.moneyValue = moneyValue;
        this.expenseType = expenseType;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.registerExpenseUI = registerExpenseUI;

        this.expense = new Expense(moneyValue, expenseType, paymentMethod, date);

    }

    public Expense registerExpense() {

        expenseRegisteredEvent = new ExpenseRegisteredEvent(expense);
        alertExpenseController = new AlertExpenseController(registerExpenseUI, expenseRegisteredEvent, repo);

        return addExpense(expense);

    }

    public List<Expense> listAllExpenses() {
        return repo.all();
    }

    private Expense addExpense(Expense expense) {
        getRepo().add(expense) ;

          //  alertExpenseController.checkExpense();


        return expense;
    }

    private ExpenseRepository getRepo() {
        return repo;
    }

    public int getTotalExpensesByExpenseType(ExpenseType expenseType) {
        int totalExpenseValue = 0;
        List<Expense> listOfExpensesRegistered = repo.all();

        for (int i = 0; i < listOfExpensesRegistered.size(); i++) {
            if (listOfExpensesRegistered.get(i).getExpenseType().description().equalsIgnoreCase(expenseType.description()))
                totalExpenseValue += listOfExpensesRegistered.get(i).getAmount().intValue();
        }
        return totalExpenseValue;
    }

}

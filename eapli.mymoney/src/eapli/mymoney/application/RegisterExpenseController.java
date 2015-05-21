package eapli.mymoney.application;

import eapli.mymoney.domain.*;
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

    final ExpenseRepository repo = Persistence.getRepositoryFactory().getExpenseRepository();

    private RegisterExpenseUI registerExpenseUI; // adicionado

    private ExpenseRegisteredEvent expenseRegisteredEvent;

    public AlertExpenseController alertExpenseController;

    public RegisterExpenseController(RegisterExpenseUI registerExpenseUI, BigDecimal moneyValue, ExpenseType expenseType, PaymentMethod paymentMethod, Calendar date) {
        this.moneyValue = moneyValue;
        this.expenseType = expenseType;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.registerExpenseUI = registerExpenseUI;
    }

    public Expense registerExpense() {

        final Expense expense = new Expense(moneyValue, expenseType, paymentMethod, date);

        expenseRegisteredEvent = new ExpenseRegisteredEvent(expense);

        alertExpenseController = new AlertExpenseController(registerExpenseUI, expenseRegisteredEvent);

        alertExpenseController.checkExpense();


        return addExpense(expense);
    }

    public List<Expense> listAllExpenses() {
        return repo.all();
    }

    private Expense addExpense(Expense expense) {
        getRepo().add(expense);
        return expense;
    }

    private ExpenseRepository getRepo() {

        return repo;

    }
}

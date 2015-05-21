package eapli.mymoney.application;

import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseRegisteredEvent;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;

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
    private Expense expense;
    final ExpenseRepository repo = Persistence.getRepositoryFactory().getExpenseRepository();

    private ExpenseRegisteredEvent expenseRegisteredEvent;

    public RegisterExpenseController(BigDecimal moneyValue, ExpenseType expenseType, PaymentMethod paymentMethod, Calendar date) {
        this.moneyValue = moneyValue;
        this.expenseType = expenseType;
        this.paymentMethod = paymentMethod;
        this.date = date;

    }

    public Expense registerExpense() {

        expenseRegisteredEvent = new ExpenseRegisteredEvent(expense);

        final Expense expense = new Expense(moneyValue, expenseType, paymentMethod, date);
        return addExpense(expense);
    }

    public List<Expense> listAllExpenses() {
        return repo.all();
    }

    private Expense addExpense(Expense expense) {
        getRepo().add(expense);
        return expense;
    }

    public Expense getExpense(){
        return this.expense;
    }

    private ExpenseRepository getRepo(){

        return repo;

    }
}

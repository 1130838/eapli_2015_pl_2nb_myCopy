package eapli.mymoney.application;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class RegisterExpenseController {

        public Expense registerExpense(Money moneyValue, ExpenseType expenseType, PaymentMethod paymentMethod, Calendar date) {

            final Expense expense = new Expense(moneyValue, expenseType, paymentMethod, date);

            final ExpenseRepository repo = Persistence.getRepositoryFactory().getExpenseRepository();
            repo.add(expense);

            return expense;
        }

    public List<Expense> listAllExpenses() {

        final ExpenseRepository repo = Persistence.getRepositoryFactory().getExpenseRepository();

        return repo.all();
    }
}


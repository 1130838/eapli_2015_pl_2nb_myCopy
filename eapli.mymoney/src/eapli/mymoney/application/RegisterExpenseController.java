package eapli.mymoney.application;

import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;

import java.util.Date;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class RegisterExpenseController {

        Expense expense;

        public Expense registerExpense(float value, ExpenseType expenseType, PaymentMethod paymentMethod, Date date) {

            expense = new Expense(value, expenseType, paymentMethod, date);

            ExpenseRepository repo = Persistence.getRepositoryFactory().getExpenseRepository();
            repo.add(expense);

            return expense;
        }
    }


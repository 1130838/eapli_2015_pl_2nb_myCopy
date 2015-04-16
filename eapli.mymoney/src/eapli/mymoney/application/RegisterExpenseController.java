package eapli.mymoney.application;

import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;

import java.util.Date;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class RegisterExpenseController {

    Expense expense;

    public Expense registerExpense(float value, ExpenseType expenseType, PaymentMethod paymentMethod, Date date) {
        expense = new Expense(value, expenseType, paymentMethod, date);
        return expense;
    }

    public void save() {


    }

    private Expense getExpense() {
        return expense;
    }
}

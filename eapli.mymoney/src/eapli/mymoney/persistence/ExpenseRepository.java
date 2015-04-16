package eapli.mymoney.persistence;

import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;

import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public interface ExpenseRepository {


    public boolean registerExpense(Expense expense);

   // boolean addExpense (float value, ExpenseType expenseType, );
}

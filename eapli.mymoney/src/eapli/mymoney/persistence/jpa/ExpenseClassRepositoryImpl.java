package eapli.mymoney.persistence.jpa;

import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.ExpenseRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class ExpenseClassRepositoryImpl implements ExpenseRepository {


    @Override
    public boolean registerExpense(Expense expense) {
        return false;
    }
}

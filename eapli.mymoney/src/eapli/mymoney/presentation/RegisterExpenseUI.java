package eapli.mymoney.presentation;

import eapli.mymoney.application.RegisterExpenseController;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.Persistence;
import eapli.util.Console;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by brunodevesa on 24/04/15.
 */
public class RegisterExpenseUI extends BaseUI {

    private final RegisterExpenseController registerExpenseController = new RegisterExpenseController();

    float value = 1069;
    ExpenseType expensetype = new ExpenseType("vestuario");
    PaymentMethod paymentMethod = new PaymentMethod("cheque");
    Date date = Date.from(Instant.now());

    @Override
    protected boolean doShow() {
        submit();
        return true;
    }

    private void submit() {
        registerExpenseController.registerExpense(value, expensetype, paymentMethod, date);
    }

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE";
    }
}

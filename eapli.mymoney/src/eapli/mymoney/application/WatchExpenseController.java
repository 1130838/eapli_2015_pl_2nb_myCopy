package eapli.mymoney.application;

import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.LimitWatchDog_AlertExpense;
import eapli.mymoney.presentation.RegisterExpenseUI;

import java.math.BigDecimal;

/**
 * Created by bruno.devesa on 20-05-2015.
 */


public class WatchExpenseController {

    Expense expense;
    RegisterExpenseUI registerExpenseUI;

    LimitWatchDog_AlertExpense limitWatchDog_alertExpense;

    public WatchExpenseController(RegisterExpenseUI registerExpenseUI, Expense expense) {
        this.registerExpenseUI = registerExpenseUI;
        this.expense = expense;


    }


}

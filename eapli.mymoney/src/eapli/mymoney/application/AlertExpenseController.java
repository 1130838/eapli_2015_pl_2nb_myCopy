package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseRegisteredEvent;
import eapli.mymoney.domain.LimitWatchDog_Expense;
import eapli.mymoney.presentation.RegisterExpenseUI;

/**
 * Created by bruno.devesa on 20-05-2015.
 */


public class AlertExpenseController {

    ExpenseRegisteredEvent expenseRegisteredEvent;
    RegisterExpenseUI registerExpenseUI;

    LimitWatchDog_Expense limitWatchDog_Expense;

    public AlertExpenseController(RegisterExpenseUI registerExpenseUI, ExpenseRegisteredEvent expenseRegisteredEvent) {
        this.registerExpenseUI = registerExpenseUI;
        this.expenseRegisteredEvent = expenseRegisteredEvent;

        limitWatchDog_Expense = new LimitWatchDog_Expense(registerExpenseUI, expenseRegisteredEvent); // to be able to subscribe UI as a observer of Watch^Dog

        registerExpenseUI.subscribe(limitWatchDog_Expense); // UI wants to know about limitWatchDog_Expense
        limitWatchDog_Expense.addObserver(registerExpenseUI); // limitWatchDog_Expense wants to be observed by UI

    }

    public void checkExpense(){
        limitWatchDog_Expense.isViolated();
    }


}

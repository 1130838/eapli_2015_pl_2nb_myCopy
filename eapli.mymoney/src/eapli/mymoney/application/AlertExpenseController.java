package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseRegisteredEvent;
import eapli.mymoney.domain.LimitWatchDog_AlertExpense;
import eapli.mymoney.presentation.RegisterExpenseUI;

/**
 * Created by bruno.devesa on 20-05-2015.
 */


public class AlertExpenseController {

    ExpenseRegisteredEvent expenseRegisteredEvent;
    RegisterExpenseUI registerExpenseUI;

    LimitWatchDog_AlertExpense limitWatchDog_alertExpense;

    public AlertExpenseController(RegisterExpenseUI registerExpenseUI, ExpenseRegisteredEvent expenseRegisteredEvent) {
        this.registerExpenseUI = registerExpenseUI;
        this.expenseRegisteredEvent = expenseRegisteredEvent;

        registerExpenseUI.subscribe(expenseRegisteredEvent); // UI wants to know about expenseRegisteredEvens
        expenseRegisteredEvent.addObserver(registerExpenseUI); // expenseEvent wants to be observed by UI

    }

    public void checkExpense(){
        limitWatchDog_alertExpense = new LimitWatchDog_AlertExpense(registerExpenseUI, expenseRegisteredEvent); // to be able to subscribe UI as a Watch^Dog Observer
        limitWatchDog_alertExpense.isViolated();
    }


}

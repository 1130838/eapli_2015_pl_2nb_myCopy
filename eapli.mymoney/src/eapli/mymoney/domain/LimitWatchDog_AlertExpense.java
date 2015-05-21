package eapli.mymoney.domain;

import eapli.mymoney.presentation.RegisterExpenseUI;

/**
 * Created by brunodevesa on 14/05/15.
 */
public class LimitWatchDog_AlertExpense implements Limitable, Observable {

    ExpenseRegisteredEvent expenseRegisteredEvent; // what he will observe
    RegisterExpenseUI registerExpenseUI;
    Observable observable = null;

    public LimitWatchDog_AlertExpense(RegisterExpenseUI registerExpenseUI, ExpenseRegisteredEvent expenseRegisteredEvent) {
        this.expenseRegisteredEvent = expenseRegisteredEvent;
        this.registerExpenseUI = registerExpenseUI;
    }


    @Override
    public boolean isViolated() {
        if (expenseRegisteredEvent.expense.amount.intValue() > 69) { // 69 for testing purposes
            expenseRegisteredEvent.notifyObservers();
            return true;
        }else{
            return false;
        }


    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}

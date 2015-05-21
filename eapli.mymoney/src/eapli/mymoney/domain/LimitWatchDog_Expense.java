package eapli.mymoney.domain;

import eapli.mymoney.presentation.RegisterExpenseUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunodevesa on 14/05/15.
 */
public class LimitWatchDog_Expense implements Limitable, Observable {

    List<Observer> listOfObservers = new ArrayList<>();

    ExpenseRegisteredEvent expenseRegisteredEvent; // what he will observe
    RegisterExpenseUI registerExpenseUI;
    Observable observable = null;

    public LimitWatchDog_Expense(RegisterExpenseUI registerExpenseUI, ExpenseRegisteredEvent expenseRegisteredEvent) {
        this.expenseRegisteredEvent = expenseRegisteredEvent;
        this.registerExpenseUI = registerExpenseUI;
    }

    @Override
    public boolean isViolated() {
        if (expenseRegisteredEvent.expense.amount.intValue() > 69) { // 69 for testing purposes. must be created LimitRepository and get the limits there 
            notifyObservers();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void addObserver(Observer observer) {
        listOfObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listOfObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (int i = 0; i < listOfObservers.size(); i++) {
            listOfObservers.get(i).update();
        }

    }
}

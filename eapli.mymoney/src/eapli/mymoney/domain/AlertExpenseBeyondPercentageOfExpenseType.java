package eapli.mymoney.domain;

import java.util.List;
import java.util.Observer;

/**
 * Created by brunodevesa on 14/05/15.
 */
public class AlertExpenseBeyondPercentageOfExpenseType implements Observable {

    private List<Observer> observerList;
    private Expense expense;


    @Override
    public void addObserver(Observer o) {

    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers() {

    }


    public void ExpenseBeyondLimits(){
        notifyObservers();
    }
}

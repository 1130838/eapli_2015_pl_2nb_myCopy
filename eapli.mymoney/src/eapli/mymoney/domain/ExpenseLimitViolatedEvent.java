package eapli.mymoney.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno.devesa on 28-05-2015.
 */
public class ExpenseLimitViolatedEvent implements Observable {
    ExpenseRegisteredEvent expenseRegisterEvent;

    public ExpenseLimitViolatedEvent( ExpenseRegisteredEvent expenseRegisterEvent) {
        this.expenseRegisterEvent = expenseRegisterEvent;
    }

    List<Observer> listOfInterested = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        listOfInterested.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < listOfInterested.size() ; i++) {
            listOfInterested.get(i).update();
        }
    }
}

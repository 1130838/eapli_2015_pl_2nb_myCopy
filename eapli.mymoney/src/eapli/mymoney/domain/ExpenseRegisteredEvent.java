package eapli.mymoney.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunodevesa on 21/05/15.
 */
public class ExpenseRegisteredEvent implements Observable {

    Expense expense;

    List<Observer> listOfObservers = new ArrayList<>();

    public ExpenseRegisteredEvent(Expense expense) {
        this.expense = expense;
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

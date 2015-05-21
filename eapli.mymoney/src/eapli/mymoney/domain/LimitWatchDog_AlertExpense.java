package eapli.mymoney.domain;

/**
 * Created by brunodevesa on 14/05/15.
 */
public class LimitWatchDog_AlertExpense implements Limitable {

    ExpenseRegisteredEvent expenseRegisteredEvent; // what he will observe
    Observable observable = null;

    public LimitWatchDog_AlertExpense(ExpenseRegisteredEvent expenseRegisteredEvent) {
        this.expenseRegisteredEvent = expenseRegisteredEvent;
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
}

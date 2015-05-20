package eapli.mymoney.domain;

/**
 * Created by brunodevesa on 14/05/15.
 */
public class LimitWatchDog_AlertExpense {

    Expense expense; // what he will observe
    Observable observable = null;

    public LimitWatchDog_AlertExpense(Expense expense) {
        this.expense = expense;
    }

    public boolean isViolated() {
        return this.expense.amount.intValue() > 69;
    }


}

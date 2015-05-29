package eapli.mymoney.domain;

/**
 * Created by brunodevesa on 21/05/15.
 */
public class ExpenseRegisteredEvent {

    private Expense expense;

    public ExpenseRegisteredEvent(Expense expense) {
        this.expense = expense;
    }

    public Expense getExpense() {
        return expense;
    }

}

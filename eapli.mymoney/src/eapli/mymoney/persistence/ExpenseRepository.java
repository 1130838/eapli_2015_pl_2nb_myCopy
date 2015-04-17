package eapli.mymoney.persistence;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.Period;

/**
 * Created by brunodevesa on 16/04/15.
 */
public interface ExpenseRepository {

	public boolean registerExpense(Expense expense);

	// boolean addExpense (float value, ExpenseType expenseType, );
	public Money getWeekExpediture(Period period);
}

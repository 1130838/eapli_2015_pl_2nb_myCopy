package eapli.mymoney.persistence.jpa;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.Period;
import eapli.mymoney.persistence.ExpenseRepository;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class ExpenseClassRepositoryImpl implements ExpenseRepository {

	@Override
	public boolean registerExpense(Expense expense) {
		return false;
	}

	@Override
	public Money getWeekExpediture(Period period) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}

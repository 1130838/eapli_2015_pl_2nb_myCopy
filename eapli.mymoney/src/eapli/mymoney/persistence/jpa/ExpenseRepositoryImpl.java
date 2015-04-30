package eapli.mymoney.persistence.jpa;

import eapli.framework.model.Money;
import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.Period;
import eapli.mymoney.persistence.ExpenseRepository;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class ExpenseRepositoryImpl
	extends JpaRepository<Expense, Integer>
	implements ExpenseRepository {

	@Override
	public Money getWeekExpediture(Period period) {
		Money total = Money.euros(0.00);

		for (Expense expense : all()) {
			if (period.isBetween(expense.getDate())) {
				total = total.
					add(Money.euros(expense.getAmount().doubleValue()));
			}
		}

		return total;
	}

	@Override
	protected String persistenceUnitName() {
		return PersistenceSettings.PERSISTENCE_UNIT_NAME;
	}

}

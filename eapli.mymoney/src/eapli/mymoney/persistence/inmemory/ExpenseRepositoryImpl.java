package eapli.mymoney.persistence.inmemory;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.Period;
import eapli.mymoney.persistence.ExpenseRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by brunodevesa on 17/04/15.
 */
public class ExpenseRepositoryImpl
	implements ExpenseRepository {

	private static final List<Expense> data = new ArrayList<>();

	@Override
	public boolean add(Expense expense) {
		if (expense == null) {
			throw new IllegalArgumentException();
		}
		if (data.contains(expense)) {
			//TODO rever se deviamos ter outra exceção mais significativa
			throw new IllegalStateException();
		}
		return data.add(expense);
	}

	@Override
	public long size() {
		return data.size();
	}

	@Override
	public List<Expense> all() {
		return Collections.unmodifiableList(data);
	}

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
	public Money getMonthExpediture(Period period) {
		Money total = Money.euros(0.00);

		for (Expense expense : all()) {
			if (period.isBetween(expense.getDate())) {
				total = total.
					add(Money.euros(expense.getAmount().doubleValue()));
			}
		}

		return total;
	}

}

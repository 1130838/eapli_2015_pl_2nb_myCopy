package eapli.mymoney.application;

import eapli.framework.model.Money;
import eapli.mymoney.domain.DateTime;
import eapli.mymoney.domain.Period;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;
import eapli.mymoney.persistence.RepositoryFactory;

public class ListWeekExpeditureController {

	public ListWeekExpeditureController() {
	}

	public Money getWeekExpediture() {
		Period period = DateTime.thisWeek();

		RepositoryFactory repositoryFactory = Persistence.getRepositoryFactory();

		ExpenseRepository expenseRepository = repositoryFactory.
			getExpenseRepository();

		return expenseRepository.getWeekExpediture(period);
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.framework.model.Money;
import eapli.mymoney.domain.DateTime;
import eapli.mymoney.domain.Period;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;
import eapli.mymoney.persistence.RepositoryFactory;

/**
 *
 * @author ferreirai
 */
public class MonthlyExpenseController {

	public Money getMonthExpediture() {
		Period period = DateTime.thisMonth();

		RepositoryFactory repositoryFactory = Persistence.getRepositoryFactory();

		ExpenseRepository expenseRepository = repositoryFactory.
			getExpenseRepository();

		return expenseRepository.getMonthExpediture(period);
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.jpa;

import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.domain.ExpenseGroup;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import javax.persistence.RollbackException;

/**
 *
 * @author Luís
 */
public class ExpenseGroupRepositoryImpl
	extends JpaRepository<ExpenseGroup, String>
	implements ExpenseGroupRepository {

	@Override
	public boolean add(ExpenseGroup expenseType) {
		try {
			super.add(expenseType);
		} catch (RollbackException ex) {
			throw new IllegalStateException();
		}
		return true;
	}

	@Override
	protected String persistenceUnitName() {
		return PersistenceSettings.PERSISTENCE_UNIT_NAME;
	}

	@Override
	public ExpenseGroup findById(String id) {
		return super.findById(id);
	}

}

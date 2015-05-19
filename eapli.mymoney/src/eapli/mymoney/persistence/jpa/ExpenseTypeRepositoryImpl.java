/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.jpa;

import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import java.util.List;
import javax.persistence.RollbackException;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeRepositoryImpl
	extends JpaRepository<ExpenseType, Integer>
	implements ExpenseTypeRepository {

	@Override
	public boolean add(ExpenseType expenseType) {
		try {
			super.add(expenseType);
		} catch (RollbackException ex) {
			throw new IllegalStateException();
		}
		return true;
	}

	@Override
	public List<ExpenseType> all() {

		return (List<ExpenseType>) this.findAll();
	}

	@Override
	protected String persistenceUnitName() {
		return PersistenceSettings.PERSISTENCE_UNIT_NAME;
	}

	@Override
	public ExpenseType findById(int id) {
		return super.findById(id);
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.jpa;

import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import javax.persistence.RollbackException;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeRepositoryImpl
        extends JpaRepository<ExpenseType, String>
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
    protected String persistenceUnitName() {
        return PersistenceSettings.PERSISTENCE_UNIT_NAME;
    }
}

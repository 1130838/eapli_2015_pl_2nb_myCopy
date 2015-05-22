package eapli.mymoney.persistence.jpa;

import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.domain.ExpenseLimit;
import eapli.mymoney.persistence.ExpenseLimitRepository;

import javax.persistence.RollbackException;
import java.util.List;

/**
 * Created by brunodevesa on 22/05/15.
 */
public class ExpenseLimitRepositoryImpl
        extends JpaRepository<ExpenseLimit, Integer>
        implements ExpenseLimitRepository {


    @Override
    public boolean add(ExpenseLimit expenseLimit) {
        try {
            super.add(expenseLimit);
        } catch (RollbackException ex) {
            throw new IllegalStateException();
        }
        return true;
    }

    @Override
    public List<ExpenseLimit> all() {

        return (List<ExpenseLimit>) this.findAll();
    }

    @Override
    protected String persistenceUnitName() {
        return PersistenceSettings.PERSISTENCE_UNIT_NAME;
    }

    @Override
    public ExpenseLimit findById(int id) {
        return super.findById(id);
    }
}

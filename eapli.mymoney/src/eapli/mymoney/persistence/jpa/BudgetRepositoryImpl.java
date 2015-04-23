/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.jpa;

import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.domain.Budget;
import eapli.mymoney.persistence.BudgetRepository;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ferreirai
 */
public class BudgetRepositoryImpl extends JpaRepository<Budget, String>
        implements BudgetRepository {

    public boolean add(Budget budget) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(persistenceUnitName());
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(budget);
        em.getTransaction().commit();
        System.out.println("ID gerado: " + budget.getId());
        em.close();
        emf.close();
        return true;
    }

    @Override
    public long size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Budget> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Budget> iterator(int pagesize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String persistenceUnitName() {
        return PersistenceSettings.PERSISTENCE_UNIT_NAME;
    }
}

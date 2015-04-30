/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.jpa;

import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.domain.Budget;
import eapli.mymoney.domain.Entry;
import eapli.mymoney.persistence.BudgetRepository;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ferreirai
 */
public class BudgetRepositoryImpl extends JpaRepository<Budget, String>
	implements BudgetRepository {

	public boolean add(Budget budget) {
		EntityManagerFactory emf
			= this.entityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(budget);

		for (Iterator iterator = budget.getCildren().iterator(); iterator.
			hasNext();) {
			Entry next = (Entry) iterator.next();
			next.addParent(budget);
			em.persist(next);
//			ExpenseType eType = (ExpenseType) next.getBudgetLine();
//			em.persist(eType);
		}
		em.getTransaction().commit();
		System.out.println("ID gerado: " + budget.getId());
		em.close();
		emf.close();
		return true;
	}

	@Override
	public long size() {
		return this.size();
	}

	@Override
	public List<Budget> all() {
		return (List<Budget>) this.findAll();
	}

	@Override
	public Iterator<Budget> iterator(int pagesize) {
		return this.iterator(pagesize);
	}

	@Override
	protected String persistenceUnitName() {
		return PersistenceSettings.PERSISTENCE_UNIT_NAME;
	}
}

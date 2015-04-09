/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence;

import eapli.mymoney.ExpenseManagerSettings;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * provides easy access to the persistence layer
 *
 * works as a factory of factories
 *
 * @author Paulo Gandra Sousa
 */
public final class Persistence {

	// TODO deviamos considerar fazer o refactorign (rename) deste método
	// para factory() ou repositories()
	public static RepositoryFactory getRepositoryFactory() {
		// return new InMemoryRepositoryFactory();
		// return new JpaRepositoryFactory();

		String factoryClassName = ExpenseManagerSettings.instance().
			getRepositoryFactory();
		try {
			return (RepositoryFactory) Class.forName(factoryClassName).
				newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
			//FIXME handle exception properly
			return null;
		}
	}

	private Persistence() {
	}

	// FIXME não sei se está bem aqui arrumado?
	// TODO deviamos usar a classe base JpaRepository do projeto framework
	@Deprecated
	public static EntityManager EntityManagerInit() {
		EntityManagerFactory factory = javax.persistence.Persistence.
			createEntityManagerFactory("eapli.ExpenseManagerPU");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
}

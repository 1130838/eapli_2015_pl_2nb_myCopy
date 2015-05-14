/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.inmemory;

import eapli.mymoney.domain.Budget;
import eapli.mymoney.persistence.BudgetRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ferreirai
 */
public class BudgetRepositoryImpl implements BudgetRepository {

	private static final List<Budget> DATA
		= new ArrayList<Budget>();

	public boolean add(Budget budget) {
		if (budget == null) {
			throw new IllegalArgumentException();
		}
		if (DATA.contains(budget)) {
			//TODO rever se deviamos ter outra exceção mais significativa
			throw new IllegalStateException();
		}
		return DATA.add(budget);
	}

	@Override
	public long size() {
		return DATA.size();
	}

	@Override
	public List<Budget> all() {
		return Collections.unmodifiableList(DATA);
	}

	@Override
	public Iterator<Budget> iterator(int pagesize) {
		return DATA.iterator();
	}

	@Override
	public Budget update(Budget budget) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}

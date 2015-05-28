/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.inmemory;

import eapli.framework.persistence.inmemory.InmemoryRepository;
import eapli.mymoney.domain.ExpenseGroup;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Luís
 */
public class ExpenseGroupRepositoryImpl extends InmemoryRepository<ExpenseGroup, String> implements ExpenseGroupRepository {

	/**
	 * Container with data.
	 */
	private static final List<ExpenseGroup> data
		= new ArrayList<ExpenseGroup>();

	@Override
	public final boolean add(final ExpenseGroup expenseGroup) {
		if (expenseGroup == null) {
			throw new IllegalArgumentException();
		}
		if (data.contains(expenseGroup)) {
			//TODO rever se deviamos ter outra exceção mais significativa
			throw new IllegalStateException();
		}
		return data.add(expenseGroup);
	}

	@Override
	public long size() {
		return data.size();
	}

	/**
	 * Checks if a expense group exists in the repository.
	 *
	 * @param group to check existence
	 * @return true - exist<br>false - not exist
	 */
	@Override
	public boolean contains(final ExpenseGroup group) {
		return data.contains(group);
	}

	@Override
	public List<ExpenseGroup> all() {
		return Collections.unmodifiableList(data);
	}

	@Override
	public Iterator<ExpenseGroup> iterator(final int pagesize) {
		return data.iterator();
	}

	@Override
	public ExpenseGroup findById(String id) {
		for (ExpenseGroup expenseGroup : this.data) {
			if (expenseGroup.getName() == id) {
				return expenseGroup;
			}
		}
		throw new NullPointerException("Element not found.");
	}

	@Override
	public List<ExpenseGroup> findByYear(int year) {

		List<ExpenseGroup> le = new ArrayList<>();

		for (ExpenseGroup eg : all()) {
			if (eg.obtainExpenseYear() == year) {
				le.add(eg);
			}
		}

		return le;

	}

	@Override
	public ExpenseGroup save(ExpenseGroup objecto) {
		int i;
		for (i = 0; i < data.size(); i++) {
			if (data.get(i).getName() == objecto.getName()) {
				data.remove(i);
				data.add(i, objecto);
			}
		}
		data.add(objecto);
		return objecto;
	}

	@Override
	public List<ExpenseGroup> getList() {
		return this.data;
	}
}

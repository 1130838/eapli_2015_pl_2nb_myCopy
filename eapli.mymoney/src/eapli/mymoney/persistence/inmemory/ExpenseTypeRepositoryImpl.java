/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.inmemory;

import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeRepositoryImpl implements ExpenseTypeRepository {

	private static final List<ExpenseType> data = new ArrayList<ExpenseType>();

	@Override
	public boolean add(ExpenseType expenseType) {
		if (expenseType == null) {
			throw new IllegalArgumentException();
		}
		if (data.contains(expenseType)) {
			//TODO rever se deviamos ter outra exceção mais significativa
			throw new IllegalStateException();
		}
		return data.add(expenseType);
	}

	@Override
	public long size() {
		return data.size();
	}

	// TODO check if we realy need this method
	public boolean contains(ExpenseType vestuario) {
		return data.contains(vestuario);
	}

	@Override
	public List<ExpenseType> all() {
		return Collections.unmodifiableList(data);
	}

	@Override
	public Iterator<ExpenseType> iterator(int pagesize) {
		return data.iterator();
	}

	@Override
	public ExpenseType findById(int id) {
		for (ExpenseType expenseType : this.data) {
			if (expenseType.getID() == id) {
				return expenseType;
			}
		}
		throw new NullPointerException("Element not found.");
	}
}

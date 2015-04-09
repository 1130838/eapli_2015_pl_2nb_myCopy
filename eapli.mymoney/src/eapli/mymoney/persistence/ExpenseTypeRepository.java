/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence;

import eapli.mymoney.domain.ExpenseType;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface ExpenseTypeRepository {

	/**
	 * adds a new expense type to the repository if there is already an expense
	 * type with the same description, an IllegalStateOperation will be thrown
	 *
	 * @param expenseType
	 * @throws IllegalsStateException if there is already an expense type with
	 * the same description
	 */
	boolean add(ExpenseType expenseType);

	long size();

	List<ExpenseType> all();

	public Iterator<ExpenseType> iterator(int pagesize);
}

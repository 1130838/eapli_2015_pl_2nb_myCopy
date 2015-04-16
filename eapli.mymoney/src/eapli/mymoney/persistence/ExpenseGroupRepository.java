/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence;

import eapli.mymoney.domain.ExpenseGroup;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joel
 */
public interface ExpenseGroupRepository {

    /**
     * adds a new expense group to the repository if there is already an expense
     * group with the same description, an IllegalStateOperation will be thrown
     *
     * @param expenseType
     * @throws IllegalsStateException if there is already an expense type with
     * the same description
     */
    boolean add(ExpenseGroup expenseGroup);

    long size();

    List<ExpenseGroup> all();

    public Iterator<ExpenseGroup> iterator(int pagesize);
}

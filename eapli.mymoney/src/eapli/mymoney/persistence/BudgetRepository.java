/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence;

import eapli.mymoney.domain.Budget;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ferreirai
 */
public interface BudgetRepository {

    public boolean add(Budget budget);

    public long size();

    public List<Budget> all();

    public Iterator<Budget> iterator(int pagesize);
}

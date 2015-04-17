/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.inmemory;

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
public class ExpenseGroupRepositoryImpl implements ExpenseGroupRepository {

    private static final List<ExpenseGroup> data = new ArrayList<ExpenseGroup>();

    @Override
    public boolean add(ExpenseGroup expenseGroup) {
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

    // TODO check if we realy need this method
    public boolean contains(ExpenseGroup group) {
        return data.contains(group);
    }

    @Override
    public List<ExpenseGroup> all() {
        return Collections.unmodifiableList(data);
    }

    @Override
    public Iterator<ExpenseGroup> iterator(int pagesize) {
        return data.iterator();
    }
}

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

    /**
     * Container with data.
     */
    private static final List<ExpenseGroup> DATA
            = new ArrayList<ExpenseGroup>();

    @Override
    public final boolean add(final ExpenseGroup expenseGroup) {
        if (expenseGroup == null) {
            throw new IllegalArgumentException();
        }
        if (DATA.contains(expenseGroup)) {
            //TODO rever se deviamos ter outra exceção mais significativa
            throw new IllegalStateException();
        }
        return DATA.add(expenseGroup);
    }

    @Override
    public final long size() {
        return DATA.size();
    }

    /**
     * Checks if a expense group exists in the repository.
     *
     * @param group to check existence
     * @return true - exist<br>false - not exist
     */
    public final boolean contains(final ExpenseGroup group) {
        return DATA.contains(group);
    }

    @Override
    public final List<ExpenseGroup> all() {
        return Collections.unmodifiableList(DATA);
    }

    @Override
    public final Iterator<ExpenseGroup> iterator(final int pagesize) {
        return DATA.iterator();
    }
}

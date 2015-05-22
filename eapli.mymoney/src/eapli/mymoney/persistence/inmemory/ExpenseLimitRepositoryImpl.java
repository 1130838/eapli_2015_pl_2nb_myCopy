package eapli.mymoney.persistence.inmemory;

import eapli.mymoney.domain.ExpenseLimit;
import eapli.mymoney.persistence.ExpenseLimitRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brunodevesa on 22/05/15.
 */
public class ExpenseLimitRepositoryImpl  implements ExpenseLimitRepository{

    private static final List<ExpenseLimit> data = new ArrayList<ExpenseLimit>();

    @Override
    public boolean add(ExpenseLimit expenseLimit) {
        if (expenseLimit == null) {
            throw new IllegalArgumentException();
        }
        if (data.contains(expenseLimit)) {
            //TODO rever se deviamos ter outra exceção mais significativa
            throw new IllegalStateException();
        }
        return data.add(expenseLimit);
    }

    @Override
    public long size() {
        return data.size();
    }

    // TODO check if we realy need this method
    public boolean contains(ExpenseLimit vestuario) {
        return data.contains(vestuario);
    }

    @Override
    public List<ExpenseLimit> all() {
        return Collections.unmodifiableList(data);
    }

    @Override
    public Iterator<ExpenseLimit> iterator(int pagesize) {
        return data.iterator();
    }

    @Override
    public ExpenseLimit findById(int id) {
        for (ExpenseLimit expenseLimit : this.data) {
            if (expenseLimit.getID() == id) {
                return expenseLimit;
            }
        }
        throw new NullPointerException("Element not found.");
    }
}

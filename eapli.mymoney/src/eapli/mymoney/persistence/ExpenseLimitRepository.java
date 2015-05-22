package eapli.mymoney.persistence;

import eapli.mymoney.domain.ExpenseLimit;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bruno.devesa on 21-05-2015.
 */
public interface ExpenseLimitRepository {

    boolean add(ExpenseLimit expenseLimit);

    long size();

    List<ExpenseLimit> all();

    public Iterator<ExpenseLimit> iterator(int pagesize);

    /**
     * Find an expense type by the ID
     *
     * @param id ID of the expense type
     * @return expense type object
     */
    ExpenseLimit findById(int id);



}

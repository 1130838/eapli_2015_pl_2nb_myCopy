/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import eapli.mymoney.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ListExpenseTypesController {

    public List<ExpenseType> getAllExpenseTypes() {
        ExpenseTypeRepository repo = Persistence.getRepositoryFactory().
                getExpenseTypeRepository();
        return repo.all();
    }

    // demo purposes
    public Iterator<ExpenseType> iterator() {
        ExpenseTypeRepository repo = Persistence.getRepositoryFactory().
                getExpenseTypeRepository();
        // using a pagesize=1 for DEBUG ONLY
        return repo.iterator(1);
    }
}

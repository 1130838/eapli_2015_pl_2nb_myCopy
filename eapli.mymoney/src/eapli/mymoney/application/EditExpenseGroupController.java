/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseGroup;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import eapli.mymoney.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author joaomonteiro
 */
public class EditExpenseGroupController {

    /**
     * Register a new expense group.
     *
     * @param expenseGroupText name
     * @param beginPeriod beginning of period
     * @param endPeriod end of period
     * @param estimation The value of the budget estimation
     */
    public final void editExpenseGroup(final String expenseGroupText,
            final Calendar beginPeriod, final Calendar endPeriod,
            final BigDecimal estimation) {
        final ExpenseGroup expenseGroup = new ExpenseGroup(expenseGroupText,
                beginPeriod, endPeriod, estimation);
        final ExpenseGroupRepository repo = Persistence.getRepositoryFactory().
                getExpenseGroupRepository();
        repo.add(expenseGroup);
    }

    /**
     * get list of expense groups.
     *
     * @return listexpenseGroups
     */
    public List<String> getListExpenseGroup() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * TODO : Code to get data Begin Period of the expense group
     *
     * @param expenseGroup
     * @return beginPeriod
     */
    public Calendar getBeginPeriod(String expenseGroup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * TODO : Code to get data getExtimation of the expense group
     *
     * @param expenseGroup
     * @return getEstimation
     */
    public BigDecimal getEstimation(String expenseGroup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * TODO : Code to get data endPeriod of the expense group
     *
     * @param expenseGroup
     * @return endPeriod
     */
    public Calendar getEndPeriod(String expenseGroup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

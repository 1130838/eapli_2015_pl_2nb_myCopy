/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Joel
 */
@Entity
public class ExpenseGroup implements Serializable {

    /**
     * Name of the group.
     */
    @Id
    private String name;
    /**
     * Period in witch the group can be used.
     */
    private Period period;
    /**
     * This argument is opcional and sets a budget for the current group.
     */
    private BigDecimal estimation;
    private int disable;

    public ExpenseGroup() {

    }

    /**
     * Creates Expense Group.
     *
     * @param expenseGroupText Expense Group name
     * @param beginPeriod Beginning of period
     * @param endPeriod End of period
     * @param budgetEstimation The value of budget estimation
     * @param disable 1 to enable by default , o to disable
     */
    public ExpenseGroup(final String expenseGroupText,
            final Calendar beginPeriod,
            final Calendar endPeriod,
            final BigDecimal budgetEstimation,
            final int disable
    ) {
        this.name = expenseGroupText;
        this.period = new Period(beginPeriod, endPeriod);
        this.estimation = budgetEstimation;
        this.disable = 1;
    }

    /**
     * Edit Expense Group.
     *
     * @param expenseGroupText Expense Group name
     * @param beginPeriod Beginning of period
     * @param endPeriod End of period
     * @param budgetEstimation The value of budget estimation
     * @param disable1
     */
    public void editExpenseGroup(final String expenseGroupText,
            final Calendar beginPeriod,
            final Calendar endPeriod,
            final BigDecimal budgetEstimation,
            final int disable1) {
        this.name = expenseGroupText;
        this.period = new Period(beginPeriod, endPeriod);
        this.estimation = budgetEstimation;
        this.disable = disable1;
    }
}

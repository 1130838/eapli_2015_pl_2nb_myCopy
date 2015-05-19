/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import eapli.util.Validations;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	/*
	 * This attribute allows us to control the current status of this group.
	 */
	private boolean status;
        
        private String text;

	/**
	 * ExpenseTypes associated with this Expense Group (UC-G-006)
	 */
	@OneToMany
	private List<ExpenseType> expenseTypes;

	public ExpenseGroup() {

	}

	/**
	 * Creates Expense Group.
	 *
	 * @param expenseGroupText Expense Group name
	 * @param beginPeriod Beginning of period
	 * @param endPeriod End of period
	 * @param budgetEstimation The value of budget estimation
	 */
	public ExpenseGroup(final String expenseGroupText,
						final Calendar beginPeriod,
						final Calendar endPeriod,
						final BigDecimal budgetEstimation
	) {
		this.name = expenseGroupText;
		this.period = new Period(beginPeriod, endPeriod);
		this.estimation = budgetEstimation;
		this.status = true;
		this.expenseTypes = new ArrayList<>();
	}

	/**
	 * Construtor com pârametro de status
	 *
	 * @param expenseGroupText Expense Group name
	 * @param beginPeriod Beginning of period
	 * @param endPeriod End of period
	 * @param budgetEstimation The value of budget estimation
	 * @param status boolean -> true to enable (default), false to disable
	 */
	public ExpenseGroup(final String expenseGroupText,
						final Calendar beginPeriod,
						final Calendar endPeriod,
						final BigDecimal budgetEstimation,
						final boolean status) {
		this.name = expenseGroupText;
		this.period = new Period(beginPeriod, endPeriod);
		this.estimation = budgetEstimation;
		this.status = status;
		this.expenseTypes = new ArrayList<>();
	}

	/**
	 * Add expense type to the accepted expense type list of this group.
	 *
	 * @param expenseType expense type object
	 */
	public void addExpenseType(ExpenseType expenseType) {
		this.expenseTypes.add(expenseType);
	}
        
            public ExpenseGroup(final String text) {
                if (Validations.isNullOrWhiteSpace(text)) {
                    throw new IllegalArgumentException();
                }
                this.text = text;
            }
                public String description() {
                     return text;
                 }
                
                @Override
                public boolean equals(Object other) {
                    if (other == null) {
                        return false;
                    }
                    if (other == this) {
                        return true;
                    }
                    if (!(other instanceof ExpenseType)) {
                        return false;
                    }
                    ExpenseType etOther = (ExpenseType) other;
                    return this.description().equals(etOther.description());
                }

                @Override
                public int hashCode() {
                    int hash = 7;
                    hash = 41 * hash + (this.text != null ? this.text.hashCode() : 0);
                    return hash;
                } 

	/**
	 * Get the expense group name
	 *
	 * @return expense group name (string)
	 */
	public String getName() {
		return name;
	}
}

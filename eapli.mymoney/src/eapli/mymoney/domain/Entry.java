/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import eapli.framework.model.Money;
import eapli.framework.patterns.DomainEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ferreirai
 */
@Entity
@Table(name = "ENTRY")
public class Entry implements Serializable, DomainEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDENTRY")
	private long idEntry;

	public Entry() {
	}

	@JoinColumn(name = "EXPENSETYPEID")
	private ExpenseType budgetLine;

	@Column(name = "IDVALUE")
	private Money value;

	private Budget parent;

//	@ManyToOne
//	@JoinColumn(name = "IDBUDGET")
	public Budget getBudget() {
		return getParent();
	}

	public Entry(ExpenseType budgetLine, Money value) {
		this.budgetLine = budgetLine;
		this.value = value;
	}

	public void addParent(Budget parent) {
		this.setParent(parent);
	}

	/**
	 * @return the budgetLine
	 */
	public BudgetLine getBudgetLine() {
		return budgetLine;
	}

	/**
	 * @param budgetLine the budgetLine to set
	 */
	public void changeBudgetLine(ExpenseType budgetLine) {
		this.budgetLine = budgetLine;
	}

	/**
	 * @return the value
	 */
	public Money getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void changeValue(Money value) {
		this.value = value;
	}

	/**
	 * @return the id
	 */
	@Id
	public long getId() {
		return idEntry;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.idEntry = id;
	}

	/**
	 * @return the parent
	 */
	public Budget getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Budget parent) {
		this.parent = parent;
	}

	@Override
	public Long id() {
		return new Long(this.getId());
	}

}

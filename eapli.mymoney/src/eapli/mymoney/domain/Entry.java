/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import eapli.framework.model.Money;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ferreirai
 */
@Entity
@Table(name = "ENTRY")
public class Entry implements Serializable {

	public Entry() {

	}

	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private BudgetLine budgetLine;
	private Money value;

	private Budget parent;

	@ManyToOne
	public Budget getBudget() {
		return getParent();
	}

	public Entry(BudgetLine budgetLine, Money value) {
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
	public void changeBudgetLine(BudgetLine budgetLine) {
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
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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

}

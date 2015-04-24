/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Budget;
import eapli.mymoney.domain.BudgetLine;
import eapli.mymoney.domain.Entry;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.persistence.BudgetRepository;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import eapli.mymoney.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author ferreirai
 */
public class UpdateMonthlyBudgetController {

	private Hashtable<ExpenseType, BigDecimal> entrada;
	private BigDecimal value;
	private ExpenseType expenseType;
	private Entry entry;
	private Budget budget;

	public UpdateMonthlyBudgetController() {
		budget = new Budget();
	}

	public List<ExpenseType> getExpenseTypes() {
		ExpenseTypeRepository repo = Persistence.getRepositoryFactory().
			getExpenseTypeRepository();
		return repo.all();
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public void setValor(BigDecimal value) {
		this.value = value;
	}

	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}

	public void insereLista() {
		entrada.put(expenseType, value);
	}

	public void addEntry(BudgetLine budgetLine, Money valor) {
		entry = new Entry(budgetLine, valor);
		budget.addEntry(entry);
	}

	public void changeBudgetName(String budgetName) {
		budget.changeBudgetName(budgetName);
	}

	public boolean saveBudget() {
		BudgetRepository repo = Persistence.getRepositoryFactory().
			getBudgetRepository();
		return repo.add(budget);
	}

	public List<Budget> getBudgetList() {
		BudgetRepository repo = Persistence.getRepositoryFactory().
			getBudgetRepository();
		return repo.all();
	}

}

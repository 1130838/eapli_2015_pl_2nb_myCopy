/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Budget;
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
public class RegisterMonthlyBudgetController {

	private Hashtable<ExpenseType, BigDecimal> entrada;
	private BigDecimal value;
	private ExpenseType expenseType;
	private Entry entry;
	private Budget budget;
	List<ExpenseType> expenseTypeList;

	public RegisterMonthlyBudgetController() {
		budget = new Budget();
	}

	public List<ExpenseType> getExpenseTypes() {
		ExpenseTypeRepository repo = Persistence.getRepositoryFactory().
			getExpenseTypeRepository();
		expenseTypeList = repo.all();
		return expenseTypeList;
	}

	public void setValor(BigDecimal value) {
		this.value = value;
	}

	public void setExpenseType(int index) {
		//ExpenseType expenseType
		this.expenseType = getExpenseTypes().get(index - 1);
	}

	public void addValue(Money valor) {
		entry = new Entry(this.expenseType, valor);
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
}

package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseGroup;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import eapli.mymoney.persistence.Persistence;
import eapli.mymoney.persistence.RepositoryFactory;
import java.util.ArrayList;
import java.util.List;

public class AssignExpenseTypeToGroupController {

	private RepositoryFactory repositoryFactory;
	private ExpenseGroupRepository expenseGroupRepository;
	private ExpenseTypeRepository expenseTypeRepository;
	private ExpenseGroup currentExpenseGroup;

	public AssignExpenseTypeToGroupController() {
		this.repositoryFactory = Persistence.getRepositoryFactory();
		this.expenseGroupRepository = this.repositoryFactory.
			getExpenseGroupRepository();
		this.expenseTypeRepository = this.repositoryFactory.
			getExpenseTypeRepository();
	}

	/**
	 * Return all Expense Groups
	 *
	 * @return List<ExpenseGroup>
	 */
	public List<ExpenseGroup> getExpenseGroupList() {
		return this.expenseGroupRepository.all();
	}

	/**
	 * Set the current expense group
	 *
	 * @param expenseGroup obj
	 */
	public void setCurrentExpenseGroup(String expenseGroup) {
		this.currentExpenseGroup = this.expenseGroupRepository.
			findById(expenseGroup);
	}

	/**
	 * Add expense type to the expense group
	 *
	 * @param expenseTypeId expense type id
	 */
	public void addExpenseType(int expenseTypeId) {
		ExpenseType expenseType = this.expenseTypeRepository.
			findById(expenseTypeId);
		this.currentExpenseGroup.addExpenseType(expenseType);
		this.expenseGroupRepository.save(this.currentExpenseGroup);
	}

	/**
	 * This methods returns all the expense type of the expense group.
	 *
	 * @return
	 */
	public List<ExpenseType> getListExpenseType() {
		return this.currentExpenseGroup.getExpenseTypes();
	}

	/**
	 * This method allows us to choose an specific option. It returns the
	 * selected option expense Types.
	 *
	 * @param option Selected option
	 * @return List of Expense Types according to the option.
	 */
	public List<ExpenseType> chooseOption(String option) {
		if (option.equals("A")) {
			return this.expenseTypeRepository.all();
		} else if (option.equals("D")) {
			return this.currentExpenseGroup.getExpenseTypes();
		}
		return new ArrayList<>();
	}

	/**
	 * This method remove an specific expense type from the expense group.
	 *
	 * @param optionType
	 */
	public void removeExpenseType(int optionType) {
		this.currentExpenseGroup.removeExpenseType(optionType);
		this.expenseGroupRepository.save(this.currentExpenseGroup);
	}
}

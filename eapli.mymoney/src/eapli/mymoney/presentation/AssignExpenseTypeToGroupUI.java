/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.AssignExpenseTypeToGroupController;
import eapli.mymoney.domain.ExpenseGroup;
import eapli.mymoney.domain.ExpenseType;
import eapli.util.Console;
import java.util.List;

/**
 *
 * @author pfreitas
 */
public class AssignExpenseTypeToGroupUI extends BaseUI {

	private AssignExpenseTypeToGroupController controller;

	@Override
	protected boolean doShow() {
		this.controller = new AssignExpenseTypeToGroupController();

		final List<ExpenseGroup> expenseGroups = controller.
			getExpenseGroupList();

		System.out.println("Expense Group List:");

		for (int i = 0; i < expenseGroups.size(); i++) {
			System.out.println(expenseGroups.get(i).getName());
		}

		String optionGroup = Console.readLine("Enter the Expense Group Name:");

		controller.setCurrentExpenseGroup(optionGroup);

		System.out.println("A. Assign expense type to this expense group.");
		System.out.println("D. Remove expense type to this expense group.");
		String option = Console.readLine("Choose an option:");

		final List<ExpenseType> listExpenseTypes = this.controller.
			chooseOption(option);

		for (ExpenseType expenseType : listExpenseTypes) {
			System.out.println(expenseType.getID() + ". " + expenseType.
				description());
		}
		if (listExpenseTypes.size() > 0) {
			int optionType = Console.
				readInteger("Enter the Expense Type Number (ID):");

			if (option.equals("A")) {
				this.controller.addExpenseType(optionType);
			} else if (option.equals("D")) {
				this.controller.removeExpenseType(optionType);
			}
		}

		return true;
	}

	@Override
	public String headline() {
		return "Assign Expense Type to Expense Group";
	}

}

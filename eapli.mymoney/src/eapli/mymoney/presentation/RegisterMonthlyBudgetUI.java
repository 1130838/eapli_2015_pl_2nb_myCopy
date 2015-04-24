/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.framework.model.Money;
import eapli.mymoney.application.RegisterMonthlyBudgetController;
import eapli.mymoney.domain.ExpenseType;
import eapli.util.Console;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ferreirai
 */
public class RegisterMonthlyBudgetUI extends BaseUI {

	private RegisterMonthlyBudgetController controller = new RegisterMonthlyBudgetController();
	private List<ExpenseType> expenseTypeList;
	private String budgetName;
	ExpenseType chosenExpenseType;

	@Override

	public boolean doShow() {
		System.out.println("\n" + headline());
		budgetName = Console.readLine("Type the Budget name:");
		controller.changeBudgetName(budgetName);
		expenseTypeList = controller.getExpenseTypes();
		int option = -1, position = 1;
		chosenExpenseType = new ExpenseType("");
		while (option != 0) {
			boolean bExpenseTypeChosen = false;
			if (!chooseExpenseType()) {
				break;
			}
			double chosenValue = Console.
				readDouble("Please insert a Value for this Expense:");
			Money value = Money.euros(chosenValue);
			//
			controller.addEntry(chosenExpenseType, value);
		}
		submit();
		return true;
	}

	private void submit() {
		controller.saveBudget();
		System.out.println("\nMonthly Budget recorded!");
	}

	@Override
	public String headline() {
		return "REGISTER MONTLHY BUDGET";
	}

	public boolean chooseExpenseType() {
		int position = 1;
		for (Iterator<ExpenseType> iterator = expenseTypeList.iterator(); iterator.
			hasNext();) {
			ExpenseType next = iterator.next();
			System.out.println(position + " - " + next.description());
			position++;
		}
		int option = Console.
			readInteger("Please choose an Expense Type (0 to stop inserting...)");
		if (option == 0) {
			return false;
		}

		for (Iterator<ExpenseType> iterator = expenseTypeList.iterator(); iterator.
			hasNext();) {
			position++;
			if (option == position) {
				chosenExpenseType = iterator.next();
			}
		}
		return true;
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.framework.model.Money;
import eapli.mymoney.application.UpdateMonthlyBudgetController;
import eapli.mymoney.domain.Budget;
import eapli.mymoney.domain.Entry;
import eapli.mymoney.domain.ExpenseType;
import eapli.util.Console;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ferreirai
 */
public class UpdateMonthlyBudgetUI extends BaseUI {

	private UpdateMonthlyBudgetController controller = new UpdateMonthlyBudgetController();
	private List<ExpenseType> expenseTypeList;
	private List<Budget> budgetList;
	private String budgetName;
	private int index = 1;
	private int option = -1;
	private int position = 1;
	private Budget chosenBudget;

	@Override
	public boolean doShow() {
		chosenBudget = new Budget();
		System.out.println("\n" + headline());
		budgetList = controller.getBudgetList();

		while (option != 0) {
			selectBudget();
			Entry entry = new Entry();
			List<Entry> entryList = chosenBudget.retrieveEntryList();
			int item = 0;
			for (Iterator<Entry> iterator = entryList.iterator(); iterator.
				hasNext();) {
				item++;
				Entry tmpEntry = iterator.next();
				ExpenseType expenseType = (ExpenseType) tmpEntry.getBudgetLine();
				Money money = tmpEntry.getValue();
				System.out.
					println(item + " - Nome: " + expenseType.description() + " valor:" + money.
						amount());

			}
			int optionExpense = -1;
			double value;
			while (optionExpense != 0) {

				optionExpense = Console.
					readInteger("\nPlease choose an Expense to change its value(0 to sop...)");
				for (Iterator<Entry> iterator = entryList.iterator(); iterator.
					hasNext();) {
					Entry tmpEntry = iterator.next();
					if (optionExpense == item) {
						value = Console.readDouble("\nEnter amount:");
						Money newValue = Money.euros(value);
						tmpEntry.changeValue(newValue);
					}
				}
			}
			controller.chooseBudget(chosenBudget);
			submit();
		}
		return true;
	}

	private void selectBudget() {
		for (Iterator<Budget> iterator = budgetList.iterator(); iterator.
			hasNext();) {
			Budget next = iterator.next();
			System.out.println(index + " - " + next.description());
			index++;
		}
		option = Console.readInteger("Please choose a Budget (0 to sop...)");
		int choice = 0;

		for (Iterator<Budget> iterator = budgetList.iterator(); iterator.
			hasNext();) {
			if (option == position) {
				chosenBudget = iterator.next();
			}
			choice++;
		}
	}

	private void submit() {
		controller.saveBudget();
		System.out.println("\nMonthly Budget recorded!");
	}

	@Override
	public String headline() {
		return "UPDATE MONTLHY BUDGET";
	}
}

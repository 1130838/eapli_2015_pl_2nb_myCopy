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

	@Override
	public boolean doShow() {
		System.out.println("\n" + headline());
		budgetList = controller.getBudgetList();
		int index = 1;
		int option = -1, position = 1;
		while (option != 0) {
			for (Iterator<Budget> iterator = budgetList.iterator(); iterator.
				hasNext();) {
				Budget next = iterator.next();
				System.out.println(index + " - " + next.description());
				index++;
			}
			option = Console.readInteger("Please choose a Budget (0 to sop...)");
			int choice = 0;
			Budget chosenBudget = new Budget();
			for (Iterator<Budget> iterator = budgetList.iterator(); iterator.
				hasNext();) {
				choice++;
				if (option == position) {
					chosenBudget = iterator.next();
				}
			}
			Entry entry = new Entry();

			List<Entry> entryList = chosenBudget.retrieveEntryList();
			int item = 1;
			for (Iterator<Entry> iterator = entryList.iterator(); iterator.
				hasNext();) {
				Entry tmpEntry = iterator.next();
				ExpenseType expenseType = (ExpenseType) tmpEntry.getBudgetLine();
				Money money = tmpEntry.getValue();
				System.out.
					println(item + " - Nome: " + expenseType.description() + " valor:" + money.
						amount());
				item++;
			}
		}
//        budgetName = Console.readLine("Type the Budget name:");
//        controller.changeBudgetName(budgetName);
//        expenseTypeList = controller.getExpenseTypes();
//        int option = -1, position = 1;
//
//        while (option != 0) {
//            position = 1;
//            for (Iterator<ExpenseType> iterator = expenseTypeList.iterator(); iterator.hasNext();) {
//                ExpenseType next = iterator.next();
//                System.out.println(position + " - " + next.description());
//                position++;
//            }
//            option = Console.readInteger("Please choose an Expense Type (0 to sop inserting...)");
//            if (option == 0) {
//                break;
//            }
//            ExpenseType chosenExpenseType = new ExpenseType("a");
//            for (Iterator<ExpenseType> iterator = expenseTypeList.iterator(); iterator.hasNext();) {
//                position++;
//                if (option == position) {
//                    chosenExpenseType = iterator.next();
//                }
//            }
//            double chosenValue = Console.readDouble("Please insert a Value for this Expense:");
//            Money value = Money.euros(chosenValue);
//            //
//            controller.addEntry(chosenExpenseType, value);
//        }
//        submit();
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
}

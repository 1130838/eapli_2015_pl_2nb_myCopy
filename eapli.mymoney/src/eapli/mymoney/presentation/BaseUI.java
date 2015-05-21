/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.ListWeekExpeditureController;
import eapli.mymoney.application.MonthlyExpenseController;

/**
 *
 * @author arocha
 */
//TODO should we refactor this class and move it to the framework project?
public abstract class BaseUI {

	public static final String SEPARATOR = "+---------------------------------------------------------------------------------+";
	public static final String BORDER = "+=================================================================================+";

	/**
	 * derived classes should override this method to perform the actual
	 * rendering of the UI
	 *
	 * follows the Template Method pattern
	 *
	 * @return
	 */
	protected abstract boolean doShow();

	/**
	 * derived classes should override this method to provide the title of the
	 * "window"
	 *
	 * @return
	 */
	public abstract String headline();

	public void mainLoop() {
		boolean wantsToExit;
		do {
			wantsToExit = show();
		} while (!wantsToExit);
	}

	public boolean show() {
		drawFormTitle();
		drawHeader();
		final boolean wantsToExit = doShow();

		return wantsToExit;
	}

	protected void drawHeader() {

		ListWeekExpeditureController bControllerWeek
			= new ListWeekExpeditureController();
		MonthlyExpenseController bControllerMonth = new MonthlyExpenseController();

		String weeklyContent = "This week's expediture: " + bControllerWeek.
			getWeekExpediture().
			amount() + "€\n";

		String monthlyContent = "This month's expediture: " + bControllerMonth.
			getMonthExpediture().
			amount() + "€\n";

		System.out.println(monthlyContent);
		System.out.println(weeklyContent);
	}

	protected void drawFormTitle() {
		System.out.println();
		drawFormTitle(headline());
		System.out.println();
	}

	protected void drawFormBorder() {
		System.out.println(BORDER);
		System.out.println();
	}

	protected void drawFormSeparator() {
		System.out.println(SEPARATOR);
	}

	protected void drawFormTitle(final String title) {
		String titleBorder = BORDER.substring(0, 2) + " " + title + " " + BORDER.
			substring(4 + title.length());
		System.out.println(titleBorder);
	}
}

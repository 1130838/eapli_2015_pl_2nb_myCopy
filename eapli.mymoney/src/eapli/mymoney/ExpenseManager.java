/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney;

import eapli.mymoney.bootstrap.Bootstraper;
import eapli.mymoney.presentation.MainMenu;

/**
 *
 * @author Paulo Gandra Sousa
 */
public final class ExpenseManager {

	private ExpenseManager() {
		// to make sure this is an utility class
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		final Bootstraper bootstraper = new Bootstraper();
		bootstraper.execute();

		final MainMenu menu = new MainMenu();
		menu.mainLoop();
	}
}

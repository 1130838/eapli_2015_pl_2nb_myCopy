/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney;

import eapli.framework.model.Money;
import eapli.mymoney.bootstrap.Bootstraper;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;
import eapli.mymoney.presentation.MainMenu;
import eapli.util.Console;
import javafx.util.converter.PercentageStringConverter;

import java.math.BigDecimal;
import java.util.Calendar;

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


        // para testes: nao apagar . deixar comentado
   /*     ExpenseRepository expRepo = Persistence.getRepositoryFactory().getExpenseRepository();
        BigDecimal moneyValue = new BigDecimal("45");


        ExpenseType expenseType = (ExpenseType) Persistence.getRepositoryFactory().getExpenseTypeRepository().all().get(0);
        System.out.println(expenseType.description());
        System.out.println(expenseType.getID());
        PaymentMethod paymentMethod = Persistence.getRepositoryFactory().getPaymentMethodRepository().all().get(0);
        Expense expense = new Expense(moneyValue, expenseType, paymentMethod, Calendar.getInstance());;
	    expRepo.add(expense);*/
    }
}

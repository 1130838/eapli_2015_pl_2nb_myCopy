/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence.inmemory;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.domain.Period;
import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author pfreitas
 */
public class ExpenseRepositoryImplTest {

	ExpenseRepositoryImpl instance;

	public ExpenseRepositoryImplTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		this.instance = new ExpenseRepositoryImpl();
		ExpenseType expenseType = new ExpenseType("Teste Unitario");
		PaymentMethod paymentMethod = new PaymentMethod("Testcoins");
		Calendar data = DateTime.now();
		Expense expense = new Expense(BigDecimal.TEN, expenseType, paymentMethod, data);
		this.instance.add(expense);
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of add method, of class ExpenseRepositoryImpl.
	 */
	@Test
	public void testAdd() {
		System.out.println("add");
		Expense expense = null;
		ExpenseRepositoryImpl instance = new ExpenseRepositoryImpl();
		boolean expResult = false;
		boolean result = instance.add(expense);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of size method, of class ExpenseRepositoryImpl.
	 */
	@Test
	public void testSize() {
		System.out.println("size");
		ExpenseRepositoryImpl instance = new ExpenseRepositoryImpl();
		long expResult = 0L;
		long result = instance.size();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of all method, of class ExpenseRepositoryImpl.
	 */
	@Test
	public void testAll() {
		System.out.println("all");
		ExpenseRepositoryImpl instance = new ExpenseRepositoryImpl();
		List<Expense> expResult = null;
		List<Expense> result = instance.all();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getWeekExpediture method, of class ExpenseRepositoryImpl.
	 */
	@Test
	public void testGetWeekExpediture() {
		System.out.println("getWeekExpediture");
		Calendar periodBegin = DateTime.beginningOfWeek(1955, 15);
		Calendar periodEnd = DateTime.now();
		Period period = new Period(periodBegin, periodEnd);
		ExpenseRepositoryImpl instance = new ExpenseRepositoryImpl();
		Money expResult = Money.euros(10.00);
		Money result = instance.getWeekExpediture(period);
		assertEquals(expResult, result);
	}

}

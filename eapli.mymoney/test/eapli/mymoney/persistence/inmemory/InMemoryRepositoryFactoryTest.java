package eapli.mymoney.persistence.inmemory;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Period;
import eapli.mymoney.persistence.BudgetRepository;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.PaymentMethodsRepository;
import eapli.util.DateTime;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InMemoryRepositoryFactoryTest {

	public InMemoryRepositoryFactoryTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getExpenseTypeRepository method, of class
	 * InMemoryRepositoryFactory.
	 */
	@Test
	public void testGetExpenseTypeRepository() {
		System.out.println("getWeekExpediture");
		Calendar periodBegin = DateTime.beginningOfWeek(1955, 15);
		Calendar periodEnd = DateTime.now();
		Period period = new Period(periodBegin, periodEnd);
		ExpenseRepositoryImpl instance = new ExpenseRepositoryImpl();
		Money expResult = Money.euros(0.00);
		Money result = instance.getWeekExpediture(period);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getExpenseRepository method, of class InMemoryRepositoryFactory.
	 */
	@Test
	public void testGetExpenseRepository() {
		System.out.println("getExpenseRepository");
		InMemoryRepositoryFactory instance = new InMemoryRepositoryFactory();
		ExpenseRepository expResult = null;
		ExpenseRepository result = instance.getExpenseRepository();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPaymentMethodRepository method, of class
	 * InMemoryRepositoryFactory.
	 */
	@Test
	public void testGetPaymentMethodRepository() {
		System.out.println("getPaymentMethodRepository");
		InMemoryRepositoryFactory instance = new InMemoryRepositoryFactory();
		PaymentMethodsRepository expResult = null;
		PaymentMethodsRepository result = instance.getPaymentMethodRepository();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getExpenseGroupRepository method, of class
	 * InMemoryRepositoryFactory.
	 */
	@Test
	public void testGetExpenseGroupRepository() {
		System.out.println("getExpenseGroupRepository");
		InMemoryRepositoryFactory instance = new InMemoryRepositoryFactory();
		ExpenseGroupRepository expResult = null;
		ExpenseGroupRepository result = instance.getExpenseGroupRepository();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getBudgetRepository method, of class InMemoryRepositoryFactory.
	 */
	@Test
	public void testGetBudgetRepository() {
		System.out.println("getBudgetRepository");
		InMemoryRepositoryFactory instance = new InMemoryRepositoryFactory();
		BudgetRepository expResult = null;
		BudgetRepository result = instance.getBudgetRepository();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}

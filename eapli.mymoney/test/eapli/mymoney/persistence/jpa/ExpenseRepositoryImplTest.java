package eapli.mymoney.persistence.jpa;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.domain.Period;
import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

	/**
	 * Test of persistenceUnitName method, of class ExpenseRepositoryImpl.
	 */
	@Test
	public void testPersistenceUnitName() {
		System.out.println("persistenceUnitName");
		ExpenseRepositoryImpl instance = new ExpenseRepositoryImpl();
		String expResult = "";
		String result = instance.persistenceUnitName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}

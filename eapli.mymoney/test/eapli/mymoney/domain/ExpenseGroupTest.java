package eapli.mymoney.domain;

import eapli.util.DateTime;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpenseGroupTest {

	private ExpenseGroup expenseGroupToTest;

	public ExpenseGroupTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		try {
			String strDate1 = "10-10-2014";
			SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
			Calendar date1 = DateTime.dateToCalendar(df1.parse(strDate1));
			String strDate2 = "10-10-2015";
			SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
			Calendar date2 = DateTime.dateToCalendar(df2.parse(strDate2));
			this.expenseGroupToTest = new ExpenseGroup("Teste", date1, date2, BigDecimal.ZERO);
		} catch (ParseException ex) {
			Logger.getLogger(ExpenseGroupTest.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getName method, of class ExpenseGroup.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		String expected = "Teste";
		String result = this.expenseGroupToTest.getName();
		assertEquals(expected, result);
	}

	/**
	 * Test of getEstimation method, of class ExpenseGroup.
	 */
	@Test
	public void testGetEstimation() {
		System.out.println("getEstimation");
		ExpenseGroup instance = new ExpenseGroup();
		BigDecimal expResult = null;
		BigDecimal result = instance.getEstimation();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getExpenseTypes, addExpenseType and removeExpenseType method, of
	 * class ExpenseGroup.
	 */
	@Test
	public void testAddAndGetAndRemoveExpenseTypes() {
		System.out.
			println("addExpenseTypes & getExpenseTypes & removeExpenseType");
		ExpenseType et = new ExpenseType("Vestuario");
		this.expenseGroupToTest.addExpenseType(et);
		List<ExpenseType> expResult = new ArrayList<>();
		expResult.add(et);
		List<ExpenseType> result = this.expenseGroupToTest.getExpenseTypes();
		assertEquals(expResult, result);
		List<ExpenseType> expResult2 = new ArrayList<>();
		this.expenseGroupToTest.removeExpenseType(et.getID());
		List<ExpenseType> result2 = this.expenseGroupToTest.getExpenseTypes();
		assertEquals(expResult2, result2);
	}

	/**
	 * Test of obtainExpenseYear method, of class ExpenseGroup.
	 */
	@Test
	public void testObtainExpenseYear() {
		System.out.println("obtainExpenseYear");
		ExpenseGroup instance = new ExpenseGroup();
		int expResult = 0;
		int result = instance.obtainExpenseYear();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}

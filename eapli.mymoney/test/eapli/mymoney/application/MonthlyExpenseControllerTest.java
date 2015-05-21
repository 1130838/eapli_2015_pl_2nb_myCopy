/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.framework.model.Money;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ferreirai
 */
public class MonthlyExpenseControllerTest {

	public MonthlyExpenseControllerTest() {
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
	 * Test of getMonthExpediture method, of class MonthlyExpenseController.
	 */
	@Test
	public void testGetMonthExpediture() {
		System.out.println("getMonthExpediture");
		MonthlyExpenseController instance = new MonthlyExpenseController();
		Money expResult = null;
		Money result = instance.getMonthExpediture();
		//assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

}

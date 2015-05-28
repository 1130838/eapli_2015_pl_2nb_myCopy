/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joel
 */
public class ExpenseGroupTest {

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

	/**
	 * Test of addExpenseType method, of class ExpenseGroup.
	 */
	@Test
	public void testAddExpenseType() {
		System.out.println("addExpenseType");
		ExpenseType expenseType = null;
		ExpenseGroup instance = new ExpenseGroup();
		instance.addExpenseType(expenseType);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class ExpenseGroup.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		ExpenseGroup instance = new ExpenseGroup();
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
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

}

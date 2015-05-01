/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

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
public class EntryTest {

	public EntryTest() {
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
	 * Test of getBudget method, of class Entry.
	 */
	@Test
	public void testGetBudget() {
		System.out.println("getBudget");
		Entry instance = new Entry();
		Budget expResult = null;
		Budget result = instance.getBudget();
		//assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of addParent method, of class Entry.
	 */
	@Test
	public void testAddParent() {
		System.out.println("addParent");
		Budget parent = null;
		Entry instance = new Entry();
		instance.addParent(parent);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of getBudgetLine method, of class Entry.
	 */
	@Test
	public void testGetBudgetLine() {
		System.out.println("getBudgetLine");
		Entry instance = new Entry();
		BudgetLine expResult = null;
		BudgetLine result = instance.getBudgetLine();
		//assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of changeBudgetLine method, of class Entry.
	 */
	@Test
	public void testChangeBudgetLine() {
		System.out.println("changeBudgetLine");
		ExpenseType budgetLine = null;
		Entry instance = new Entry();
		instance.changeBudgetLine(budgetLine);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of getValue method, of class Entry.
	 */
	@Test
	public void testGetValue() {
		System.out.println("getValue");
		Entry instance = new Entry();
		Money expResult = null;
		Money result = instance.getValue();
		//assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of changeValue method, of class Entry.
	 */
	@Test
	public void testChangeValue() {
		System.out.println("changeValue");
		Money value = null;
		Entry instance = new Entry();
		instance.changeValue(value);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of getId method, of class Entry.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Entry instance = new Entry();
		long expResult = 0L;
		long result = instance.getId();
		//assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of setId method, of class Entry.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		long id = 0L;
		Entry instance = new Entry();
		instance.setId(id);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of getParent method, of class Entry.
	 */
	@Test
	public void testGetParent() {
		System.out.println("getParent");
		Entry instance = new Entry();
		Budget expResult = null;
		Budget result = instance.getParent();
		//assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of setParent method, of class Entry.
	 */
	@Test
	public void testSetParent() {
		System.out.println("setParent");
		Budget parent = null;
		Entry instance = new Entry();
		instance.setParent(parent);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

}

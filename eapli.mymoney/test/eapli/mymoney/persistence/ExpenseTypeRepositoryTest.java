/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence;

import eapli.mymoney.domain.ExpenseType;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeRepositoryTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private transient ExpenseTypeRepository instance;

    @Before
    public void setUp() {
		//FIXME there is the need to set-up a clean empty repository
        // for inmemory this could be simple
        // for DB repo it should use dbunit or alike
        instance = Persistence.getRepositoryFactory().getExpenseTypeRepository();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ensureAddOne() {
        System.out.println("Add one");
        ExpenseType expenseType = new ExpenseType("abcd");
        instance.add(expenseType);

        long expected = 1;
        long actual = instance.size();
        assertEquals("One added should have count = 1", expected, actual);
    }

    @Test
    public void ensureEmptyHasSizeZero() {
        System.out.println("Empty repository must have count 0");

        long expected = 0;
        long actual = instance.size();
        assertEquals("Empty repository must have count 0", expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notAllowedToAddNull() {
        System.out.println("Not Allowed to add null");
        ExpenseType expenseType = null;
        instance.add(expenseType);
    }

    @Test(expected = IllegalStateException.class)
    public void notAllowedToAddSameDescription() {
        System.out.println("Not Allowed to add same description");
        ExpenseType expenseType = new ExpenseType("Vestuario");
        instance.add(expenseType);
        expenseType = new ExpenseType("Vestuario");
        instance.add(expenseType);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.persistence;

import eapli.mymoney.domain.ExpenseGroup;
import java.util.Iterator;
import java.util.List;
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
public class ExpenseGroupRepositoryTest {

    public ExpenseGroupRepositoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private transient ExpenseGroupRepository instance;

    @Before
    public void setUp() {
        instance = Persistence.getRepositoryFactory().getExpenseGroupRepository();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ExpenseGroupRepository.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ExpenseGroup expenseGroup = null;
        ExpenseGroupRepository instance = new ExpenseGroupRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.add(expenseGroup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class ExpenseGroupRepository.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ExpenseGroupRepository instance = new ExpenseGroupRepositoryImpl();
        long expResult = 0L;
        long result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of all method, of class ExpenseGroupRepository.
     */
    @Test
    public void testAll() {
        System.out.println("all");
        ExpenseGroupRepository instance = new ExpenseGroupRepositoryImpl();
        List<ExpenseGroup> expResult = null;
        List<ExpenseGroup> result = instance.all();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class ExpenseGroupRepository.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        int pagesize = 0;
        ExpenseGroupRepository instance = new ExpenseGroupRepositoryImpl();
        Iterator<ExpenseGroup> expResult = null;
        Iterator<ExpenseGroup> result = instance.iterator(pagesize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ExpenseGroupRepositoryImpl implements ExpenseGroupRepository {

        public boolean add(ExpenseGroup expenseGroup) {
            return false;
        }

        public long size() {
            return 0L;
        }

        public List<ExpenseGroup> all() {
            return null;
        }

        public Iterator<ExpenseGroup> iterator(int pagesize) {
            return null;
        }
    }

}

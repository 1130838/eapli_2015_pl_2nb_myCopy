/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author pag
 */
public class BudgetMapTest {

    public BudgetMapTest() {
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
     * Test of calculateForecast method, of class BudgetMap.
     */
    @Test
    public void testCalculateForecast() {
        System.out.println("calculateForecast");
        BudgetMap instance = null;
        BudgetMap expResult = null;
        BudgetMap result = instance.calculateForecast();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHashMap method, of class BudgetMap.
     */
    @Test
    public void testGetHashMap() {

        System.out.println("getHashMap");
        HashMap<Entry, Float> blah = new HashMap();
        Entry e = null;
        Float f = 0f;
        BudgetMap instance = null;
        HashMap<Entry, Float> expResult = null;
        HashMap<Entry, Float> result = instance.getHashMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

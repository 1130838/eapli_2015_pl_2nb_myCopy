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
     * Test of getHashMap method, of class BudgetMap.
     */
    @Test
    public void testGetHashMap() {

        System.out.println("getHashMap");
        HashMap<Entry, Float> blah = new HashMap();
        Budget b = new Budget();
        BudgetMap instance = new BudgetMap(b);
        HashMap<Entry, Float> expResult = blah;
        HashMap<Entry, Float> result = instance.getHashMap();
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateForecast method, of class BudgetMap.
     */
    @Test
    public void testCalculateForecast() {
        System.out.println("calculateForecast");
        Budget m = new Budget();
        BudgetMap instance = new BudgetMap(m);
        HashMap<Entry, Float> expResult = new HashMap<>();
        HashMap<Entry, Float> result = instance.calculateForecast();
        assertEquals(expResult, result);
    }

    /**
     * Test of lineForecast method, of class BudgetMap.
     */
    @Test
    public void testLineForecast() {
        System.out.println("lineForecast");

        Budget m = new Budget();
        BudgetMap instance = new BudgetMap(m);

        float totalExpenseValue = 50.0F;
        int daysInMonth = 30;
        int nowDay = 15;
        float expResult = 100.0F;
        float result = instance.lineForecast(totalExpenseValue, daysInMonth, nowDay);
        assertEquals(expResult, result, 0.0);
    }
}

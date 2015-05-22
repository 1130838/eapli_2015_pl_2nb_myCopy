/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseGroup;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author joaopaulo
 */
public class ShowListYearExpensesGroupControllerTest {
    
    public ShowListYearExpensesGroupControllerTest() {
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
     * Test of getExpenseGroups method, of class ShowListYearExpensesGroupController.
     */
    @Test
    public void testGetExpenseGroups() {
        System.out.println("getExpenseGroups");
        int year = 0;
        ShowListYearExpensesGroupController instance = new ShowListYearExpensesGroupController();
        List<ExpenseGroup> expResult = null;
        List<ExpenseGroup> result = instance.getExpenseGroups(year);
        assertEquals(expResult, result);
     }

    /**
     * Test of showListExpensesGroup method, of class ShowListYearExpensesGroupController.
     */
    @Test
    public void testShowListExpensesGroup() {
        System.out.println("showListExpensesGroup");
        int year = 0;
        ShowListYearExpensesGroupController instance = new ShowListYearExpensesGroupController();
        List<String> expResult = new ArrayList<>();
        List<String> result = instance.showListExpensesGroup(year);
        assertEquals(expResult, result);
     }
    
}

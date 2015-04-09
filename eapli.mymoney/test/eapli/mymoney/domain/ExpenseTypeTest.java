/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeTest {

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

    @Test(expected = IllegalArgumentException.class)
    public void nullDescriptionNotAllowed() {
        ExpenseType instance = new ExpenseType(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyDescriptionNotAllowed() {
        ExpenseType instance = new ExpenseType(" ");
    }

    private static String TEST_DESCRITPION = "A";

    @Test
    public void isValueObject() {
        ExpenseType instance1 = new ExpenseType(TEST_DESCRITPION);
        ExpenseType instance2 = new ExpenseType(TEST_DESCRITPION);
        Assert.assertEquals(instance1, instance2);
    }

}

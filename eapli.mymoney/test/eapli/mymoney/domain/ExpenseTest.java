package eapli.mymoney.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;

public class ExpenseTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetDate() throws Exception {

    }

    @Test
    public void testGetAmount() throws Exception {

    }

    @Test(expected = IllegalArgumentException.class)
    public void nullDescriptionNotAllowed() {
        ExpenseType instance = new ExpenseType(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void expenseAmountPositive() {
        BigDecimal amount = BigDecimal.valueOf(-123);
        ExpenseType expenseType = new ExpenseType("WhateverExpenseType");
        PaymentMethod paymentMethod = new PaymentMethod("WhateverPaymentMehod");
        Calendar date = Calendar.getInstance();

        Expense instance = new Expense(amount, expenseType, paymentMethod, date);
    }
}
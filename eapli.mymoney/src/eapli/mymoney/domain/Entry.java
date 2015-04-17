/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import eapli.framework.model.Money;

/**
 *
 * @author ferreirai
 */
public class Entry {

    private BudgetLine budgetLine;
    private Money value;

    public Entry(BudgetLine budgetLine, Money value) {
        this.budgetLine = budgetLine;
        this.value = value;
    }

}

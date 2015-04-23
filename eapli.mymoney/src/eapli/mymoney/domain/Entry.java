/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import eapli.framework.model.Money;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ferreirai
 */
@Entity
public class Entry {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private BudgetLine budgetLine;
    private Money value;
    @ManyToOne
    private Budget parent;

    public Entry() {

    }

    public Entry(BudgetLine budgetLine, Money value) {
        this.budgetLine = budgetLine;
        this.value = value;
    }

    public void addParent(Budget parent) {
        this.parent = parent;
    }

    /**
     * @return the budgetLine
     */
    public BudgetLine getBudgetLine() {
        return budgetLine;
    }

    /**
     * @param budgetLine the budgetLine to set
     */
    public void changeBudgetLine(BudgetLine budgetLine) {
        this.budgetLine = budgetLine;
    }

    /**
     * @return the value
     */
    public Money getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void changeValue(Money value) {
        this.value = value;
    }

}

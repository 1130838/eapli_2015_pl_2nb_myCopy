/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import eapli.framework.patterns.ValueObject;
import eapli.util.Validations;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
public class ExpenseType implements ValueObject, BudgetLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idET;

    private String text;

    protected ExpenseType() {
    }

    public ExpenseType(final String text) {
        if (Validations.isNullOrWhiteSpace(text)) {
            throw new IllegalArgumentException();
        }
        this.text = text;
    }

    /**
     * returns the description text of this expense type
     *
     * this method is only provided for user output
     *
     * @return
     */
    public String description() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof ExpenseType)) {
            return false;
        }
        ExpenseType etOther = (ExpenseType) other;
        return this.description().equals(etOther.description());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.text != null ? this.text.hashCode() : 0);
        return hash;
    }
}

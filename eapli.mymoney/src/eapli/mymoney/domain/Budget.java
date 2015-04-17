/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ferreirai
 */
@Entity
public class Budget {

    @Id
    private long id;
    private String name;

    private EntryList entryList;

    public boolean addEntry(Entry e) {
        return this.entryList.add(e);
    }

    /**
     * @param name the name to set
     */
    public void changeBudgetName(String name) {
        this.name = name;
    }

}

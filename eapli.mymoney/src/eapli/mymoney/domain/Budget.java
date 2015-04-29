/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ferreirai
 */
@Entity
@Table(name = "BUDGET")
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Entry> cildren = new ArrayList<Entry>();
	//private EntryList entryList;

	public boolean addEntry(Entry e) {
		e.addParent(this);
		return this.cildren.add(e);
	}

	public List<Entry> retrieveEntryList() {
		return cildren;
	}

	public String description() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void changeBudgetName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

}

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
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ferreirai
 */
@Entity
public class Budget {

	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	private String name;
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Entry> cildren = new ArrayList<Entry>();
	//private EntryList entryList;

	public boolean addEntry(Entry e) {
		e.addParent(this);
		return this.cildren.add(e);
	}

	public
		List<Entry> retrieveEntryList() {
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

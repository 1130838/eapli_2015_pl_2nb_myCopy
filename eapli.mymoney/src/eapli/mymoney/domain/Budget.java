/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import java.io.Serializable;
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
public class Budget implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idBudget;

	public Budget() {

	}

	private String name;
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Entry> children = new ArrayList<Entry>();
	//private EntryList entryList;

	public boolean addEntry(Entry e) {
		e.addParent(this);
		return this.getChildren().add(e);
	}

	public List<Entry> retrieveEntryList() {
		return getChildren();
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
	public long getIdBudget() {
		return idBudget;
	}

	/**
	 * @return the cildren
	 */
	public List<Entry> getChildren() {
		return children;
	}

}

package eapli.framework.persistence.inmemory;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class InmemoryRepository<T, ID> {

	/**
	 * Returns the size of the list
	 *
	 * @return long size of the list
	 */
	public long size() {
		return this.getList().size();
	}

	/**
	 * Allows the abstract class to access the list implementation
	 *
	 * @return List<T>
	 */
	public abstract List<T> getList();

	/**
	 * Check if the list contains an certain object.
	 *
	 * @param object Object to check
	 * @return boolean
	 */
	public boolean contains(final T object) {
		return this.getList().
			contains(object);
	}

	/**
	 * Generic method to return all elements of the list.
	 *
	 * @return List
	 */
	public List<T> all() {
		return Collections.unmodifiableList(this.getList());
	}

	/**
	 * Returns the iterator for the List
	 *
	 * @param pagesize
	 * @return
	 */
	public Iterator<T> iterator(final int pagesize) {
		return this.getList().iterator();
	}

	/**
	 * Method to save or update an object in the list
	 *
	 * @param object
	 * @return object
	 */
	public abstract T save(T object);
}

package eapli.framework.persistence.inmemory;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class InmemoryRepository<T, ID> {

	public final long size() {
		return this.getList().size();
	}

	public abstract List<T> getList();

	public final boolean contains(final T group) {
		return this.getList().
			contains(group);
	}

	public final List<T> all() {
		return Collections.unmodifiableList(this.getList());
	}

	public final Iterator<T> iterator(final int pagesize) {
		return this.getList().iterator();
	}

	/**
	 * derived classes should implement this method to return the name of the
	 * persistence unit
	 *
	 * @return the name of the persistence unit
	 */
	protected abstract String persistenceUnitName();
}

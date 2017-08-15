package org.adapter.framework.commons.contracts;

import java.util.Set;

/**
 * This interface will allow to register listeners for listening events.
 * 
 * @author Anish Singh
 *
 */
public interface Registrar {

	/**
	 * This method will register the listener for listening the event.
	 * 
	 * @param listener
	 */
	void registerListener(Listener listener);

	/**
	 * This will return all the listeners registered with this register.
	 * 
	 * @return
	 */
	Set<Listener> getListeners();
}

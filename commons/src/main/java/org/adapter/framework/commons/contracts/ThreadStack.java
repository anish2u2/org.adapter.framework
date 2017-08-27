package org.adapter.framework.commons.contracts;

/**
 * This Interface allow to hold Thread related Objects.
 * 
 * @author Anish Singh
 *
 */
public interface ThreadStack {

	/**
	 * This method is responsible for adding object to ThreadStack.
	 * 
	 * @param key
	 * @param value
	 */
	void addObject(Object key, Object value);

	/**
	 * This method will return the object stored in the Thread Stack
	 * corresponding to the key.
	 * 
	 * @param key
	 * @return
	 */
	Object getObject(Object key);

	/**
	 * This method will remove the Object from the ThreadStack for the key.
	 * 
	 * @param key
	 */
	void removeObject(Object key);

	/**
	 * This method will pull the Object corresponding to the key and removes
	 * from the ThreadStack.
	 * 
	 * @param key
	 * @return
	 */
	Object pullObject(Object key);

	/**
	 * This method will remove all the ThreadStack objects.
	 */
	void clearStack();
}

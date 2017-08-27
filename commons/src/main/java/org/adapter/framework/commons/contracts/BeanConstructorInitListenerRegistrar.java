package org.adapter.framework.commons.contracts;

/**
 * This will register the listeners which are listening for bean creation.
 * 
 * @author Anish Singh
 *
 */
public interface BeanConstructorInitListenerRegistrar {

	/**
	 * This will register the bean for listening Bean Creation event.
	 * 
	 * @param listener
	 */
	void registerListener(BeanCreationListener listener);

}

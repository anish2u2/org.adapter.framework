package org.adapter.framework.commons.contracts;

/**
 * This will represent the listener which is listening for bean creation.F
 * 
 * @author Anish Singh
 *
 */
public interface BeanCreationListener {

	/**
	 * This will be invoked when a bean is created in this framework.
	 * 
	 * @param createdObject
	 */
	void listen(Object createdObject);

}

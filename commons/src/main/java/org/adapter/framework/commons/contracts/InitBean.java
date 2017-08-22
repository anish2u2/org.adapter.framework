package org.adapter.framework.commons.contracts;

/**
 * This interface represents the initialization method of the bean for
 * initializing the bean in each module.
 * 
 * @author Anish Singh
 *
 */
public interface InitBean {
	
	/**
	 * This method will be used to initialize the beans after the creation of the object.
	 */
	void init();

}

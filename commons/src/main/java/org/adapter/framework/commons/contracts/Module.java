package org.adapter.framework.commons.contracts;

/**
 * This interface will be used to represents modules in adapter framework.
 * 
 * @author Anish Singh
 *
 */
public interface Module {

	/**
	 * This method will allow to init module.
	 */
	public void initModule();

	/**
	 * This method will allow to destroy module.
	 */
	public void destroyModule();

}

package org.framework.adapter.contracts.destroy;

/**
 * This Interface allow to run code before stopping the framework.
 * 
 * @author Anish Singh
 *
 */
public interface DestroyFramework {

	/**
	 * Code written under this method will allow to run before stopping the
	 * framework.
	 * 
	 */
	public void destroy();

}

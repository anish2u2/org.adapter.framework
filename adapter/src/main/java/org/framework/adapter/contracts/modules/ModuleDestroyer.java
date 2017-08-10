package org.framework.adapter.contracts.modules;

/**
 * This Interface is responsible for destroying all the modules registered under
 * this framework.
 * 
 * @author Anish Singh
 *
 */
public interface ModuleDestroyer {

	/**
	 * This method is responsible for destroying all modules registered under
	 * this framework.
	 * 
	 */
	public void destroyModules();

}

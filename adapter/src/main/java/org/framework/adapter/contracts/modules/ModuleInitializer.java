package org.framework.adapter.contracts.modules;

/**
 * This interface is responsible for initializing and registering all modules in
 * this framework.
 * 
 * @author Anish Singh
 *
 */
public interface ModuleInitializer {

	/**
	 * This method will initialize all the modules under this framework.
	 */
	public void initModules();

}

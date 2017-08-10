package org.framework.adapter.contracts.modules;

import org.adapter.framework.bridge.contracts.Module;

/**
 * This interface is a marker interface to allow initialize , register and
 * destroy sub modules of this framework.
 * 
 * @author Anish Singh
 *
 * 
 *
 */
public interface Modules extends ModuleInitializer, ModuleDestroyer {

	/**
	 * This method is responsible for registering the module.
	 * 
	 * @param module
	 */
	void register(Module module);

}

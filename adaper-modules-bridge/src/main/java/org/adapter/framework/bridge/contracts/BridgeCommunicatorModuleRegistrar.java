package org.adapter.framework.bridge.contracts;

import java.util.Collection;

/**
 * This interface allow to register module for establishing bridge connection
 * between them.
 * 
 * @author Anish Singh
 *
 */
public interface BridgeCommunicatorModuleRegistrar {

	/**
	 * This will represents the modules under this framework.
	 * 
	 * @author Anish Singh
	 *
	 */
	public static enum ModuleType {
		CONTEXT, BEAN, WORKER, UTILITY, CORE
	}

	/**
	 * Registered the module.
	 * 
	 * @param module
	 */
	public void registerModule(ModuleType type, Module module);

	/**
	 * Returns all the registered modules.
	 * 
	 * @return
	 */
	public Collection<Module> getRegisteredModules();

	/**
	 * This method will return the registered module with the passed module
	 * type.
	 * 
	 * @param moduleType
	 * @return
	 */
	public Module fetchRegisteredModule(ModuleType moduleType);
}

package org.framework.adapter.contracts.registers;

/**
 * This interface allow to register module config.
 * 
 * @author Anish Singh
 *
 */
public interface ModuleConfigRegister {

	/**
	 * Registers the given module conf file.
	 * 
	 * @param moduleConfName
	 */
	void registerModuleConfig(String moduleConfName);

}

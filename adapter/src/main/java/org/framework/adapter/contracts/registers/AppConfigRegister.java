package org.framework.adapter.contracts.registers;

/**
 * This interface allow to register the found app config during PathScanning.
 * 
 * @author Anish Singh
 *
 */
public interface AppConfigRegister {

	/**
	 * This method will register the app config.
	 * 
	 * @param configFileName
	 */
	void registerAppConfig(String configFileName);

}

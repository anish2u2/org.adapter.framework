package org.framework.adapter.contracts.registers;

import org.adapter.framework.bridge.contracts.Module;

/**
 * This interface allow to register different modules and implementor of this
 * class is responsible for handling registration of module.
 * 
 * @author Anish Singh
 *
 */
public interface ModuleRegister {
	/**
	 * This will register the module.
	 * 
	 * @param module
	 */
	void registerModule(Module module);

}

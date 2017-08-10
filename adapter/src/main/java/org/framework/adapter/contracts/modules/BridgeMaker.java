package org.framework.adapter.contracts.modules;

import org.adapter.framework.bridge.contracts.Module;

/**
 * This interface allow to make bridge between other modules.
 * 
 * @author Anish Singh
 *
 */

public interface BridgeMaker {

	/**
	 * This method stablish the bridge connection between the modules passed as
	 * parameter.
	 * 
	 * @param module1
	 * @param module2
	 */
	void makeBridge(Module module1, Module module2);

}

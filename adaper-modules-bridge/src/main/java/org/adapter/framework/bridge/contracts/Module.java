package org.adapter.framework.bridge.contracts;

import org.adapter.framework.bridge.exception.BridgeBrokenException;

/**
 * 
 * @author Anish Singh
 * 
 *         This interface will help in communication with other modules. This
 *         interface has to be implemented by modules which are going to use
 *         bridge communication.
 */
public interface Module {

	/**
	 * 
	 * This method will allow to get reference of the Bridge to establish a
	 * communication link between two modules.
	 * 
	 * @param bridge
	 */
	public void setBridgeGate(Bridge bridge) throws BridgeBrokenException;

}

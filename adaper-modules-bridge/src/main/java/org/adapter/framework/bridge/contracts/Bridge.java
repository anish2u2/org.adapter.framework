package org.adapter.framework.bridge.contracts;

import org.adapter.framework.bridge.exception.BridgeConnectionException;

/**
 * 
 * @author Anish Singh
 * 
 *         This Interface Allow to stablish a bridge between two modules.
 *
 */
public interface Bridge {

	/**
	 * This method will create the bridge between
	 * 
	 * @param module1
	 * @param module2
	 * @return
	 * @throws BridgeConnectionException
	 */
	public void makeBridge(Module module1, Module module2) throws BridgeConnectionException;

}
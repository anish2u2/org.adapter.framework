package org.adapter.framework.bridge.contracts;

import org.adapter.framework.bridge.contracts.CommunicationLink.Module;
import org.adapter.framework.bridge.exception.BridgeConnectionException;

/**
 * 
 * @author Anish Singh
 * 
 *         This Interface Allow to stablish a bridge between two modules. This
 *         will let two modules communicate with each others.
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
	public CommunicationLink makeBridge(Module module) throws BridgeConnectionException;

}

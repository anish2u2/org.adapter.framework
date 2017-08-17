package org.adapter.framework.bridge;

import org.adapter.framework.bridge.contracts.Bridge;
import org.adapter.framework.bridge.contracts.CommunicationLink;
import org.adapter.framework.bridge.exception.BridgeConnectionException;

/**
 * 
 * @author Anish Singh
 * 
 * 
 *
 */
public class ModuleBridge implements Bridge {

	private static ModuleBridge moduleBridge;

	static {
		moduleBridge = new ModuleBridge();
	}

	private ModuleBridge() {
		if (moduleBridge != null)
			throw new RuntimeException("Object already created.");
	}

	public static Bridge getBridge() {
		return moduleBridge;
	}

	public CommunicationLink makeBridge(org.adapter.framework.bridge.contracts.CommunicationLink.Module module)
			throws BridgeConnectionException {

		return null;
	}

}

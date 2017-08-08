package org.adapter.framework.bridge;

import org.adapter.framework.bridge.contracts.Bridge;
import org.adapter.framework.bridge.contracts.Module;
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

	public static Bridge getBridge() {
		return moduleBridge;
	}

	public void makeBridge(final Module module1, final Module module2) throws BridgeConnectionException {

		module1.setCommunicateToModule(module2);
		module2.setCommunicateToModule(module1);
	}

}

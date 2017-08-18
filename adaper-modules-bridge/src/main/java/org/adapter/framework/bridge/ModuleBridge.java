package org.adapter.framework.bridge;

import org.adapter.framework.bridge.contracts.Bridge;
import org.adapter.framework.bridge.contracts.BridgeCommunicatorModuleRegistrar;
import org.adapter.framework.bridge.contracts.CommunicationLink;
import org.adapter.framework.bridge.exception.BridgeConnectionException;
import org.adapter.framework.bridge.registrar.BridgeModuleRegistrarFactory;

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

	public CommunicationLink makeBridge(final BridgeCommunicatorModuleRegistrar.ModuleType moduleType)
			throws BridgeConnectionException {
		if (BridgeModuleRegistrarFactory.getInstance().fetchRegisteredModule(moduleType) != null) {
			return new CommunicationLink() {

				public Object communicate(Object data) {
					return BridgeModuleRegistrarFactory.getInstance().fetchRegisteredModule(moduleType).listen()
							.listenAndReply(data);
				}
			};
		}
		return null;
	}

}

package org.adapter.framework.worker.bridge;

import org.adapter.framework.bridge.contracts.Bridge;
import org.adapter.framework.bridge.contracts.BridgeCommunicationListener;
import org.adapter.framework.bridge.contracts.BridgeCommunicatorModuleRegistrar.ModuleType;
import org.adapter.framework.bridge.contracts.CommunicationLink;
import org.adapter.framework.bridge.contracts.Module;
import org.adapter.framework.bridge.exception.BridgeBrokenException;
import org.adapter.framework.commons.contracts.ModuleContext;

public class WorkerBridgeModule implements Module {

	private ModuleContext moduleContext;

	public void setBridgeGate(Bridge bridge) throws BridgeBrokenException {
		CommunicationLink communicationLink = bridge.makeBridge(ModuleType.BEAN);
		communicationLink.communicate("");
	}

	public BridgeCommunicationListener listen() {
		return new BridgeCommunicationListener() {

			public Object listenAndReply(Object object) {

				return moduleContext.get(object);
			}
		};
	}

}

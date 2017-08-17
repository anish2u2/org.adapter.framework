package org.adapter.framework.worker.bridge;

import org.adapter.framework.bridge.contracts.Bridge;
import org.adapter.framework.bridge.contracts.CommunicationLink;
import org.adapter.framework.bridge.contracts.Module;
import org.adapter.framework.bridge.exception.BridgeBrokenException;

public class WorkerBridgeModule implements Module {

	public void setBridgeGate(Bridge bridge) throws BridgeBrokenException {
		CommunicationLink communicationLink = bridge
				.makeBridge(org.adapter.framework.bridge.contracts.CommunicationLink.Module.BEANS);
		communicationLink.communicate("");
	}

}

package org.adapter.framework.bridge.registrar;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.adapter.framework.bridge.contracts.BridgeCommunicatorModuleRegistrar;
import org.adapter.framework.bridge.contracts.Module;

public class BridgeModuleRegistrarFactory implements BridgeCommunicatorModuleRegistrar {

	private Map<ModuleType, Module> registeredModule;

	{
		registeredModule = Collections.emptyMap();
	}

	private static BridgeModuleRegistrarFactory bridgeModuleRegistrar;

	private BridgeModuleRegistrarFactory() {
		if (registeredModule != null)
			throw new RuntimeException("Object Already created.");
	}

	public static BridgeCommunicatorModuleRegistrar getInstance() {
		if (bridgeModuleRegistrar == null) {
			bridgeModuleRegistrar = new BridgeModuleRegistrarFactory();
		}
		return bridgeModuleRegistrar;
	}

	public void registerModule(ModuleType moduleType, Module module) {
		registeredModule.put(moduleType, module);
	}

	public Collection<Module> getRegisteredModules() {

		return registeredModule.values();
	}

	public Module fetchRegisteredModule(ModuleType moduleType) {
		return registeredModule.get(moduleType);
	}

}

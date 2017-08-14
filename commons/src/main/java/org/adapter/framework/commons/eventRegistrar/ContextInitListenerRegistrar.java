package org.adapter.framework.commons.eventRegistrar;

import java.util.LinkedHashSet;
import java.util.Set;

import org.adapter.framework.commons.contracts.ContextInitListenerRegister;
import org.adapter.framework.commons.contracts.Listener;

public class ContextInitListenerRegistrar implements ContextInitListenerRegister {

	private Set<Listener> listeners;

	private static ContextInitListenerRegister instance = null;

	{
		listeners = new LinkedHashSet<Listener>();
	}

	private ContextInitListenerRegistrar() {
		if (instance != null)
			throw new RuntimeException("Instance Alraedy created.");
	}

	public static ContextInitListenerRegister getInstantce() {
		if (instance == null) {
			instance = new ContextInitListenerRegistrar();
		}
		return instance;
	}

	public void registerListener(Listener listener) {
		this.listeners.add(listener);
	}

	public Set<Listener> getListeners() {
		return this.listeners;
	}

}

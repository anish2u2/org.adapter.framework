package org.adapter.framework.commons.publisher;

import org.adapter.framework.commons.contracts.ContextInitPublisher;
import org.adapter.framework.commons.contracts.Event;
import org.adapter.framework.commons.contracts.Listener;
import org.adapter.framework.commons.contracts.Publisher;
import org.adapter.framework.commons.contracts.Registrar;
import org.adapter.framework.commons.eventRegistrar.ContextInitListenerRegistrar;

public class ContextInitEventPublisher implements ContextInitPublisher {

	private Registrar registrar = null;

	private static Publisher publisher;

	{
		registrar = ContextInitListenerRegistrar.getInstantce();
	}

	private ContextInitEventPublisher() {
		if (publisher != null)
			throw new RuntimeException("Instance Already created.");
	}

	public static Publisher getInstance() {
		if (publisher == null) {
			publisher = new ContextInitEventPublisher();
		}
		return publisher;
	}

	public void publishEvent(Event event) {
		for (Listener listener : registrar.getListeners()) {
			listener.listen(event);
		}
	}

	public void setListenerRegistrar(Registrar registrar) {
		this.registrar.getListeners().addAll(registrar.getListeners());
	}

}

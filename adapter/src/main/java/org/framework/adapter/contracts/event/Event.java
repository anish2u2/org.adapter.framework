package org.framework.adapter.contracts.event;

import org.framework.adapter.contracts.publisher.Publisher;

public interface Event {

	public void triggerEvent(Publisher publisher);
}

package org.framework.adapter.contracts.publisher;

import org.framework.adapter.contracts.event.Event;

public interface Publisher {
	
	public void publishEvent(Event event);
	
}

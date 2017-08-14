package org.adapter.framework.commons.contracts;

public interface Publisher {

	public void publishEvent(Event event);

	public void setListenerRegistrar(Registrar registrar);

}

package org.adapter.framework.commons.contracts;

/**
 * This interface allow you to publish events within the app and setting
 * listener Registers.
 * 
 * @author Anish Singh
 *
 */
public interface Publisher {

	/**
	 * This method will publish the passed event.
	 * 
	 * @param event
	 */
	public void publishEvent(Event event);

	/**
	 * This mthod will register the listener Registrar.
	 * 
	 * @param registrar
	 */
	public void setListenerRegistrar(Registrar registrar);

}

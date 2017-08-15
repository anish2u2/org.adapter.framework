package org.adapter.framework.commons.contracts;

/**
 * This interface allow to listen for Event's triggered in this application.
 * 
 * @author Anish Singh
 *
 */
public interface Listener {

	/**
	 * This method will allow to listen event triggered in this application.
	 * 
	 * @param event
	 */
	public void listen(Event event);

}

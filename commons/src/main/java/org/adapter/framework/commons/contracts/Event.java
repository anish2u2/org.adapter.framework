package org.adapter.framework.commons.contracts;

/**
 * This interface will represent a Event in thisn framework.
 * 
 * @author Anish Singh
 *
 */
public interface Event {

	/**
	 * This method will return the source Object on which event is occurred.
	 * 
	 * @return
	 */
	Object getEventSource();

}

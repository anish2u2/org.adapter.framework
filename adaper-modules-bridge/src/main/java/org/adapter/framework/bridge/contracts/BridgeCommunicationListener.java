package org.adapter.framework.bridge.contracts;

/**
 * This interface allow to listen for a bridge communication established on a
 * module.
 * 
 * @author Anish Singh
 *
 */
public interface BridgeCommunicationListener {

	/**
	 * This method will be invoked whenever other module execute communication
	 * method on established CommunicationLink and return the result to the
	 * communicator.
	 * 
	 * @param object
	 * @return
	 */
	Object listenAndReply(Object object);

}

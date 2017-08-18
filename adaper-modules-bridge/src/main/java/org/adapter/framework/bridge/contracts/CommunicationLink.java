package org.adapter.framework.bridge.contracts;

/**
 * This interface represents communication links between two modules. This will
 * be created on-demand by modules to communicate with modules.
 * 
 * @author Anish Singh
 *
 */
public interface CommunicationLink {

	/**
	 * This method will represents the communication with the module connected
	 * through the bridge communication link.
	 * 
	 * @param data
	 * @return
	 */

	Object communicate(Object data);
}

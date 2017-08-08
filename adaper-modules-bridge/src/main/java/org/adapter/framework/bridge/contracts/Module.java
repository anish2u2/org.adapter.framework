package org.adapter.framework.bridge.contracts;

import org.adapter.framework.bridge.exception.BridgeBrokenException;

/**
 * 
 * @author Anish Singh
 * 
 *         This interface will help in identify as a unique module and also
 *         while help in communication. This interface has to be implemented by
 *         modules which are going to use bridge communication.
 */
public interface Module {

	/**
	 * This will talk to individual modules and if there is anything went wrong
	 * or connection is broke the throw exception.
	 * 
	 * @param object
	 * @return
	 */
	Object talk(Object object) throws BridgeBrokenException;

	void setCommunicateToModule(Module module);

}

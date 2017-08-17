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
	 * This will represents the modules in
	 * 
	 * @author Anish Singh
	 *
	 */
	enum Module {
		UTILITY, BEANS, CONTEXT, WORKER, CORE
	}

	Object communicate(Object data);
}

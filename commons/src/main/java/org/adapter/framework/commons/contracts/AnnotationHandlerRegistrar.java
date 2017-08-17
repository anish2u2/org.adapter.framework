package org.adapter.framework.commons.contracts;

import java.util.Set;

/**
 * This interface allow to register annotation handler in this framework.
 * 
 * @author Anish Singh
 *
 */
public interface AnnotationHandlerRegistrar {

	/**
	 * registers annotation handler.
	 * 
	 * @param handler
	 */
	void registerHandler(AnnotationHandler handler);

	/**
	 * returns registered annotation handlers.
	 * 
	 * @return
	 */
	Set<AnnotationHandler> getHandlers();

}

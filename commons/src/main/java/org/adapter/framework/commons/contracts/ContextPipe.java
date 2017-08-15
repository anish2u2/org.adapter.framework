package org.adapter.framework.commons.contracts;

import java.util.Set;

/**
 * This interface represents the ContextPipe for Adapter framework and will hold
 * all the module's contexts.
 * 
 * @author Anish Singh
 *
 */
public interface ContextPipe {

	/**
	 * This method will return all the moduleContext associated with this Pipe.
	 * 
	 * @return default null.
	 */
	Set<ModuleContext> getModuleContexts();

	/**
	 * This method allow you to register module context with the ContextPipe.
	 * 
	 * @param moduleContext
	 */
	void addModuleContext(ModuleContext moduleContext);

}

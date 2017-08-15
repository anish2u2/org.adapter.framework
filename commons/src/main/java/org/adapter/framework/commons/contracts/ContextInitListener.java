package org.adapter.framework.commons.contracts;

/**
 * This interface will allow you to register module contexts to context pipe.
 * 
 * @author Anish Singh
 *
 */
public interface ContextInitListener extends Listener {
	/**
	 * This method will allow to set Context of the module to COntextPipe. Which
	 * will be used by adapter framework to access context of the modules.
	 * 
	 * @param contextPipe
	 */
	public void setContextPipe(ContextPipe contextPipe);
}

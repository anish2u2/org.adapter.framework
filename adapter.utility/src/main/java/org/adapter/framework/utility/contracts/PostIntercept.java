package org.adapter.framework.utility.contracts;

/**
 * 
 * @author Anish Singh
 * 
 *         This interface will allow to post-intercept method invocation.
 *
 */
public interface PostIntercept extends Intercept {

	/**
	 * This method will allow you to intercept post method invocation.
	 * 
	 */
	void postIntercept();

}

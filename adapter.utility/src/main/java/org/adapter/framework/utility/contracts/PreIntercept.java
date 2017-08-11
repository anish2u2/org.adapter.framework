package org.adapter.framework.utility.contracts;

/**
 * 
 * @author Anish Singh
 * 
 *         This interface will allow to pre-intercept method invocation.
 *
 */

public interface PreIntercept extends Intercept {

	/**
	 * This method will allow you to pre intercept method invocation.
	 */
	void preIntercept();
}

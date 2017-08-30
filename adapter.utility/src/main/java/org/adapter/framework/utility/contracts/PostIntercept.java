package org.adapter.framework.utility.contracts;

import java.lang.reflect.Method;

/**
 * This interface will allow to post-intercept method invocation.
 * 
 * @author Anish Singh
 * 
 * 
 *
 */
public interface PostIntercept extends Intercept {

	/**
	 * This method will allow you to Post-Intercept method invocation.
	 * 
	 * @param targetObject
	 * @param method
	 * @param args
	 */
	void setPostInterceptMethodDetails(Object targetObject, Method method, Object[] args);

}

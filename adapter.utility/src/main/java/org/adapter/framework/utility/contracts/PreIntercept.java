package org.adapter.framework.utility.contracts;

import java.lang.reflect.Method;

/**
 * This interface will allow to pre-intercept method invocation.
 * 
 * @author Anish Singh
 * 
 * 
 *
 */

public interface PreIntercept extends Intercept {

	/**
	 * This method will allow you to set the the Pre-Interceptor method
	 * invocation.
	 * 
	 * @param targetObject
	 * @param method
	 * @param args
	 */
	void setPreInterceptMethodDetails(Object targetObject, Method method, Object[] args);

}

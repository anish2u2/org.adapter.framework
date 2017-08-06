package org.adapter.framework.utility.contracts;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 
 * @author Anish Singh
 * 
 *         This Interface will be used for handling method intercept.
 *
 */
public interface Interceptor extends MethodInterceptor {

	/**
	 * Check that the method parameter is interceptable by this interceptor.
	 * 
	 * @param method
	 * @return
	 */
	public boolean isInterceptable(Method method);

	/**
	 * 
	 * @param preIntercept
	 *            will pre intercept the method invocation.
	 */
	public void setMethodPreInterceptor(PreIntercept preIntercept);

	/**
	 * 
	 * @param postIntercept
	 *            will post intercept Method invocation.
	 */
	public void setMethodPostInterceptor(PostIntercept postIntercept);
}

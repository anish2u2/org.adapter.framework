package org.adapter.framework.utility.contracts;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;

/**
 * This Interface will be used for handling method intercept.
 * 
 * @author Anish Singh
 * 
 * 
 *
 */
public interface Interceptor extends MethodInterceptor {

	/**
	 * Check that the method parameter is interceptable by this interceptor.
	 * 
	 * @param targetObject
	 *            (Field,Type,Method, etc.)
	 * @return
	 */
	public boolean isInterceptable(Object targetobject);

	/**
	 * 
	 * @param preIntercept
	 *            will pre intercept the method invocation.
	 */
	public void addMethodPreInterceptor(PreIntercept preIntercept);

	/**
	 * 
	 * @param postIntercept
	 *            will post intercept Method invocation.
	 */
	public void addMethodPostInterceptor(PostIntercept postIntercept);
}

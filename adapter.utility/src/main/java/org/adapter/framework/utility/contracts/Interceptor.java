package org.adapter.framework.utility.contracts;

/**
 * This Interface will be used for handling method intercept.
 * 
 * @author Anish Singh
 * 
 * 
 *
 */
public interface Interceptor extends org.adapter.framework.utility.contracts.MethodInterceptor {

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

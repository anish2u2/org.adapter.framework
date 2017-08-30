package org.adapter.framework.utility.contracts;

/**
 * This interface will represents a wrapper of actual Method interceptor.
 * 
 * @author Anish Singh
 *
 */
public interface MethodInterceptor {

	/**
	 * This method will intercept the method invocation.
	 * 
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 * @return
	 * @throws Throwable
	 */
	public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args, ProxyMethod proxy)
			throws Throwable;

}

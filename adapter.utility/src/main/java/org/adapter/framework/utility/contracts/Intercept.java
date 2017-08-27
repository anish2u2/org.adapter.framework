package org.adapter.framework.utility.contracts;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodProxy;

/**
 * This interface allow you to intercept method invocation.
 * 
 * @author Anish Singh
 *
 */
public interface Intercept {

	/**
	 * This method allow you to intercept the method invocation.
	 * 
	 */
	public Object intercept(Object targetObject, Method method, Object[] args, MethodProxy methodProxy);

	/**
	 * This will return true if the Intercept object is able to intercept the
	 * annotated Object(Field,Type,Method etc.).
	 * 
	 * @param targetObject
	 *            return false by default.
	 */
	boolean isInterceptable(Object targetObject);

}

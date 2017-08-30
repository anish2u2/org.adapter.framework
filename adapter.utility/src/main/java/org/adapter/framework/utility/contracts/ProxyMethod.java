package org.adapter.framework.utility.contracts;

/**
 * This interface will represent ProxyMethod for invoking actual method.
 * 
 * @author Anish Singh
 *
 */
public interface ProxyMethod {

	/**
	 * This method will invoke actual method.
	 * 
	 * @param targetObject
	 * @param args
	 * @return
	 */
	Object invokeSuper(Object targetObject, Object[] args) throws Throwable;

}

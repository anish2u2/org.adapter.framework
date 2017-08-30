package org.adapter.framework.utility.contracts;

/**
 * This interface will be responsible for constructing Objects that has to be
 * created by CGLIB proxy object creator for adding interceptors and AOP
 * mechanisms.
 * 
 * @author Anish Singh
 *
 */
public interface ObjectConstructor {

	/**
	 * This method will return the class type proxy object if it has to be. i.e.
	 * if the clazz is using annotation declared by this framework and for
	 * making those annotations, interceptors has to be registered.
	 * 
	 * 
	 * 
	 * @param clazz
	 * @return
	 */
	Object createObject(Class<?> clazz);

}

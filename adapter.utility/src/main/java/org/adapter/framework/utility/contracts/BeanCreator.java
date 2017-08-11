package org.adapter.framework.utility.contracts;

import java.util.List;

/**
 * This interface should have to be implemented by the proxy factory or the
 * factories which is responsible for creating object and linking method
 * invocations.
 * 
 * @author Anish Singh
 * 
 * 
 *
 */

public interface BeanCreator {

	/**
	 * This method will create the bean of the corresponding class type.
	 * 
	 * @param classType
	 * @return
	 */
	public Object createObject(Class<?> classType);

	/**
	 * This method will allow to set interceptors which can be used for
	 * intercepting bean method invocations.
	 * 
	 * @param interceptors
	 */
	public void setInterceptors(List<Interceptor> interceptors);
}

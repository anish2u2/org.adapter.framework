package org.adapter.framework.utility.contracts;

import java.util.Set;

/**
 * This interface represents the registration of Interceptors.
 * 
 * @author Anish Singh
 *
 */
public interface InterceptorRegistry {

	/**
	 * This method will register the interceptor available in this framework.
	 * 
	 * @param interceptors
	 */
	void registerInterceptors(Set<Interceptor> interceptors);

}

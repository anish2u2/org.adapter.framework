package org.adapter.framework.commons.contracts;

import java.util.Set;

import org.adapter.framework.utility.contracts.Interceptor;

/**
 * This interface allow to register intercepter within this framework.
 * 
 * @author Anish Singh
 *
 */
public interface InterceptorsRegistrar {

	/**
	 * This method will register the passed intercepter within the framework for
	 * intercepting methods.
	 * 
	 * @param interceptor
	 */
	public void registerInterceptor(Interceptor interceptor);

	/**
	 * This will return all the registered intercepter within the framework.
	 * 
	 * @return
	 */
	public Set<Interceptor> getRegisteredInterceptors();

}

package org.adapter.framework.bean.contracts.registrar;

import org.adapter.framework.utility.contracts.Intercept;
import org.adapter.framework.utility.contracts.Interceptor;

/**
 * This interface represents the registration of the bean annotations
 * interceptors. Implementor of this interface is responsible for registering a
 * single {@link Interceptor} implementation object which is responsible for
 * delegating invocation to registered intercept objects.
 * 
 * @author Anish Singh
 *
 */
public interface BeanAnnotationInterceptRegistrar {

	/**
	 * This will register the intercept object for intercepting the annotated
	 * method objects.
	 * 
	 * @param methodInterceptor
	 */
	void registerInterceptor(Intercept methodInterceptor);

}

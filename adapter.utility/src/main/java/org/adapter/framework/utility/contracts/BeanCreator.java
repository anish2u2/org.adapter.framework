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

	public Object createObject(Class<?> classType);

	public void setInterceptors(List<Interceptor> interceptors);
}

package org.adapter.framework.utility.contracts;

import java.util.List;

/**
 * 
 * @author Anish Singh
 * 
 *         This interface should have to be implemented by the proxy factory or
 *         the factories which is responsible for creating object and linking
 *         method invocations.
 *
 */

public interface BeanCreator {

	public Object createObject(Class<?> classType);

	public void setInterceptors(List<Interceptor> interceptors);
}

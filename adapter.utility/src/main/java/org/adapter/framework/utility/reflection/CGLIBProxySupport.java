package org.adapter.framework.utility.reflection;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * This class will provide support for creating proxy objects.
 * 
 * @author Anish Singh
 *
 */
public class CGLIBProxySupport {

	/**
	 * This method will create Object of passed clazz type and interceptors.
	 * 
	 * @param clazz
	 * @param methodInterceptor
	 * @return
	 */
	public Object createPrxyObject(Class<?> clazz, MethodInterceptor methodInterceptor) {
		return Enhancer.create(clazz, methodInterceptor);
	}

}

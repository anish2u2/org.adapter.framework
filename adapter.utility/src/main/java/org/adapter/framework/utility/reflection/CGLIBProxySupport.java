package org.adapter.framework.utility.reflection;

import java.lang.reflect.Method;
import java.util.Set;

import org.adapter.framework.utility.contracts.Interceptor;
import org.adapter.framework.utility.contracts.ProxyMethod;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * This class will provide support for creating proxy objects.
 * 
 * @author Anish Singh
 *
 */
public class CGLIBProxySupport {

	private MethodInterceptor interceptor;

	/**
	 * This method will create Object of passed clazz type and interceptors.
	 * 
	 * @param clazz
	 * @param methodInterceptor
	 * @return
	 */
	public Object createPrxyObject(Class<?> clazz) {
		return Enhancer.create(clazz, interceptor);
	}

	/**
	 * This method will set the method invocation interceptors.
	 * 
	 * @param interceptors
	 */
	public void setMethodInterceptors(final Set<org.adapter.framework.utility.contracts.Interceptor> interceptors) {
		interceptor = new MethodInterceptor() {
			private Set<Interceptor> registeredInterceptors = interceptors;

			@Override
			public Object intercept(Object obj, Method method, Object[] args, final MethodProxy proxy)
					throws Throwable {
				ProxyMethod proxyMethod = new ProxyMethod() {

					@Override
					public Object invokeSuper(Object targetObject, Object[] args) throws Throwable {

						return proxy.invokeSuper(targetObject, args);
					}
				};
				for (Interceptor interceptor : registeredInterceptors) {
					if (interceptor.isInterceptable(method)) {
						return interceptor.intercept(obj, method, args, proxyMethod);
					}
				}
				return null;
			}
		};
	}

}

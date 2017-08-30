package org.adapter.framework.utility.creator;

import java.lang.reflect.Method;
import java.util.Set;

import org.adapter.framework.utility.contracts.Interceptor;
import org.adapter.framework.utility.contracts.InterceptorRegistry;
import org.adapter.framework.utility.contracts.ObjectConstructor;
import org.adapter.framework.utility.reflection.CGLIBProxySupport;
import org.adapter.framework.utility.reflection.ReflectionUtility;
import org.adapter.framework.utility.util.Utility;

/**
 * This class will represents the factory class for ObjectConstructor &
 * InterceptorRegistry.
 * 
 * @author Anish Singh
 *
 */
public class ObjectUtilityFactory implements ObjectConstructor, InterceptorRegistry {

	private static ObjectUtilityFactory factory;

	private Set<Interceptor> registeredInterceptors;

	private CGLIBProxySupport support = new CGLIBProxySupport();

	private ObjectUtilityFactory() {
		if (factory != null) {
			throw new RuntimeException("Object Already Created.");
		}
	}

	/**
	 * Returns instance of {@code ObjectConstructor}
	 * 
	 * @return
	 */
	public static ObjectConstructor getObjectConstructorInstance() {
		return getObjectFactory();
	}

	/**
	 * Return Instance of {@code ObjectUtilityFactory}
	 * 
	 * @return
	 */
	private static ObjectUtilityFactory getObjectFactory() {
		if (factory == null) {
			factory = new ObjectUtilityFactory();
		}
		return factory;
	}

	/**
	 * returns instance of {@code InterceptorRegistry}
	 * 
	 * @return
	 */
	public static InterceptorRegistry getInterceptorRegistryInstance() {
		return getObjectFactory();
	}

	@Override
	public Object createObject(Class<?> clazz) {
		boolean createProxy = false;
		for (Method method : clazz.getDeclaredMethods()) {
			for (Interceptor interceptor : registeredInterceptors) {
				if (interceptor.isInterceptable(method)) {
					createProxy = true;
				}
			}
		}
		if (createProxy) {
			return support.createPrxyObject(clazz);
		}
		return ReflectionUtility.getInstance().instanciateOject(clazz);
	}

	@Override
	public void registerInterceptors(Set<Interceptor> interceptors) {
		registeredInterceptors = interceptors;
		support.setMethodInterceptors(registeredInterceptors);
	}

}

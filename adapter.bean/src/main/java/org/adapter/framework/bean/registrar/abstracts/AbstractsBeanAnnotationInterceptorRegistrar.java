package org.adapter.framework.bean.registrar.abstracts;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.commons.registrar.AnnotationIntercepterRegistrarFactory;
import org.adapter.framework.commons.utility.ThreadStackUtility;
import org.adapter.framework.utility.contracts.Intercept;
import org.adapter.framework.utility.contracts.Interceptor;
import org.adapter.framework.utility.contracts.PostIntercept;
import org.adapter.framework.utility.contracts.PreIntercept;
import org.adapter.framework.utility.contracts.ProxyMethod;

public class AbstractsBeanAnnotationInterceptorRegistrar implements Interceptor, InitBean, DestroyBean {

	private Set<Intercept> registeredIntercepts;

	private final static String INTERCEPTOR = "INTERCEPTOR";

	public Object intercept(Object obj, Method method, Object[] args, ProxyMethod proxy) throws Throwable {
		if (isInterceptable(method)) {
			Object result = ((Intercept) ThreadStackUtility.getInstance().getObject(INTERCEPTOR)).intercept(obj, method,
					args, proxy);
			ThreadStackUtility.getInstance().removeObject(INTERCEPTOR);
			return result;
		}
		return proxy.invokeSuper(obj, args);
	}

	public boolean isInterceptable(Object targetObject) {
		for (Intercept intercept : registeredIntercepts) {
			ThreadStackUtility.getInstance().addObject(INTERCEPTOR, intercept);
			return intercept.isInterceptable(targetObject);
		}
		return false;
	}

	public void addMethodPreInterceptor(PreIntercept preIntercept) {
		registeredIntercepts.add(preIntercept);
	}

	public void addMethodPostInterceptor(PostIntercept postIntercept) {
		registeredIntercepts.add(postIntercept);
	}

	public void destroy() {
		registeredIntercepts.clear();
		registeredIntercepts = null;
	}

	public void init() {
		registeredIntercepts = new HashSet<Intercept>();
		AnnotationIntercepterRegistrarFactory.getInstance().registerInterceptor(this);
	}

	/**
	 * This will register the Intercept instance.
	 * 
	 * @param intercept
	 */

	protected void register(Intercept intercept) {
		this.registeredIntercepts.add(intercept);
	}
}

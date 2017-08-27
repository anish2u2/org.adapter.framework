package org.adapter.framework.bean.interceptors;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodProxy;

public class PreIntercept implements org.adapter.framework.utility.contracts.PreIntercept {

	public Object intercept(Object targetObject, Method method, Object[] args, MethodProxy methodProxy) {
		
		return null;
	}

	public boolean isInterceptable(Object targetObject) {
		
		return false;
	}

}

package org.adapter.framework.bean.interceptors;

import java.lang.reflect.Method;

import org.adapter.framework.utility.contracts.PostIntercept;

import net.sf.cglib.proxy.MethodProxy;

public class PostIntercet implements PostIntercept {

	public Object intercept(Object targetObject, Method method, Object[] args, MethodProxy methodProxy) {

		return null;
	}

	public boolean isInterceptable(Object targetObject) {

		return false;
	}

}

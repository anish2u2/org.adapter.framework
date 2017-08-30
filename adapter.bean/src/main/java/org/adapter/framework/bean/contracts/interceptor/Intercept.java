package org.adapter.framework.bean.contracts.interceptor;

import java.lang.reflect.Method;

public interface Intercept {

	void intercept();

	void setPreInterceptMethodDetails(Object targetObject, Method method, Object[] args);

	void setPostInterceptMethodDetails(Object targetObject, Method method, Object[] args);

	void setAroundInterceptMethodDetails(Object targetObject, Method method, Object[] args);

	boolean isInterceptable(Method method);
}

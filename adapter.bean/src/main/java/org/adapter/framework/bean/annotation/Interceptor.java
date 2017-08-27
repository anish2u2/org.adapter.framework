package org.adapter.framework.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation will be used to intercept method invocation.
 * 
 * @author Anish Singh
 * 
 * 
 *
 */

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Interceptor {

	public enum InterceptType {
		PRE, POST
	}

	/**
	 * name of the interceptor like pre,post intercept.
	 * 
	 * @return
	 */
	InterceptType interceptorType();

	/**
	 * This will provide the type of the target class.
	 * 
	 * @return
	 */
	String targetClass();

	/**
	 * This will provide the name of the method on the target class instance.
	 * 
	 * @return
	 */
	String targetMethod();
}

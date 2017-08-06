package org.adapter.framework.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Anish Singh
 * 
 *         This annotation will be used to method for interception.
 *
 */

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Interceptor {

	public enum Intercept {
		PRE, POST
	}

	/**
	 * name of the interceptor like pre,post intercept.
	 * 
	 * @return
	 */
	Intercept[] interceptor();
}

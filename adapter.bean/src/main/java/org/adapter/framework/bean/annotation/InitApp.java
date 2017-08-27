package org.adapter.framework.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This will be used to start the execution of app.
 * 
 * @author Anish Singh
 *
 * 
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InitApp {

	/**
	 * This will specify name of the app.
	 * 
	 * @return
	 */
	String appName() default "";

	/**
	 * This will specify name of method execution point.
	 * 
	 * @return
	 */
	String executionPoint();
}

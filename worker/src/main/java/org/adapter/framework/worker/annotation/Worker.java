package org.adapter.framework.worker.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation will be used to identify the class which will be used to
 * execute work as a thread.
 * 
 * @author Anish Singh
 *
 */

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Worker {

	/**
	 * This will specify the name of worker. if no name is defined then by
	 * default it returns WORKER.
	 * 
	 * @return
	 */
	String name() default "WORKER";

}

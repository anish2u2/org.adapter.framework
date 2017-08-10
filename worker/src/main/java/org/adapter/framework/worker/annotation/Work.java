package org.adapter.framework.worker.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This Annotation will be used to execute the annotated task under a worker.
 * 
 * @author Anish Singh
 *
 */

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Work {

	/**
	 * This enum will be used to denote the work to be SYNCHRONIZED or not.
	 * 
	 * @author Anish Singh
	 *
	 */
	enum Type {
		SYNCHRONIZED, UNSYNCHRONIZED
	};

	/**
	 * This will specify the name of the work.by default it will be Work.
	 * 
	 * @return
	 */
	String name() default "Work";

	/**
	 * If the annotated method should be synchronized the this value has to be
	 * as Type.SYNCHRONIZED. By default it will be unsynchronized.
	 * 
	 * @return
	 */
	Type type() default Type.UNSYNCHRONIZED;
}

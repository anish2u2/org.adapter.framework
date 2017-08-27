package org.adapter.framework.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This Annotation will be used for creating objects and object will be injected
 * using InjectBean.
 * 
 * @author Anish Singh
 * 
 * 
 *
 */

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
	/**
	 * Scope of the object.
	 * 
	 * @author Anish Singh
	 *
	 */
	public enum Scope {
		PROTOTYPE, SINGLETONE
	}

	/**
	 * This will return the scope of the annotated class instance.
	 * 
	 * @return
	 */
	Scope scope() default Scope.SINGLETONE;

	/**
	 * This will return the name of the App.
	 * 
	 * @return
	 */
	String name();

	/**
	 * If the bean is declared as {@code Scope.SINGLETONE} the this will return
	 * the object init method.
	 * 
	 * @return
	 */
	String beanInitMethod() default "";
}

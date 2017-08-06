package org.adapter.framework.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Anish Singh
 * 
 *         This Annotation will be used for creating objects and object will be
 *         injected using InjectBean.
 *
 */

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

	public enum Scope {
		PROTOTYPE, SINGLETONE
	}

	Scope scope() default Scope.SINGLETONE;

	String name();

	String beanInitMethod() default "";
}

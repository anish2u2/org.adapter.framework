package org.adapter.framework.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This Annotation will be used for injecting bean.
 * 
 * @author Anish Singh
 * 
 * 
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectBean {

	String qualifier() default "NULL";

}

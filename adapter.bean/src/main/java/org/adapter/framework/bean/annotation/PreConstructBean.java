package org.adapter.framework.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This Annotation will be used to invoke method before the initialization of
 * the object.
 * 
 * @author Anish Singh
 * 
 * 
 */

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PreConstructBean {

}

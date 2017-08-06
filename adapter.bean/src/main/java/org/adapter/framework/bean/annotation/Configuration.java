package org.adapter.framework.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Anish Singh
 *
 *         This will be used for initiating the COnfiguration of the framework
 *         by sub modules.
 *
 */

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Configuration {

	/**
	 * This will tell the framework to look into package for init the module.
	 * 
	 * @return
	 */
	String lookUpPackageName() default "";

	/**
	 * This will tell the framework to init class of the sub module.
	 * 
	 * @return
	 */
	String[] initModuleClass() default "NULL";

}

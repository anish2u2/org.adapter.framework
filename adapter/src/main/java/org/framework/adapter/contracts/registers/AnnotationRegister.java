package org.framework.adapter.contracts.registers;

import java.lang.annotation.Annotation;

/**
 * This interface allow to register annotations of different modules which can
 * be used for annotations.
 * 
 * @author Anish Singh
 *
 */
public interface AnnotationRegister {

	/**
	 * This method register the param annotation.
	 * 
	 * @param annotation
	 */
	void registerAnnotation(Annotation annotation);

}

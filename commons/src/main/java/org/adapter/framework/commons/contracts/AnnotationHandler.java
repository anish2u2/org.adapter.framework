package org.adapter.framework.commons.contracts;

import java.util.List;

/**
 * This interface will allow you to register annotations and dispatch classes
 * that contains annotations.
 * 
 * @author Anish Singh
 *
 */
public interface AnnotationHandler {

	/**
	 * returns annotations associated with it.
	 * 
	 * @return
	 */
	public List<Class<?>> getAnnotations();

	/**
	 * dispatch object creation request for the clazz which is annotated with
	 * the registered annotations.
	 * 
	 * @param clazz
	 */
	public Object doHandle(Class<?> clazz);
	
	
}

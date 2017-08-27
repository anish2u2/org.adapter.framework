package org.adapter.framework.commons.contracts;

import java.lang.reflect.Field;

/**
 * This interface will be responsible for handling the injection of field.
 * 
 * @author Anish Singh
 *
 */
public interface FieldInjector {
	/**
	 * This method will check that this FieldInjector can inject the field or
	 * not.
	 * 
	 * @param field
	 * @return
	 */
	public boolean isFieldInjectable(Field field);

	/**
	 * This method will inject the field passed as parameter to the object
	 * passed as parameter.
	 * 
	 * @param targetObject
	 * @param field
	 */
	public void injectField(Object targetObject, Field field);

}

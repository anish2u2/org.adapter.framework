package org.adapter.framework.commons.contracts;

/**
 * This interface will allow you to register the FieldInjector annotations.
 * 
 * @author Anish Singh
 *
 */
public interface FieldInjectorRegistrar {

	/**
	 * This method will register the fieldinjector.
	 * 
	 * @param fieldInjector
	 */
	void registerInjector(FieldInjector fieldInjector);

}

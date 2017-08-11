package org.adapter.framework.utility.contracts;

/**
 * This interface allow you to register/remove File filters for processing the
 * files raeding technology.
 * 
 * @author Anish Singh
 *
 */
public interface FilterRegistrar {

	/**
	 * This method will register the param filter for processing Files.
	 * 
	 * @param filter
	 */
	public void registerFilter(FileFilter filter);

	/**
	 * This method will remove the registered file filter.
	 * 
	 * @param filter
	 */
	public void removeFilter(FileFilter filter);
}

package org.adapter.framework.utility.contracts;

import java.util.List;

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

	/**
	 * This method will return the registered FileFilters associated with this
	 * register.
	 * 
	 * @return
	 */
	public List<FileFilter> getRegisteredFilters();
}

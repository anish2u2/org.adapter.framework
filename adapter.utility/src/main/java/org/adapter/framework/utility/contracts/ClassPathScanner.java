package org.adapter.framework.utility.contracts;

import java.util.List;

/**
 * This interface will allow to scan class path for classes and other documents.
 *
 * 
 * @author Anish Singh
 * 
 * 
 */
public interface ClassPathScanner {

	/**
	 * This method will register the FilterRegister.
	 * 
	 * @param registrar
	 */
	public void registerFilter(FilterRegistrar registrar);

	/**
	 * This method will unregister All the FilterRegister.
	 */
	public void unRegisterFilters();

	/**
	 * This method will unregister the given FilterRegister.
	 * 
	 * @param filterRegistrar
	 */
	public void unRegisterFilters(FilterRegistrar filterRegistrar);

	/**
	 * This method will scan the whole app.
	 * 
	 * @return
	 */
	public List<Class<?>> scan();

	/**
	 * This method will tell you that file exists or not on the basis of
	 * FIleFIlter which contains the file naming structure.
	 * 
	 * @param fileFilter
	 * @return
	 */
	/*public boolean isFileExist(FileFilter fileFilter);*/

	/**
	 * Return the found file on basis of FilterFIle.If no files found then it
	 * will return null.
	 * 
	 * @param fileFilter
	 * @return
	 */
	/*public File getFile(FileFilter fileFilter);*/
}

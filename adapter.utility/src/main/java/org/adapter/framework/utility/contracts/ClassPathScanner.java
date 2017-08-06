package org.adapter.framework.utility.contracts;

import java.io.File;
import java.util.List;

/**
 * 
 * @author Anish Singh
 * 
 *         This interface will allow to scan class path for classes and other
 *         documents.
 *
 */
public interface ClassPathScanner {

	public void registerFilter(FilterRegistrar registrar);

	public void unRegisterFilters();

	public List<Class<?>> scan();

	public boolean isFileExist(FileFilter fileFilter);

	public File getFile(FileFilter fileFilter);
}

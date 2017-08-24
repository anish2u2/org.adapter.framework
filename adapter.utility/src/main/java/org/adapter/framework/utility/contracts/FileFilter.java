package org.adapter.framework.utility.contracts;

import java.io.FilenameFilter;
import java.util.List;

/**
 * This interface allow you to filter files while reading files using JAVA NIO
 * classes.
 * 
 * @author Anish Singh
 *
 */
public interface FileFilter {
	/**
	 * This method will allow you to filter the filename.
	 * 
	 * @param fileName
	 */
	void filter(String fileName);

	/**
	 * This method will be used to add the result found after applying this
	 * filter.
	 * 
	 * @param fullyQualifiedFileName
	 */
	void addFileName(String fullyQualifiedFileName);

	/**
	 * This method will return all the result found after processing this
	 * filter. default is null.
	 * 
	 * @return
	 */
	List<String> filteredFileNames();

}

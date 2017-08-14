package org.adapter.framework.utility.contracts;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * 
 * This interface allow to deal with File processing.
 * 
 * @author Anish Singh
 *
 */
public interface FileProcessing {

	/**
	 * This method will create a file as per given fully qualified file name
	 * with path.
	 * 
	 * @param fileLocation
	 * @return
	 */
	File createNewFile(String fullyQualifiedfileName);

	/**
	 * This method will create a file with the given location and filename.
	 * 
	 * @param fileLocation
	 * @param FileName
	 * @return
	 */
	File createNewFile(String fileLocation, String FileName);

	/**
	 * This method will allow you to read file from the given location;
	 * 
	 * @param fileLocation
	 * @return
	 */
	InputStream readFile(String fullyQualifiedFileName);

	/**
	 * This method reads the Files under the location given as parameter.
	 * 
	 * @param location
	 * @return array of File or null.
	 */
	File[] readLocation(String location);

	/**
	 * This method allow you to write data from inputStream to given
	 * fullyQualified path.
	 * 
	 * @param inputStream
	 * @param fullyQualifiedFileName
	 */
	void writeToFile(InputStream inputStream, String fullyQualifiedFileName);

	/**
	 * This method will create directory using given location and directory
	 * name.
	 * 
	 * @param location
	 * @param directoryName
	 * @return
	 */
	File createDirectory(String location, String directoryName);

	/**
	 * This method will read the jar file and return the associated result after
	 * processing FileFilter.
	 * 
	 * @param fileFilter
	 * @return
	 */
	List<FileFilter> readJar(String jarPath, List<FileFilter> fileFilter);
}

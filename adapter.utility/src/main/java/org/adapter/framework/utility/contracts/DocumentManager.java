package org.adapter.framework.utility.contracts;

import java.io.InputStream;

/**
 * This interface allow to read/write doc files like XML,TXT etc.
 * 
 * @author Anish Singh
 *
 */
public interface DocumentManager {

	/**
	 * This method lets you read the document to corresponding class type object
	 * and returns Object. If there is any error while reading then it will
	 * return null .
	 * 
	 * @param fileName
	 * @param parseToType
	 * @return
	 */
	public Object readDoc(String fileName, Class<?> parseToType);

	/**
	 * This method lets you write the doc toa file from the data source object.
	 * 
	 * @param toFile
	 * @param dataSource
	 * @return
	 */
	public InputStream writeDoc(String toFile, Object dataSource);
}

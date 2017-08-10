package org.adapter.framework.logging.contracts;

/**
 * This Interface allow to log framework logger. By deafult it will write to
 * console.
 * 
 * @author Anish Singh
 *
 */
public interface Logger {

	/**
	 * This will write info param message to stream.
	 * 
	 * @param message
	 */
	public void info(String message);

	/**
	 * This will write warn param message to stream.
	 * 
	 * @param message
	 */
	public void warn(String message);

	/**
	 * This will write error param message to stream.
	 * 
	 * @param message
	 */
	public void error(String message);

}

package org.adapter.framework.logging.logger;

import java.io.ObjectStreamException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;

import org.adapter.framework.logging.contracts.Logger;

/**
 * This class is responsible for making Logger Object.
 * 
 * @author Anish Singh
 *
 */

public class LoggerFactory implements Logger, Serializable {

	private static final long serialVersionUID = 13455439536L;
	private static Logger LOGGER = null;
	private PrintWriter writer = null;
	static {
		LOGGER = new LoggerFactory();
	}

	private LoggerFactory() {

		if (LOGGER != null)
			throw new RuntimeException("Trying to create object of Logger.");
		writer = new PrintWriter(System.out);
	}

	public static final Logger getLogger() {
		return LOGGER;
	}

	public static final Logger getLogger(String fullyQualifiedPath) {
		return LOGGER;
	}

	public void info(String message) {
		writer.write("INFO[" + getDateNClassName() + "] " + message);
	}

	public void warn(String message) {
		writer.write("WARNING[" + getDateNClassName() + "] " + message);
	}

	public void error(String message) {
		writer.write("ERROR[" + getDateNClassName() + "] " + message);
	}

	public void logException(Exception ex) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("message:" + ex.getLocalizedMessage());
		for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
			buffer.append("Line Number:" + stackTraceElement.getLineNumber());
			buffer.append("Method Name:" + stackTraceElement.getMethodName());
			buffer.append("Class Name:" + stackTraceElement.getClassName());
			buffer.append("caller:" + stackTraceElement.getFileName());
		}
		error(buffer.toString());
	}

	private String getDateNClassName() {
		return new Date() + " " + this.getClass().getName();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return LOGGER;
	}

	Object writeReplace() throws ObjectStreamException {
		return LOGGER;
	}

	Object readResolve() throws ObjectStreamException {
		return LOGGER;
	}
}

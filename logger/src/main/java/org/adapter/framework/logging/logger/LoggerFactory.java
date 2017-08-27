package org.adapter.framework.logging.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	/*
	 * { LOGGER = new LoggerFactory(); }
	 */

	private LoggerFactory() {

		if (LOGGER != null)
			throw new RuntimeException("Trying to create object of Logger.");
		writer = new PrintWriter(System.out);
	}

	private LoggerFactory(String FilePath) {

		if (LOGGER != null)
			throw new RuntimeException("Trying to create object of Logger.");
		try {
			writer = new PrintWriter(new FileOutputStream(new File(FilePath)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final Logger getLogger() {
		if (LOGGER == null)
			LOGGER = new LoggerFactory();
		return LOGGER;
	}

	public static final Logger getLogger(String fullyQualifiedPath) {
		if (LOGGER == null) {
			LOGGER = new LoggerFactory(fullyQualifiedPath);

		}
		return LOGGER;
	}

	public void info(String message) {
		writer.write("INFO[" + getDateNClassName() + "] " + message + '\n');
		writer.flush();
		// System.out.println("INFO[" + getDateNClassName() + "] " + message+
		// '\n');
	}

	public void warn(String message) {
		writer.write("WARNING[" + getDateNClassName() + "] " + message + '\n');
		writer.flush();
	}

	public void error(String message) {
		writer.write("ERROR[" + getDateNClassName() + "] " + message + '\n');
		writer.flush();
	}

	public void logException(Exception ex) {
		/*
		 * StringBuffer buffer = new StringBuffer(); buffer.append("message:" +
		 * ex.getLocalizedMessage()); for (StackTraceElement stackTraceElement :
		 * ex.getStackTrace()) { buffer.append("Line Number:" +
		 * stackTraceElement.getLineNumber() + '\n'); buffer.append(
		 * "Method Name:" + stackTraceElement.getMethodName() + '\n');
		 * buffer.append("Class Name:" + stackTraceElement.getClassName() +
		 * '\n'); buffer.append("caller:" + stackTraceElement.getFileName() +
		 * '\n'); } error(buffer.toString());
		 */
		ex.printStackTrace();
	}

	private String getDateNClassName() {
		return new Date().toString(); /* + " " + this.getClass().getName(); */
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

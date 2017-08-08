package org.adapter.framework.context.contracts;

import java.util.Locale;

/**
 * 
 * @author Anish Singh
 * 
 *         This interface is responsible for accessing properties from message
 *         bundles and also for reading system properties.
 *
 */

public interface ApplicationProperty {

	/**
	 * This method reads the property on the basis of propkey, and push the args
	 * if args param is not null on the basis of locale it will pick the
	 * respective message bundle.
	 * 
	 * @param propKey
	 * @param args
	 * @param locale
	 * @return
	 */
	public String getProperty(String propKey, Object[] args, Locale locale);

	/**
	 * This method reads the property on the basis of propkey on the basis of
	 * locale it will pick the respective message bundle.
	 * 
	 * @param propKey
	 * @param locale
	 * @return
	 */
	public String getProperty(String propKey, Locale locale);

	/**
	 * This method reads the property on the basis of propkey on basis of
	 * default language i.e. EN.
	 * 
	 * @param propKey
	 * @return
	 */
	public String getProperty(String propKey);

	/**
	 * This will return the System property.
	 * 
	 * @param propName
	 * @return
	 */
	public String getSystemProperty(String propName);
}

package org.adapter.framework.core.contracts;

/**
 * 
 * @author Anish Singh
 * 
 *         This interface allow to find object of respective class type or with
 *         the qualifier name, if no object found then it will try to create one
 *         and put it into respective cache.
 *
 */

public interface BeanFactory {

	/**
	 * This method will fetch the bean for the corresponding class and return
	 * the Object. If no Object found then it will create a fresh object and
	 * keep that object into cache and return the object to the caller.
	 * 
	 * @param clazz
	 * @return
	 */
	public Object getBean(Class<?> clazz);

	/**
	 * This method will fetch the bean based on the name of the bean while
	 * defining bean using @Component annotation and return the Object.If no
	 * Object found then it will create a fresh object and keep that object into
	 * cache and return the object to the caller.
	 * 
	 * @param clazz
	 * @return
	 */
	public Object getBean(String qualifier);

}

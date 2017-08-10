package org.adapter.framework.core.contracts.cache;

/**
 * 
 * @author Anish Singh
 * 
 *         This Interface will be used for accessing objects from cache.
 *
 */

public interface BeanCache {

	/**
	 * This method will return Object from cache. if no object found then it
	 * will return null.
	 * 
	 * @param clazz
	 * @return
	 */

	public Object getBean(Class<?> clazz);

}

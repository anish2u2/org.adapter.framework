package org.adapter.framework.core.contracts.register;

import org.adapter.framework.core.contracts.cache.BeanCache;

/**
 * This interface will allow to register Bean Cache.
 * 
 * @author Anish Singh
 *
 */
public interface BeanCacheRegister {

	/**
	 * This method will allow to register available cache in the framework.
	 * 
	 * @param cache
	 */
	void registerBeanCache(BeanCache cache);

}

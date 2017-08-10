package org.adapter.framework.core.contracts.register;

import org.adapter.framework.core.contracts.factory.BeanFactory;

/**
 * This interface Allow to register bean factories.
 * 
 * @author Anish Singh
 *
 */
public interface BeanFactoryRegister {

	/**
	 * This method will register Bean Factory available in this framework.
	 * 
	 * @param beanFactory
	 */
	void registerBeanFactory(BeanFactory beanFactory);

}

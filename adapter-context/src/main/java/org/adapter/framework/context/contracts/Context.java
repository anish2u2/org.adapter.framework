package org.adapter.framework.context.contracts;

/**
 * This Interface represents the core interface of The Adapter Framework.
 * Implementor of This will be used to access beans into app.
 * 
 * @author Anish Singh
 *
 */
public interface Context {

	ApplicationProperty getApplicationProperty();

	/**
	 * This will return the bean defined with the beanQualifier using @Component
	 * Annotation if no bean found then it will return null;
	 * 
	 * @param beanQualifier
	 * @return
	 */
	Object getBean(String beanQualifier);

	/**
	 * This will return the bean defined with the beanQualifier using @Component
	 * Annotation. Always return a object.
	 * 
	 * @param clazz
	 * @return
	 */
	Object getBean(Class<?> clazz);

}

package org.adapter.framework.commons.contracts;

public interface ModuleContext {

	Object getBean(String qualifier);

	Object getBean(Class<?> clazz);

	Object get(Object object);

	void add(Object object);

	void addBean(String qualifier, Object object);

	void addBean(Class<?> clazz, Object object);
}

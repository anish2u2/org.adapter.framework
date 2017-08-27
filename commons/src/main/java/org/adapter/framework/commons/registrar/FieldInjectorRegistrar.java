package org.adapter.framework.commons.registrar;

import java.util.HashSet;
import java.util.Set;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.FieldInjector;
import org.adapter.framework.commons.contracts.InitBean;

public class FieldInjectorRegistrar
		implements org.adapter.framework.commons.contracts.FieldInjectorRegistrar, InitBean, DestroyBean {

	private Set<FieldInjector> registeredFieldInjector;

	private static FieldInjectorRegistrar fieldInjectorRegistrar;

	private FieldInjectorRegistrar() {
		if (fieldInjectorRegistrar != null) {
			throw new RuntimeException("Object Already Created.");
		}
	}

	{
		init();
	}

	/**
	 * This method will return the instance of the
	 * {@code org.adapter.framework.commons.contracts.FieldInjectorRegistrar}
	 * 
	 * @return
	 */
	public static org.adapter.framework.commons.contracts.FieldInjectorRegistrar getInstance() {
		if (fieldInjectorRegistrar == null) {
			fieldInjectorRegistrar = new FieldInjectorRegistrar();
		}
		return fieldInjectorRegistrar;
	}

	public void registerInjector(FieldInjector fieldInjector) {
		registeredFieldInjector.add(fieldInjector);
	}

	public void destroy() {
		registeredFieldInjector.clear();
		registeredFieldInjector = null;
		fieldInjectorRegistrar = null;
	}

	public void init() {
		registeredFieldInjector = new HashSet<FieldInjector>();
	}

}

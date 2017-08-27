package org.adapter.framework.commons.registrar;

import java.util.HashSet;
import java.util.Set;

import org.adapter.framework.commons.contracts.BeanConstructorInitListenerRegistrar;
import org.adapter.framework.commons.contracts.BeanCreationListener;
import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;

public class BeanConstructorInitRegistrar implements BeanConstructorInitListenerRegistrar, InitBean, DestroyBean {

	private static BeanConstructorInitRegistrar beanConstructorInitRegistrar;

	private Set<BeanCreationListener> registeredListeners;

	private BeanConstructorInitRegistrar() {
		if (beanConstructorInitRegistrar != null)
			throw new RuntimeException("Object Already Created.");
	}

	{
		init();
	}

	/**
	 * This method will return the Instance of
	 * {@code BeanConstructorInitListenerRegistrar}
	 * 
	 * @return
	 */
	public static BeanConstructorInitListenerRegistrar getInstance() {
		if (beanConstructorInitRegistrar == null) {
			beanConstructorInitRegistrar = new BeanConstructorInitRegistrar();
		}
		return beanConstructorInitRegistrar;
	}

	public void registerListener(BeanCreationListener listener) {
		registeredListeners.add(listener);
	}

	public void destroy() {
		registeredListeners.clear();
		registeredListeners = null;
		beanConstructorInitRegistrar = null;

	}

	public void init() {
		registeredListeners = new HashSet<BeanCreationListener>();

	}

}

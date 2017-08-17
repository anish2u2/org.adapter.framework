package org.adapter.framework.worker.module;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.commons.contracts.ModuleContext;

public class WorkerContext implements ModuleContext, InitBean, DestroyBean {

	public Object getBean(String qualifier) {

		return null;
	}

	public Object getBean(Class<?> clazz) {

		return null;
	}

	public Object get(Object object) {

		return null;
	}

	public void add(Object object) {

	}

	public void addBean(String qualifier, Object object) {

	}

	public void addBean(Class<?> clazz, Object object) {

	}

	public void destroy() {

	}

	public void init() {

	}

}

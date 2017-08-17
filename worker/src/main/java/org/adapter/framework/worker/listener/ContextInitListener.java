package org.adapter.framework.worker.listener;

import org.adapter.framework.commons.contracts.ContextPipe;
import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.Event;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.commons.contracts.ModuleContext;

public class ContextInitListener
		implements org.adapter.framework.commons.contracts.ContextInitListener, InitBean, DestroyBean {

	private ModuleContext moduleContext;

	public void listen(Event event) {

	}

	public void setContextPipe(ContextPipe contextPipe) {
		contextPipe.addModuleContext(moduleContext);
	}

	public void setModuleContext(ModuleContext moduleContext) {
		this.moduleContext = moduleContext;
	}

	public ModuleContext getModuleContext() {
		return moduleContext;
	}

	@Override
	protected void finalize() throws Throwable {
		moduleContext = null;
		super.finalize();
	}

	public void destroy() {
		moduleContext = null;

	}

	public void init() {

	}
}

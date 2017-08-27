package org.adapter.framework.bean.module;

import org.adapter.framework.bean.registrar.BeanAnnotationsInterceptregistrar;
import org.adapter.framework.commons.contracts.Module;
import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;

public class BeanModule implements Module {

	Logger logger = LoggerFactory.getLogger();

	public void initModule() {
		logger.info("initializing  Bean modules..");
		registerMethodInterceptors();
	}

	public void destroyModule() {

	}

	private void registerMethodInterceptors() {
		BeanAnnotationsInterceptregistrar.getInstance().registerInterceptor(methodInterceptor);
	}
}

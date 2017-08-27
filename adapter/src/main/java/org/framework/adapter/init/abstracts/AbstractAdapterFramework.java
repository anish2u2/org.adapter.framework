package org.framework.adapter.init.abstracts;

import org.adapter.framework.commons.contracts.Module;
import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;
import org.framework.adapter.contracts.lifeCycle.Adapter;

/**
 * This abstract class is responsible for handling the initialization and
 * destruction of the framework.
 * 
 * @author Anish Singh
 *
 */

public abstract class AbstractAdapterFramework implements Adapter {

	protected static Logger logger = LoggerFactory.getLogger();

	private Module module;

	public void init() {
		logger.info("Initiating Module initialization.");
		try {
			module = (Module) Class.forName("org.adapter.framework.core.inti.InitCore").newInstance();
			module.initModule();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		logger.info("Destroying Framework.");
		module.destroyModule();
	}
}

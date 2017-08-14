package org.framework.adapter.init.abstracts;

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

	public void init() {
		logger.info("Initiating Module initialization.");
		
	}

	public void destroy() {
		logger.info("Destroying Framework.");
	}
}

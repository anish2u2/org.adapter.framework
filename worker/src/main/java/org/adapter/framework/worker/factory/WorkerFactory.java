package org.adapter.framework.worker.factory;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;
import org.adapter.framework.worker.colony.WorkerImpl;
import org.adapter.framework.worker.contracts.worker.Worker;

public class WorkerFactory
		implements org.adapter.framework.worker.contracts.worker.WorkerFactory, InitBean, DestroyBean {

	Logger logger = LoggerFactory.getLogger();

	private static org.adapter.framework.worker.contracts.worker.WorkerFactory workerFactory = null;

	{
		init();
	}

	private WorkerFactory() {
		logger.info("Creating Object " + this.getClass().getName());
		if (workerFactory != null)
			throw new RuntimeException("Object Already Created.");

	}

	/**
	 * This method will return the instance of the WorkerFactory.
	 * 
	 * @return
	 */
	public static org.adapter.framework.worker.contracts.worker.WorkerFactory getInstance() {
		if (workerFactory == null)
			workerFactory = new WorkerFactory();
		return workerFactory;
	}

	public Worker hireNewWorker(boolean isBackGroundWorker) {
		Worker worker = new WorkerImpl();
		worker.setAsBackGroundWorker(isBackGroundWorker);
		worker.init();
		return worker;
	}

	public void destroy() {
		logger = null;
		workerFactory = null;
	}

	public void init() {

	}

	@Override
	protected void finalize() throws Throwable {
		destroy();
		super.finalize();
	}
}

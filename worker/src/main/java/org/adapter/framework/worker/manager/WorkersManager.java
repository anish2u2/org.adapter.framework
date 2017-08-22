package org.adapter.framework.worker.manager;

import org.adapter.framework.worker.contracts.manager.WorkManager;
import org.adapter.framework.worker.contracts.worker.Worker;
import org.adapter.framework.worker.contracts.worker.WorkerFactory;
import org.adapter.framework.worker.manager.abstracts.Manager;

public class WorkersManager extends Manager {

	private WorkerFactory workerfactory;

	private static WorkersManager manager;

	private WorkersManager() {
		if (manager != null)
			throw new RuntimeException("Object Already Created.");
	}

	/**
	 * This method will return the instance of the Workers Manager. Which will
	 * be the responsible for handling life cycle of the workers.
	 * 
	 * @return
	 */
	public static WorkManager getInstance() {
		if (manager == null)
			manager = new WorkersManager();
		return manager;
	}

	@Override
	public void init() {
		super.init();
		workerfactory = new org.adapter.framework.worker.factory.WorkerFactory();
	}

	@Override
	protected Worker hireWorker(boolean isBackGroudWorker) {
		return workerfactory.hireNewWorker(isBackGroudWorker);
	}

	@Override
	public void destroy() {
		workerfactory = null;
		super.destroy();
	}
}

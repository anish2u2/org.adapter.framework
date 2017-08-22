package org.adapter.framework.worker.factory;

import org.adapter.framework.worker.WorkerImpl;
import org.adapter.framework.worker.contracts.worker.Worker;

public class WorkerFactory implements org.adapter.framework.worker.contracts.worker.WorkerFactory {

	public Worker hireNewWorker(boolean isBackGroundWorker) {
		Worker worker = new WorkerImpl();
		worker.setAsBackGroundWorker(isBackGroundWorker);
		return worker;
	}

}

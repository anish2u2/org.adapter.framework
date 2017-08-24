package org.adapter.framework.worker.manager.abstracts;

import java.util.LinkedList;
import java.util.List;

import org.adapter.framework.worker.contracts.manager.WorkManager;
import org.adapter.framework.worker.contracts.work.Work;
import org.adapter.framework.worker.contracts.worker.Worker;

public abstract class Manager implements WorkManager {

	private static List<Worker> registeredWorkers = null;

	protected Manager() {

	}

	public void init() {
		registeredWorkers = new LinkedList<Worker>();
	}

	public void destroy() {
		registeredWorkers.clear();
		registeredWorkers = null;
	}

	public void allocateWorker(Work work) {

		findAvailableWorker(false).doWork(work);
	}

	public void releaseAllWorkers() {
		registeredWorkers.clear();
	}

	public void releaseWorker(Worker worker) {
		registeredWorkers.remove(worker);
	}

	public void registerWorker(Worker worker) {
		registeredWorkers.add(worker);
	}

	public void allocateDeamonWorker(Work work) {
		findAvailableWorker(true).doWork(work);
	}

	public int numberOfWorkers() {

		return 0;
	}

	public int numberOfWorkingWorkers() {

		return 0;
	}

	/**
	 * This method will return a new Worker which can be assigned to a work by
	 * the Manager.
	 * 
	 * @return
	 */
	protected abstract Worker hireWorker(boolean isBackEndWorker);

	/**
	 * This method will find the available worker, if no Worker found then it
	 * will hire new worker.
	 * 
	 * @return
	 */
	private Worker findAvailableWorker(boolean isbackEndWorker) {
		if (registeredWorkers == null || registeredWorkers.size() > 0)
			return null;
		for (Worker worker : registeredWorkers) {
			if (worker.isAvailable()) {
				if (isbackEndWorker && !worker.isBackEndWorker()) {
					continue;
				}
				return worker;
			}
		}
		Worker worker = hireWorker(isbackEndWorker);
		registeredWorkers.add(worker);
		return worker;
	}
}

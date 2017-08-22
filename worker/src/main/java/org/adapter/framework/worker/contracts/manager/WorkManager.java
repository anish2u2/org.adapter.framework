package org.adapter.framework.worker.contracts.manager;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.worker.contracts.work.Work;
import org.adapter.framework.worker.contracts.worker.Worker;

/**
 * This interface will represents the Manager for Worker Thread which manages
 * Workers and their task allocations.
 * 
 * @author Anish Singh
 *
 */
public interface WorkManager extends InitBean, DestroyBean {

	/**
	 * This method allow you to assign given work to a worker available if no
	 * Worker is available then it will create new and assign to the worker.
	 * 
	 * @param work
	 */
	void allocateWorker(Work work);

	/**
	 * This method will release all workers registered under this maager.
	 */
	void releaseAllWorkers();

	/**
	 * This method will release the @param worker registered with this Manager.
	 * 
	 * @param worker
	 */
	void releaseWorker(Worker worker);

	/**
	 * This method will register the @param worker passed to it with the
	 * Manager.
	 * 
	 * @param worker
	 */
	void registerWorker(Worker worker);

	/**
	 * This method allow you to assign given work to a deamon worker available
	 * if no deamon Worker is available then it will create new and assign to
	 * the worker.
	 * 
	 * @param work
	 */
	void allocateDeamonWorker(Work work);

	/**
	 * This will return number of worker created using this manager.
	 * 
	 * @return
	 */
	int numberOfWorkers();

	/**
	 * This will return number of working workers.
	 * 
	 * @return
	 */
	int numberOfWorkingWorkers();
}

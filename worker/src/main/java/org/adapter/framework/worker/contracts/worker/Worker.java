package org.adapter.framework.worker.contracts.worker;

import org.adapter.framework.worker.contracts.work.Work;

/**
 * This interface allow to start a thread under the control of adapter
 * framework.
 * 
 * @author Anish Singh
 *
 */
public interface Worker {

	/**
	 * This method will start the work of the param work in separate thread.
	 * 
	 * @param work
	 */
	public void doWork(Work work);

}

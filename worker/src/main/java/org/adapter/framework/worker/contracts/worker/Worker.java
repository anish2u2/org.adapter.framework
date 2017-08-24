package org.adapter.framework.worker.contracts.worker;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.worker.contracts.work.Work;

/**
 * This interface allow to start a thread under the control of adapter
 * framework.
 * 
 * @author Anish Singh
 *
 */
public interface Worker extends InitBean, DestroyBean {

	/**
	 * This method lets you set the name of the worker.
	 * 
	 * @param name
	 */
	void setWorkerName(String name);

	/**
	 * This method will start the work of the param work in separate thread.
	 * 
	 * @param work
	 */
	public void doWork(Work work);

	/**
	 * returns true if the worker is free/available for work.
	 * 
	 * @return true by default if the worker is not working.
	 */
	public boolean isAvailable();

	/**
	 * returns true if the worker is not retierd/alive
	 * 
	 * @return
	 */
	public boolean isRetierd();

	/**
	 * This will tell the worker to work in background as a deamon.
	 * 
	 * @param backGroundWorker
	 */
	public void setAsBackGroundWorker(boolean backGroundWorker);

	/**
	 * This method will release the worker after completing the current work if
	 * the worker is doing any work.
	 */
	public void releaseWorker();

	/**
	 * This method will return true if the worker is backend worker otherwise
	 * false.
	 * 
	 * @return
	 */
	public boolean isBackEndWorker();
}

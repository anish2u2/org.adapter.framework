package org.adapter.framework.worker.contracts.worker;

/**
 * This Interface will represents the Factory class for hiring new Workers.
 * 
 * @author Anish Singh
 *
 */
public interface WorkerFactory {

	/**
	 * This method will hire new worker for doing work and if @param
	 * isBackGroundWorker true then it hire a back ground worker.
	 * 
	 * @param isBackGroundWorker
	 * @return
	 */
	public Worker hireNewWorker(boolean isBackGroundWorker);

}

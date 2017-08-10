package org.adapter.framework.worker.contracts.work;

/**
 * This interface will represents the work to be done by the Worker.
 * 
 * @author Anish Singh
 *
 */
public interface Work {

	/**
	 * This method will be implemented to run the code on a separate worker.
	 */
	void executeTask();

}

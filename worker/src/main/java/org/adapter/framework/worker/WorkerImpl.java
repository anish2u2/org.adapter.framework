package org.adapter.framework.worker;

import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;
import org.adapter.framework.worker.contracts.work.Work;
import org.adapter.framework.worker.contracts.worker.Worker;

public class WorkerImpl extends Thread implements Worker {

	Logger logger = LoggerFactory.getLogger();

	private String workerName;

	private boolean backGroundWorker = false;

	private boolean retierd = false;

	private boolean available = false;

	private boolean workerStarted = false;

	private boolean workerShutDown = false;

	private boolean releaseWorkerCommand = false;

	private Work work;

	public void init() {
		setDaemon(backGroundWorker);
	}

	public void doWork(Work work) {
		logger.info("Assigning work to a worker.");
		this.work = work;
		if (!workerStarted && !workerShutDown) {
			start();
		}
	}

	@Override
	public void run() {
		while (!releaseWorkerCommand) {
			if (work != null) {
				available = false;
				logger.info("Worker-" + workerName + " Starting executing of task.");
				work.executeTask();
				logger.info("Worker-" + workerName + " Task execution done.");
				work = null;
				available = true;
			} else {
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		workerShutDown = true;
	}

	public boolean isAvailable() {

		return available;
	}

	public boolean isRetierd() {

		return retierd;
	}

	public void setAsBackGroundWorker(boolean backGroundWorker) {
		this.backGroundWorker = backGroundWorker;
	}

	public void setWorkerName(String name) {
		this.workerName = name;
	}

	public void releaseWorker() {
		releaseWorkerCommand = true;
	}

	public boolean isBackEndWorker() {
		return super.isDaemon();
	}

}

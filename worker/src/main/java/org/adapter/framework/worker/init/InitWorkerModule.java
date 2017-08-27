package org.adapter.framework.worker.init;

import org.adapter.framework.commons.contracts.Module;
import org.adapter.framework.commons.contracts.ModuleContext;
import org.adapter.framework.commons.contracts.Registrar;
import org.adapter.framework.commons.eventRegistrar.ContextInitListenerRegistrar;
import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;
import org.adapter.framework.worker.annotation.Work;
import org.adapter.framework.worker.annotation.Worker;
import org.adapter.framework.worker.handler.WorkerAnnotationHandler;
import org.adapter.framework.worker.interceptor.WorkerInterceptor;
import org.adapter.framework.worker.listener.ContextInitListener;
import org.adapter.framework.worker.manager.WorkersManager;
import org.adapter.framework.worker.module.WorkerContext;

public class InitWorkerModule implements Module {
	Logger logger = LoggerFactory.getLogger();
	private ModuleContext moduleContext = null;
	private WorkerAnnotationHandler handler = null;
	private ContextInitListener lister = null;

	public void initModule() {
		logger.info("Initializing Worker Module.");
		startMemoryStatusInformerWorker();
		moduleContext = new WorkerContext();
		((WorkerContext) moduleContext).init();
		registerHandler(moduleContext);
		registerListeners(moduleContext);
		initInterceptors();
	}

	public void destroyModule() {
		logger.info("Destroying Worker Module.");
		((WorkerContext) moduleContext).destroy();
		lister.destroy();
		handler.destroy();
		logger.info("Module Successfully destroyed.");
	}

	private void registerListeners(ModuleContext moduleContext) {
		logger.info("Registering Context init listener.");
		Registrar registrar = ContextInitListenerRegistrar.getInstantce();
		lister = new ContextInitListener();
		lister.init();
		lister.setModuleContext(moduleContext);
		registrar.registerListener(lister);
		logger.info("Listener " + ContextInitListener.class.getName() + " Registered.");
	}

	private void registerHandler(ModuleContext context) {
		logger.info("Registering Annotation Handlers.");
		handler = new WorkerAnnotationHandler();
		handler.init();
		handler.setContext(context);
		handler.registerAnnotation(Worker.class);
		handler.registerAnnotation(Work.class);
		logger.info("Annotation handler registered all the annotation specific to this module.");
	}

	private void initInterceptors() {
		logger.info("Initializing Interceptor of Worker Module.");
		WorkerInterceptor workerInterceptor = new WorkerInterceptor();
		workerInterceptor.init();
	}

	@Override
	protected void finalize() throws Throwable {
		destroyModule();
		super.finalize();
	}

	private void startMemoryStatusInformerWorker() {
		WorkersManager.getInstance().allocateDeamonWorker(new org.adapter.framework.worker.contracts.work.Work() {

			public void executeTask() {
				Runtime runtime = Runtime.getRuntime();
				Long totlaMemory = runtime.totalMemory();
				while (true) {
					Long freeMemory = runtime.freeMemory();
					logger.info("Total Memo:" + totlaMemory + " Free Memo:" + freeMemory + " used by App:"
							+ (totlaMemory - freeMemory));
					try {
						Thread.sleep(1000);
					} catch (Exception ex) {
						logger.logException(ex);
					}
				}

			}
		});
	}

}

package org.adapter.framework.worker.interceptor;

import java.lang.reflect.Method;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.commons.registrar.AnnotationIntercepterRegistrarFactory;
import org.adapter.framework.utility.contracts.Interceptor;
import org.adapter.framework.utility.contracts.PostIntercept;
import org.adapter.framework.utility.contracts.PreIntercept;
import org.adapter.framework.worker.annotation.Work;
import org.adapter.framework.worker.annotation.Work.Type;
import org.adapter.framework.worker.annotation.Work.WorkType;
import org.adapter.framework.worker.contracts.manager.WorkManager;
import org.adapter.framework.worker.manager.WorkersManager;

import net.sf.cglib.proxy.MethodProxy;

/**
 * This Class will be used to intercept method which is annotated with @Work
 * annotation.
 * 
 * @author Anish Singh
 *
 */
public class WorkerInterceptor implements Interceptor, InitBean, DestroyBean {

	private PreIntercept preIntercept;

	private PostIntercept postIntercept;

	private WorkManager manager;

	public void init() {
		manager = WorkersManager.getInstance();
		AnnotationIntercepterRegistrarFactory.getInstance().registerInterceptor(this);
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Work work = method.getAnnotation(Work.class);
		boolean isNormalWork = WorkType.NORMAL.equals(work.workType());
		boolean isSynchronized = Type.SYNCHRONIZED.equals(work.type());
		if (preIntercept != null) {
			preIntercept.preIntercept();
		}
		if (isNormalWork) {
			manager.allocateWorker(getWork(isSynchronized, obj, args, proxy));
		} else {
			manager.allocateDeamonWorker(getWork(isSynchronized, obj, args, proxy));
		}
		if (postIntercept != null) {
			postIntercept.postIntercept();
		}
		return null;
	}

	public boolean isInterceptable(Method method) {

		return method.isAnnotationPresent(Work.class);
	}

	public void setMethodPreInterceptor(PreIntercept preIntercept) {
		this.preIntercept = preIntercept;
	}

	public void setMethodPostInterceptor(PostIntercept postIntercept) {
		this.postIntercept = postIntercept;
	}

	public void destroy() {
		postIntercept = null;
		preIntercept = null;
		manager = null;
	}

	/**
	 * This method will return the Annonymous class of Work interface
	 * implementation.
	 * 
	 * @param isSynchronized
	 * @param targetObject
	 * @param args
	 * @param proxy
	 * @return
	 */
	private org.adapter.framework.worker.contracts.work.Work getWork(final boolean isSynchronized,
			final Object targetObject, final Object[] args, final MethodProxy proxy) {
		return new org.adapter.framework.worker.contracts.work.Work() {

			public void executeTask() {
				try {
					if (isSynchronized) {
						synchronized (targetObject) {
							proxy.invokeSuper(targetObject, args);
						}
					} else {
						proxy.invokeSuper(targetObject, args);
					}

				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		};
	}

}

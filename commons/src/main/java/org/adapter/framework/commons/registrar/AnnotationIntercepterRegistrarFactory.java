package org.adapter.framework.commons.registrar;

import java.util.HashSet;
import java.util.Set;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.commons.contracts.InterceptorsRegistrar;
import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;
import org.adapter.framework.utility.contracts.Interceptor;

/**
 * This Class is the factory class Which will return the InterceptorRegistrar &
 * allow to register Interceptors.
 * 
 * @author Anish Singh
 *
 */
public class AnnotationIntercepterRegistrarFactory implements InterceptorsRegistrar, InitBean, DestroyBean {

	Logger logger = LoggerFactory.getLogger();

	private static AnnotationIntercepterRegistrarFactory annotationIntercepterRegistrarFactory = null;

	private Set<Interceptor> interceptors = null;

	{
		init();
	}

	private AnnotationIntercepterRegistrarFactory() {
		if (annotationIntercepterRegistrarFactory != null)
			throw new RuntimeException("Object already Created.");
	}

	/**
	 * This method return the instance of {@link InterceptorsRegistrar#}
	 * 
	 * @return
	 */
	public static InterceptorsRegistrar getInstance() {
		if (annotationIntercepterRegistrarFactory == null) {
			annotationIntercepterRegistrarFactory = new AnnotationIntercepterRegistrarFactory();
		}
		return annotationIntercepterRegistrarFactory;
	}

	public void registerInterceptor(Interceptor interceptor) {
		logger.info("Registering Interceptor:" + interceptor.getClass().getName());
		interceptors.add(interceptor);
	}

	public Set<Interceptor> getRegisteredInterceptors() {

		return interceptors;
	}

	public void destroy() {
		interceptors.clear();
		interceptors = null;
		annotationIntercepterRegistrarFactory = null;
	}

	public void init() {
		interceptors = new HashSet<Interceptor>();
	}

}

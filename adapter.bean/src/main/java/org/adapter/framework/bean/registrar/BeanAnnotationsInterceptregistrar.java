package org.adapter.framework.bean.registrar;

import org.adapter.framework.bean.contracts.registrar.BeanAnnotationInterceptRegistrar;
import org.adapter.framework.bean.registrar.abstracts.AbstractsBeanAnnotationInterceptorRegistrar;
import org.adapter.framework.utility.contracts.Intercept;

public class BeanAnnotationsInterceptregistrar extends AbstractsBeanAnnotationInterceptorRegistrar
		implements BeanAnnotationInterceptRegistrar {

	private static BeanAnnotationsInterceptregistrar annotationsInterceptregistrar;

	public void registerInterceptor(Intercept methodInterceptor) {
		register(methodInterceptor);
	}

	private BeanAnnotationsInterceptregistrar() {
		if (annotationsInterceptregistrar != null) {
			throw new RuntimeException("Object Already Created.");
		}
	}

	/**
	 * This will return the instance of the
	 * {@code BeanAnnotationInterceptRegistrar}
	 * 
	 * @return
	 */
	public static BeanAnnotationInterceptRegistrar getInstance() {
		if (annotationsInterceptregistrar == null) {
			annotationsInterceptregistrar = new BeanAnnotationsInterceptregistrar();
		}
		return annotationsInterceptregistrar;
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}

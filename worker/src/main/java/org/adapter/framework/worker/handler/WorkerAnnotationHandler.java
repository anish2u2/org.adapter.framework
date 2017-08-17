package org.adapter.framework.worker.handler;

import java.util.LinkedList;
import java.util.List;

import org.adapter.framework.commons.contracts.AnnotationHandler;
import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.commons.contracts.ModuleContext;

public class WorkerAnnotationHandler implements AnnotationHandler, InitBean, DestroyBean {

	private ModuleContext context;

	private List<Class<?>> registeredAnnotation;

	{
		registeredAnnotation = new LinkedList<Class<?>>();
	}

	public List<Class<?>> getAnnotations() {

		return registeredAnnotation;
	}

	public Object doHandle(Class<?> clazz) {

		return context.getBean(clazz);
	}

	public void registerAnnotation(Class<?> annotation) {
		this.registeredAnnotation.add(annotation);
	}

	public List<Class<?>> getRegisteredAnnotation() {
		return registeredAnnotation;
	}

	public void setRegisteredAnnotation(List<Class<?>> registeredAnnotation) {
		this.registeredAnnotation = registeredAnnotation;
	}

	public ModuleContext getContext() {
		return context;
	}

	public void setContext(ModuleContext context) {
		this.context = context;
	}

	public void destroy() {
		registeredAnnotation.clear();
		registeredAnnotation = null;
		context = null;

	}

	public void init() {

	}

}

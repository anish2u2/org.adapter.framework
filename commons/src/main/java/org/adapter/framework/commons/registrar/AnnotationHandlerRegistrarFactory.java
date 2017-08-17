package org.adapter.framework.commons.registrar;

import java.util.LinkedHashSet;
import java.util.Set;

import org.adapter.framework.commons.contracts.AnnotationHandler;
import org.adapter.framework.commons.contracts.AnnotationHandlerRegistrar;

public class AnnotationHandlerRegistrarFactory implements AnnotationHandlerRegistrar {

	private static AnnotationHandlerRegistrarFactory annotationHandlerRegistrar = null;
	private Set<AnnotationHandler> handlers;

	{
		handlers = new LinkedHashSet<AnnotationHandler>();
	}

	private AnnotationHandlerRegistrarFactory() {
		if (annotationHandlerRegistrar != null) {
			throw new RuntimeException("Object all ready created.");
		}
	}

	public static AnnotationHandlerRegistrar getInstance() {
		if (annotationHandlerRegistrar == null) {
			annotationHandlerRegistrar = new AnnotationHandlerRegistrarFactory();
		}
		return annotationHandlerRegistrar;
	}

	public void registerHandler(AnnotationHandler handler) {
		handlers.add(handler);
	}

	public Set<AnnotationHandler> getHandlers() {
		return handlers;
	}

}

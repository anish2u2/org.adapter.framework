package org.adapter.framework.bean.listener;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.adapter.framework.bean.annotation.PostConstructBean;
import org.adapter.framework.bean.annotation.PreConstructBean;
import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.utility.reflection.ReflectionUtility;

/**
 * This class will be responsible for listening bean creation event and invoking
 * bean init methods.
 * 
 * @author Anish Singh
 *
 */
public class BeanCreationListener
		implements org.adapter.framework.commons.contracts.BeanCreationListener, InitBean, DestroyBean {

	private List<Class<? extends Annotation>> annotations = new ArrayList<Class<? extends Annotation>>(3);
	{
		init();
	}

	public void listen(Object createdObject) {
		Class<?> targetClass = createdObject.getClass();
		Method[] methods = targetClass.getDeclaredMethods();
		Map<Integer, Method> foundMethods = new WeakHashMap<Integer, Method>(3);
		for (Method method : methods) {
			for (Class<? extends Annotation> clazz : annotations) {
				if (method.isAnnotationPresent(clazz)) {
					foundMethods.put(annotations.indexOf(clazz), method);
				}
			}
		}
		initiateAfterBeanCreationMethodInvocation(createdObject, foundMethods);

	}

	private void initiateAfterBeanCreationMethodInvocation(Object targetObject, Map<Integer, Method> mapOfMethods) {
		if (mapOfMethods.get(0) != null) {
			invoke(targetObject, mapOfMethods.get(0));
			if (mapOfMethods.get(1) != null) {
				invoke(targetObject, mapOfMethods.get(1));
			}
			if (mapOfMethods.get(2) != null) {
				invoke(targetObject, mapOfMethods.get(2));
			}

		} else {
			return;
		}
	}

	private void invoke(Object targetObject, Method method) {
		Class<?>[] parameters = method.getParameterTypes();
		Object[] args = new Object[parameters.length];
		int counter = 0;
		for (Class<?> clazz : parameters) {
			args[counter] = ReflectionUtility.getInstance().instanciateOject(clazz);
			counter++;
		}
		try {
			method.invoke(targetObject, args);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		annotations.clear();
		annotations = null;
	}

	public void init() {
		annotations.add(PreConstructBean.class);
		annotations.add(org.adapter.framework.bean.annotation.InitBean.class);
		annotations.add(PostConstructBean.class);
	}

}

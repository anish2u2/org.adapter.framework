package org.adapter.framework.utility.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.adapter.framework.bean.annotation.Component;
import org.adapter.framework.bean.annotation.Component.Scope;
import org.adapter.framework.utility.contracts.Reflection;

/**
 * This class will be used for creating objects in adapter framework.
 * 
 * @author Anish Singh
 * 
 * 
 *
 */

@Component(name = "reflectionUtil", scope = Scope.SINGLETONE)
public class ReflectionUtility implements Reflection {

	public Object instanciateOject(Class<?> clazz) {
		try {
			Constructor<?> constructor = getConstrcutor(clazz);
			if (constructor.getParameterTypes().length > 0) {
				Object[] args = new Object[constructor.getParameterTypes().length];
				int position = 0;
				for (Class<?> parameterClass : constructor.getParameterTypes()) {
					args[position] = instanciateOject(parameterClass);
				}

				return constructor.newInstance(args);

			} else {
				return constructor.newInstance(new Object[] {});
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * This method will try to find default constructor first if no default
	 * constructor were found then it will return the one which is available.
	 * * @param clazz
	 * 
	 * @return
	 */
	private Constructor<?> getConstrcutor(Class<?> clazz) {
		Constructor<?> construct = null;
		Constructor<?>[] constructors = null;
		if ((constructors = clazz.getDeclaredConstructors()).length > 0) {
			for (Constructor<?> constructor : constructors) {
				construct = constructor;
				if (!constructor.isVarArgs()) {
					if (!constructor.isAccessible()) {
						/**
						 * Try to set accessible of the default constructor.
						 * 
						 */
						setConstructorAccessible(constructor);
					}
					/**
					 * Found default public constructor return it immediatly.
					 */
					return constructor;
				}
			}
		}
		return construct;
	}

	/**
	 * This method will set Accessible the constructor.
	 * 
	 * @param constructor
	 */
	public void setConstructorAccessible(Constructor<?> constructor) {
		try {
			/**
			 * Setting accessible as we need to invoke constructor.
			 */
			constructor.setAccessible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean isAnnotated(Class<?> clazz, Class<?> annotationType) {
		for (Annotation annotation : clazz.getDeclaredAnnotations()) {
			if (annotation.annotationType().isAssignableFrom(annotationType)) {
				return true;
			}
		}
		return false;
	}

	public boolean isFieldAccessible(Field field) {
		return field.isAccessible();
	}

	public void setFieldAccessible(Field field) {
		try {
			field.setAccessible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean isMethodAccessible(Method method) {

		return method.isAccessible();
	}

	public void setMethodAccessible(Method method) {
		try {
			method.setAccessible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean isDeclaredMethodAnnotated(Method method, Class<?> annotationType) {
		for (Annotation annotation : method.getDeclaredAnnotations()) {
			if (annotation.annotationType().isAssignableFrom(annotationType)) {
				return true;
			}
		}
		return false;
	}

	public boolean isDeclaredFieldAnnotated(Field field, Class<?> annotationType) {
		for (Annotation annotation : field.getDeclaredAnnotations()) {
			if (annotation.annotationType().isAssignableFrom(annotationType)) {
				return true;
			}
		}
		return false;
	}

}

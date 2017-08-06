package org.adapter.framework.utility.imple;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.adapter.framework.bean.annotation.Component;
import org.adapter.framework.bean.annotation.Component.Scope;
import org.adapter.framework.utility.contracts.Reflection;

/**
 * 
 * @author Anish Singh
 * 
 *         This class will be used for creating objects in adapter framework.
 *
 */

@Component(name = "reflectionUtil", scope = Scope.SINGLETONE)
public class ReflectionUtility implements Reflection {

	public Object instanciateOject(Class<?> clazz) {

		return null;
	}

	public boolean isAnnotated(Class<?> clazz, Class<?> annotationType) {

		return false;
	}

	public boolean isDeclearedMethodAnnotated(Method method, Class<?> annotationType) {

		return false;
	}

	public boolean isDeclearedFieldAnnotated(Field field, Class<?> annotationType) {

		return false;
	}

	public boolean isFieldAccessible(Field field) {

		return false;
	}

	public void setFieldAccessible(Field field) {

	}

	public boolean isMethodAccessible(Method method) {

		return false;
	}

	public void setMethodAccessible(Method method) {

	}

}

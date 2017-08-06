package org.adapter.framework.utility.contracts;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * @author Anish Singh
 *
 *         This interface will help in creating objects using reflection
 *         provides methods which has to be implemented by implementor class.
 *
 */

public interface Reflection {

	public Object instanciateOject(Class<?> clazz);

	public boolean isAnnotated(Class<?> clazz, Class<?> annotationType);

	public boolean isDeclearedMethodAnnotated(Method method, Class<?> annotationType);

	public boolean isDeclearedFieldAnnotated(Field field, Class<?> annotationType);

	public boolean isFieldAccessible(Field field);

	public void setFieldAccessible(Field field);

	public boolean isMethodAccessible(Method method);

	public void setMethodAccessible(Method method);

}

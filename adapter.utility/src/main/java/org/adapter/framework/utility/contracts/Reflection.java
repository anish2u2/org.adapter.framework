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

	/**
	 * This method will create the class type of object.
	 * 
	 * @param clazz
	 * @return
	 */
	public Object instanciateOject(Class<?> clazz);

	/**
	 * THis method will tell that given class is containing the annotation.
	 * 
	 * @param clazz
	 * 
	 * @param annotationType
	 * 
	 * @return
	 */
	public boolean isAnnotated(Class<?> clazz, Class<?> annotationType);

	/**
	 * This method tells that declared method annotated with the given
	 * annotation type.
	 * 
	 * @param method
	 * @param annotationType
	 * @return
	 */
	public boolean isDeclaredMethodAnnotated(Method method, Class<?> annotationType);

	/**
	 * This method lets you know that the declared field is annotated with the
	 * given annotation.
	 * 
	 * @param field
	 * @param annotationType
	 * @return
	 */
	public boolean isDeclaredFieldAnnotated(Field field, Class<?> annotationType);

	/**
	 * This method tell you that Field is accessible.
	 * 
	 * @param field
	 * @return
	 */
	public boolean isFieldAccessible(Field field);

	/**
	 * This method allow you to modify the given field to be accessible.
	 * 
	 * @param field
	 */
	public void setFieldAccessible(Field field);

	/**
	 * This method tell you that the given method is accessible or not.
	 * 
	 * @param method
	 * @return
	 */
	public boolean isMethodAccessible(Method method);

	/**
	 * This method allow you to modify accessibility of the method.
	 * 
	 * @param method
	 */
	public void setMethodAccessible(Method method);

}

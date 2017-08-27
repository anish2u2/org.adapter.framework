package org.adapter.framework.commons.utility;

import java.util.Map;
import java.util.WeakHashMap;

import org.adapter.framework.commons.contracts.ThreadStack;

/**
 * This class will allow to maintain thread local objects.
 * 
 * @author Anish Singh
 *
 */
public class ThreadStackUtility implements ThreadStack {

	private static ThreadStack threadUtility;

	private final Map<Object, ThreadLocal<Map<Object, Object>>> globalThreadStack = new WeakHashMap<Object, ThreadLocal<Map<Object, Object>>>();

	private ThreadStackUtility() {
		if (threadUtility != null)
			throw new RuntimeException("Object Already Created.");
	}

	/**
	 * This method will return ThreadStack instance corresponding to the current
	 * Thread.
	 * 
	 * @return
	 */
	public static ThreadStack getInstance() {
		if (threadUtility == null) {
			threadUtility = new ThreadUtility();
		}
		if (((ThreadUtility) threadUtility).getThreadStack() == null) {
			((ThreadUtility) threadUtility).globalThreadStack.put(Thread.currentThread().getId(),
					new ThreadLocal<Map<Object, Object>>());
		}
		return threadUtility;
	}

	private ThreadLocal<Map<Object, Object>> getThreadStack() {
		return globalThreadStack.get(Thread.currentThread().getId());
	}

	public void addObject(Object key, Object value) {
		getThreadStack().get().put(key, value);
	}

	public Object getObject(Object key) {

		return getThreadStack().get().get(key);
	}

	public void removeObject(Object key) {
		getThreadStack().get().remove(key);
	}

	public Object pullObject(Object key) {
		Object result = getThreadStack().get().get(key);
		if (result != null) {
			getThreadStack().get().remove(key);
		}
		return result;
	}

	public void clearStack() {
		getThreadStack().get().clear();
	}

}

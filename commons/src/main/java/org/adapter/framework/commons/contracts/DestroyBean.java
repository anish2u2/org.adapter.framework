package org.adapter.framework.commons.contracts;

/**
 * This interface represents the destroy method of bean used by each module to
 * destroy their beans.
 * 
 * @author Anish Singh
 *
 */
public interface DestroyBean {
	/**
	 * This method will be used to release the resources hold by the bean before
	 * allowing the object to be garbage collected.
	 */
	void destroy();

}

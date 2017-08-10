package org.framework.adapter.contracts.lifeCycle;

import org.framework.adapter.contracts.destroy.DestroyFramework;
import org.framework.adapter.contracts.init.InitFramework;

/**
 * This interface will represents the life cycle of the framework.
 * 
 * @author Anish Singh
 *
 */
public interface Adapter extends InitFramework, DestroyFramework {
	/**
	 * This method is responsible for loading and processing the app which will
	 * use this framework.
	 */
	void processApp();

}

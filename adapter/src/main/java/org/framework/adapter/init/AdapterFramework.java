package org.framework.adapter.init;

import org.framework.adapter.init.abstracts.AbstractAdapterFramework;

/**
 * This class is responsible for loading and processing app.
 * 
 * @author Anish Singh
 *
 */
public class AdapterFramework extends AbstractAdapterFramework {

	private static AdapterFramework framework = null;

	static {
		framework = new AdapterFramework();
	}

	private AdapterFramework() {
		if (framework != null)
			throw new RuntimeException("Object Already created.");
	}

	/**
	 * This method is responsible to process the app execution.
	 * 
	 */
	public void processApp() {

	}

	public static final void main(String args[]) {
		framework.init();
		framework.processApp();
		framework.destroy();
	}

	@Override
	protected void finalize() throws Throwable {
		framework.destroy();
		framework = null;
	}

}

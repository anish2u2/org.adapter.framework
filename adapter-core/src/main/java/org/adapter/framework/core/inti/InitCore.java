package org.adapter.framework.core.inti;

import org.adapter.framework.commons.contracts.Module;
import org.adapter.framework.core.contracts.module.ModuleLoader;
import org.adapter.framework.core.loaders.ModulesLoader;

/**
 * This Class is responsible for initializing and destroying all other modules.
 * 
 * @author Anish Singh
 *
 */
public class InitCore implements Module {

	private ModuleLoader modulesLoader;

	{
		modulesLoader = ModulesLoader.getInstance();
	}

	public void initModule() {
		modulesLoader.loadModules();
	}

	public void destroyModule() {
		modulesLoader.unloadModules();
	}

}

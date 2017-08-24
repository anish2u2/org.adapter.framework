package org.adapter.framework.core.loaders;

import java.net.URL;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.core.contracts.module.ModuleLoader;
import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;
import org.adapter.framework.utility.contracts.FileProcessing;
import org.adapter.framework.utility.contracts.FilterRegistrar;
import org.adapter.framework.utility.file.FileManager;

public class ModulesLoader implements ModuleLoader, InitBean, DestroyBean {

	private Logger logger = LoggerFactory.getLogger();

	private static ModuleLoader loader = null;

	private FileProcessing fileManager;

	private FilterRegistrar registrar;

	private ModulesLoader() {
		logger.info("Reading Configuration and Classes.");
		logger.info("Starting Reading location:" + getJarLocation().toString());
		fileManager.readJar(getJarLocation().toString(), registrar.getRegisteredFilters());

	}

	/**
	 * This will return the ModuleLodaer instance.
	 * 
	 * @return
	 */
	public static ModuleLoader getInstance() {
		if (loader == null) {
			loader = new ModulesLoader();
		}
		return loader;
	}

	public void loadModules() {
		
	}

	public void unloadModules() {

	}

	public void destroy() {
		loader = null;
		fileManager = null;
		registrar = null;
	}

	public void init() {
		fileManager = FileManager.getInstance();
		registrar = org.adapter.framework.core.registrar.FilterRegistrar.getInstance();

	}

	@Override
	protected void finalize() throws Throwable {
		destroy();
		super.finalize();
	}

	private URL getJarLocation() {
		return this.getClass().getProtectionDomain().getCodeSource().getLocation();
	}

}

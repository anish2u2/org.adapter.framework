package org.adapter.framework.core.loaders;

import java.net.URL;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.commons.contracts.Module;
import org.adapter.framework.core.conf.ModuleConfig;
import org.adapter.framework.core.contracts.module.ModuleLoader;
import org.adapter.framework.core.filter.FileFilter;
import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;
import org.adapter.framework.utility.contracts.DocumentManager;
import org.adapter.framework.utility.contracts.FileProcessing;
import org.adapter.framework.utility.contracts.FilterRegistrar;
import org.adapter.framework.utility.contracts.Reflection;
import org.adapter.framework.utility.doc.DocumentManagerUtility;
import org.adapter.framework.utility.file.FileManager;
import org.adapter.framework.utility.reflection.ReflectionUtility;

public class ModulesLoader implements ModuleLoader, InitBean, DestroyBean {

	private Logger logger = LoggerFactory.getLogger();

	private static ModuleLoader loader = null;

	private FileProcessing fileManager;

	private FilterRegistrar registrar;

	private DocumentManager documentManager;

	private Reflection reflection;

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

		for (org.adapter.framework.utility.contracts.FileFilter filter : registrar.getRegisteredFilters()) {
			if (((FileFilter) filter).getSuffix() != null && ((FileFilter) filter).getSuffix().endsWith(".xml")) {
				for (String fileName : filter.filteredFileNames()) {
					ModuleConfig moduleConfig = (ModuleConfig) documentManager.readXML(fileName, ModuleConfig.class);
					try {
						logger.info("initializing module:" + moduleConfig.getName());
						reflection
								.instanciateOject(Class.forName(moduleConfig.getModuleInitInfo().getInitModuleClass()));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public void unloadModules() {

	}

	public void destroy() {
		loader = null;
		fileManager = null;
		registrar = null;
		reflection = null;
	}

	public void init() {
		fileManager = FileManager.getInstance();
		registrar = org.adapter.framework.core.registrar.FilterRegistrar.getInstance();
		documentManager = DocumentManagerUtility.getInstance();
		reflection = ReflectionUtility.getInstance();
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

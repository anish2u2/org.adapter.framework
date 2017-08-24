package org.adapter.framework.core.registrar;

import java.util.LinkedList;
import java.util.List;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;
import org.adapter.framework.utility.contracts.FileFilter;

public class FilterRegistrar implements org.adapter.framework.utility.contracts.FilterRegistrar, InitBean, DestroyBean {

	private static org.adapter.framework.utility.contracts.FilterRegistrar registrar = null;

	private List<FileFilter> fileFilters;

	{
		init();
	}

	private FilterRegistrar() {
		if (registrar != null) {
			throw new RuntimeException("Object Already Created.");
		}
	}

	/**
	 * This method will return the instance of the FilterRegistrar.
	 * 
	 * @return
	 */
	public static org.adapter.framework.utility.contracts.FilterRegistrar getInstance() {
		if (registrar == null) {
			registrar = new FilterRegistrar();
		}
		return registrar;
	}

	public void registerFilter(FileFilter filter) {
		fileFilters.add(filter);
	}

	public void removeFilter(FileFilter filter) {
		fileFilters.remove(filter);
	}

	public List<FileFilter> getRegisteredFilters() {

		return fileFilters;
	}

	public void destroy() {
		fileFilters.clear();
		fileFilters = null;
		registrar = null;
	}

	public void init() {
		fileFilters = new LinkedList<FileFilter>();
		org.adapter.framework.core.filter.FileFilter clazzFilter = new org.adapter.framework.core.filter.FileFilter();
		clazzFilter.setSuffix(".class");
		clazzFilter.init();
		fileFilters.add(clazzFilter);
		org.adapter.framework.core.filter.FileFilter moduleConfigFilter = new org.adapter.framework.core.filter.FileFilter();
		moduleConfigFilter.setSuffix("module-conf.xml");
		moduleConfigFilter.init();
		fileFilters.add(moduleConfigFilter);
	}

	@Override
	protected void finalize() throws Throwable {
		destroy();
		super.finalize();
	}

}

package org.adapter.framework.utility.contracts;

public interface FilterRegistrar {

	public void registerFilter(FileFilter filter);

	public void removeFilter(FileFilter filter);
}

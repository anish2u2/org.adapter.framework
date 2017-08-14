package org.adapter.framework.utility.scanner;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.adapter.framework.utility.contracts.ClassPathScanner;
import org.adapter.framework.utility.contracts.FileFilter;
import org.adapter.framework.utility.contracts.FilterRegistrar;
import org.adapter.framework.utility.contracts.PathScannerResult;
import org.adapter.framework.utility.file.FileManager;

public class PathScanner implements ClassPathScanner {

	private static final List<FilterRegistrar> listOfFilterRegistrar = new LinkedList<FilterRegistrar>();

	private static List<FileFilter> listOfFileFilters = new LinkedList<FileFilter>();

	private List<PathScannerResult> pathScanningresult = new LinkedList<PathScannerResult>();

	@Override
	public void registerFilter(FilterRegistrar registrar) {
		listOfFilterRegistrar.add(registrar);
	}

	@Override
	public void unRegisterFilters() {
		listOfFileFilters.clear();
	}

	@Override
	public void unRegisterFilters(FilterRegistrar filterRegistrar) {
		listOfFilterRegistrar.remove(filterRegistrar);
	}

	/**
	 * First register all the FileFilters using FilterRegistrar then do path
	 * scan. So that this method could filter result.Other wise it will return
	 * unexpected result null.
	 */
	@Override
	public List<Class<?>> scan() {
		FileManager fileManager = new FileManager();

		for (FilterRegistrar filterRegistrar : listOfFilterRegistrar) {
			listOfFileFilters.addAll(filterRegistrar.getRegisteredFilters());
		}
		listOfFileFilters = fileManager.readJar(getAppPath().toString(), listOfFileFilters);
		for (final FileFilter fileFilter : listOfFileFilters) {
			pathScanningresult.add(new PathScannerResult() {
				private FileFilter filter = fileFilter;

				@Override
				public List<String> getResult(FileFilter fileFilter) {
					if (fileFilter.equals(filter)) {
						return filter.filteredFileNames();
					}
					return null;
				}
			});
		}
		return null;
	}

	/*@Override
	public boolean isFileExist(FileFilter fileFilter) {
		if(listOfFileFilters.contains(fileFilter) && listOfFileFilters.)
		return false;
	}*/

	/*@Override
	public File getFile(FileFilter fileFilter) {

		return null;
	}*/

	private URL getAppPath() {
		return this.getClass().getProtectionDomain().getCodeSource().getLocation();
	}
}

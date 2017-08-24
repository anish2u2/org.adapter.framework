package org.adapter.framework.core.filter;

import java.util.LinkedList;
import java.util.List;

import org.adapter.framework.commons.contracts.DestroyBean;
import org.adapter.framework.commons.contracts.InitBean;

public class FileFilter implements org.adapter.framework.utility.contracts.FileFilter, InitBean, DestroyBean {

	private String prefix;

	private String suffix;

	private List<String> listOfreadedFiles;

	public void filter(String fileName) {
		String actualFileName = fileName.substring(fileName.indexOf('.'));
		if (prefix != null && actualFileName.startsWith(prefix) && suffix != null && actualFileName.endsWith(suffix)) {
			listOfreadedFiles.add(fileName);
		} else if (prefix != null && actualFileName.startsWith(prefix)) {
			listOfreadedFiles.add(fileName);
		} else if (suffix != null && actualFileName.endsWith(suffix)) {
			listOfreadedFiles.add(fileName);
		}
	}

	public void addFileName(String fullyQualifiedFileName) {

	}

	public List<String> filteredFileNames() {

		return null;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void destroy() {
		listOfreadedFiles.clear();
		listOfreadedFiles = null;
		prefix = null;
		suffix = null;
	}

	public void init() {
		listOfreadedFiles = new LinkedList<String>();
	}
	
}

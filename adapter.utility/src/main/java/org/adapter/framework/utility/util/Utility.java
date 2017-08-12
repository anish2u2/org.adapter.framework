package org.adapter.framework.utility.util;

import org.adapter.framework.bean.annotation.Component;
import org.adapter.framework.bean.annotation.InjectBean;
import org.adapter.framework.bean.annotation.Component.Scope;
import org.adapter.framework.utility.contracts.DocumentManager;
import org.adapter.framework.utility.contracts.FileProcessing;
import org.adapter.framework.utility.contracts.Reflection;

@Component(name = "utility", scope = Scope.SINGLETONE)
public class Utility {

	@InjectBean(qualifier = "docManager")
	private DocumentManager docManager;

	@InjectBean(qualifier = "reflectionUtil")
	private Reflection reflectionManager;

	@InjectBean(qualifier = "fileManager")
	private FileProcessing fileProcessing;

	public final FileProcessing getFileManager() {
		return this.fileProcessing;
	}

	public final DocumentManager getDocManager() {
		return this.docManager;
	}

	public final Reflection getReflectionManager() {
		return this.reflectionManager;
	}
}

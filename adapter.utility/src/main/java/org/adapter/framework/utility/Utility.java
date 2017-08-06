package org.adapter.framework.utility;

import org.adapter.framework.bean.annotation.Component;
import org.adapter.framework.bean.annotation.InjectBean;
import org.adapter.framework.bean.annotation.Component.Scope;
import org.adapter.framework.utility.contracts.DocumentManager;
import org.adapter.framework.utility.contracts.Reflection;

@Component(name = "utility", scope = Scope.SINGLETONE)
public class Utility {

	@InjectBean(qualifier = "docManager")
	private DocumentManager docManager;

	@InjectBean(qualifier = "reflectionUtil")
	private Reflection reflectionManager;

	public final DocumentManager getDocManager() {
		return this.docManager;
	}

	public final Reflection getReflectionManager() {
		return this.reflectionManager;
	}
}

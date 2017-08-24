package org.adapter.framework.core.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * This will represent the init class and base package to finding classes.
 * 
 * @author Anish Singh
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ModuleInitInfo {

	@XmlAttribute(name = "init-class")
	private String initModuleClass;

	@XmlAttribute(name = "name")
	private String basePackage;

	public String getInitModuleClass() {
		return initModuleClass;
	}

	public void setInitModuleClass(String initModuleClass) {
		this.initModuleClass = initModuleClass;
	}

}

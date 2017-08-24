package org.adapter.framework.core.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class will represent the module config.
 * 
 * @author Anish Singh
 *
 */

@XmlRootElement(name = "module")
@XmlAccessorType(XmlAccessType.FIELD)
public class ModuleConfig {

	@XmlElement(name = "base-package")
	private ModuleInitInfo moduleInitInfo;

	@XmlAttribute(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ModuleInitInfo getModuleInitInfo() {
		return moduleInitInfo;
	}

	public void setModuleInitInfo(ModuleInitInfo moduleInitInfo) {
		this.moduleInitInfo = moduleInitInfo;
	}

}

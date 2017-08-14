package org.adapter.framework.commons.contracts;

import java.util.Set;

public interface ContextPipe {

	Set<ModuleContext> getModuleContexts();

	void addModuleContext(ModuleContext moduleContext);

}

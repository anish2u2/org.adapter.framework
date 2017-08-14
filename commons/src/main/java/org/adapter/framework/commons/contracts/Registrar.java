package org.adapter.framework.commons.contracts;

import java.util.Set;

public interface Registrar {

	void registerListener(Listener listener);

	Set<Listener> getListeners();
}

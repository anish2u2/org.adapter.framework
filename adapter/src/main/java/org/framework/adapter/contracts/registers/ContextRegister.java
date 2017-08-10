package org.framework.adapter.contracts.registers;

import org.framework.adapter.contracts.context.Context;

/**
 * This interface allow to register different context.
 * 
 * @author Anish Singh
 *
 */
public interface ContextRegister {

	/**
	 * This method will register the Context.
	 * 
	 * @param context
	 */
	void registerContext(Context context);

}

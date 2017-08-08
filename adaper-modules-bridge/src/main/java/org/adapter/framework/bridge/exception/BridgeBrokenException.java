package org.adapter.framework.bridge.exception;

public class BridgeBrokenException extends RuntimeException {

	/**
	 * @author Anish Singh
	 * 
	 *         This exception will be throws when the bridge is broken will
	 *         communicating through the bridge.
	 */
	private static final long serialVersionUID = 1L;

	public BridgeBrokenException(String message) {
		super(message);
	}

}

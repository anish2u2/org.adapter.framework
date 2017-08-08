package org.adapter.framework.bridge.exception;

public class BridgeConnectionException extends RuntimeException {

	/**
	 * @author Anish Singh
	 * 
	 *         This will be used to throw when the bridge is not stablished
	 *         between two modules.
	 * 
	 */
	private static final long serialVersionUID = 34545986L;

	public BridgeConnectionException(String message) {
		super(message);
	}

}

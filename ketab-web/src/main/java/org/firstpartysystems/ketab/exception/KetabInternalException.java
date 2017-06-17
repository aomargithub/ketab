package org.firstpartysystems.ketab.exception;

public class KetabInternalException extends KetabException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8382492893633894444L;
	
	private final Exception internalException;
	
	
	public KetabInternalException(Exception internalException){
		this.internalException = internalException;
	}


	public Exception getInternalException() {
		return internalException;
	}
}

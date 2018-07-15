package br.com.simplustec.application.exception;

public class InvalidDateFormatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1638701152204027415L;
	
	public InvalidDateFormatException(String message) {
		super(message);
	}

}

package br.com.simplustec.application.exception;

public class MyFileNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2897778472149211263L;

	public MyFileNotFoundException(String message) {
		super(message);
	}

	public MyFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}

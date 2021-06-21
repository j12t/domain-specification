package com.jt93.domain.specification.exception;

@SuppressWarnings("serial")
public class InvalidTypeException extends RuntimeException {
	public InvalidTypeException() {
		super();
	}

	public InvalidTypeException(String message) {
		super(message);
	}

	public InvalidTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTypeException(Throwable cause) {
		super(cause);
	}

}

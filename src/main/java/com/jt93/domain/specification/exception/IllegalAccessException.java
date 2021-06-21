package com.jt93.domain.specification.exception;

@SuppressWarnings("serial")
public class IllegalAccessException extends RuntimeException {
	public IllegalAccessException() {
		super();
	}

	public IllegalAccessException(String message) {
		super(message);
	}

	public IllegalAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalAccessException(Throwable cause) {
		super(cause);
	}

}

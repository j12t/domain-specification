package com.jt93.domain.specification.exception;

@SuppressWarnings("serial")
public class NoSuchFieldException extends RuntimeException {

	public NoSuchFieldException() {
		super();
	}

	public NoSuchFieldException(String message) {
		super(message);
	}

	public NoSuchFieldException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchFieldException(Throwable cause) {
		super(cause);
	}

}

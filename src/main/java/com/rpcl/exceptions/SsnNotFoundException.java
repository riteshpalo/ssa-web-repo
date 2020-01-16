package com.rpcl.exceptions;

public class SsnNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7005011602033924414L;

	public SsnNotFoundException() {
		super();
	}

	public SsnNotFoundException(String message) {
		super(message);
	}
	
}

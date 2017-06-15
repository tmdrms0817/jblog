package com.jx372.jblog.exception;

public class UserInsertException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserInsertException() {
		super("UserInsertException");
	}

	public UserInsertException(String msg) {
		super(msg);
	}

}

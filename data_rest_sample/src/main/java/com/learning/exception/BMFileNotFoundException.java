package com.learning.exception;

public class BMFileNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6581904996823428317L;

	public BMFileNotFoundException(Long fileId) {
		super("could not find bookmark file id '" + fileId + "'.");
	}
}

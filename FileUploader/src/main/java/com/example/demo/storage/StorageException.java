package com.example.demo.storage;

public class StorageException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2130410836897966016L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}

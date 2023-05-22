package com.creche.crecheapp.exception;

public class FileStorageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1319001037424850807L;
	public FileStorageException(String message) {
		super(message);
	}
	public FileStorageException(String message, Throwable cause) {
		super(message, cause);
	}

}

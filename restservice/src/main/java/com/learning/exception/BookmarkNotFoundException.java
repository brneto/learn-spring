package com.learning.exception;

public class BookmarkNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1397782944913251067L;

	public BookmarkNotFoundException(Long bookmarkId) {
		super("could not find bookmark '" + bookmarkId + "'.");
	}
}

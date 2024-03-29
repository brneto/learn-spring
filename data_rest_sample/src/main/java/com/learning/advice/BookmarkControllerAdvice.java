package com.learning.advice;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.learning.exception.BMFileNotFoundException;
import com.learning.exception.BookmarkNotFoundException;
import com.learning.exception.UserNotFoundException;

@ControllerAdvice
public class BookmarkControllerAdvice {
	private String logref = "error";
	
	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors userNotFoundExceptionHandler(UserNotFoundException ex) {
		return new VndErrors(logref, ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(BookmarkNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors bookmarkNotFoundExceptionHandler(BookmarkNotFoundException ex) {
		return new VndErrors(logref, ex.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(BMFileNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors bmfileNotFoundExceptionHandler(BMFileNotFoundException ex) {
		return new VndErrors(logref, ex.getMessage());
	}
}
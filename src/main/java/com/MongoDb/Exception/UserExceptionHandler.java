package com.MongoDb.Exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<String> handleDuplicateKeyException(DuplicateKeyException duplicateKeyException) {
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(duplicateKeyException.getMessage());

	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleNoSuchElementException(UserNotFoundException noSuchElementException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(noSuchElementException.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");

	}

}

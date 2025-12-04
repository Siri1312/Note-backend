package com.codegnan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	    // Handle invalid or missing note ID
	    @ExceptionHandler(InvalidNoteIdException.class)
	    public ResponseEntity<String> handleInvalidNoteId(InvalidNoteIdException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }

	    // Handle all other unexpected exceptions
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGeneric(Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Something went wrong: " + ex.getMessage());
	    }
	}



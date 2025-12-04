package com.codegnan.exception;

public class InvalidNoteIdException extends Exception {
	 public InvalidNoteIdException(String message) {
	        super(message);
	    }

	    public InvalidNoteIdException(Long id) {
	        super("Invalid Note ID: " + id);
	    }
	}


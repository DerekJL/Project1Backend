package com.revature.exceptions;

public class ExerciseNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ExerciseNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExerciseNotFoundException(String message) {
		super(message);
	}

	public ExerciseNotFoundException(Throwable cause) {
		super(cause);
	}

}

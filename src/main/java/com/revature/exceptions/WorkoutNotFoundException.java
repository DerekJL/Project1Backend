package com.revature.exceptions;

public class WorkoutNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public WorkoutNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public WorkoutNotFoundException(String message) {
		super(message);
	}

	public WorkoutNotFoundException(Throwable cause) {
		super(cause);
	}

}

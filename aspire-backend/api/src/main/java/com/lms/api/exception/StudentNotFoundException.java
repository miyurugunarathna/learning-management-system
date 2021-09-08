package com.lms.api.exception;

public class StudentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2L;
	
	public StudentNotFoundException(String id) {
	    super("Could not find student " + id);
	  }
}

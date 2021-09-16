package com.lms.api.exception;

public class TeacherNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 3;
	
	public TeacherNotFoundException(String id) {
	    super("Could not find teacher " + id);
	  }
}
